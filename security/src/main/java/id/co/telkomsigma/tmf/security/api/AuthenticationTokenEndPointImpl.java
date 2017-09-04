package id.co.telkomsigma.tmf.security.api;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.AuthTokenDataRequest;
import id.co.telkomsigma.tmf.data.dto.response.AuthTokenDataResponse;
import id.co.telkomsigma.tmf.security.service.SigmaUserDetailsService;
import id.co.telkomsigma.tmf.security.util.JwtTokenUtils;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 9/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@Api(value = "API Authentication", description = "Rest Web Service Authenticating Users")
@RequestMapping("/auth")
public class AuthenticationTokenEndPointImpl implements IAuthenticationTokenEndPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationTokenEndPointImpl.class);

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    SigmaUserDetailsService sigmaUserDetailsService;

    private EResponseCode responseCode;

    @Override
    public ResponseEntity<?> auth(@RequestBody AuthTokenDataRequest authTokenDataRequest) {
        if(authTokenDataRequest == null){
            LOGGER.info("1");
            setResponseCode(EResponseCode.RC_BAD_REQUEST);
            return abort();
        }
        try {
            Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authTokenDataRequest.getUserName(),
                        authTokenDataRequest.getPassword())
                );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (BadCredentialsException bce) {
            setResponseCode(EResponseCode.RC_BAD_CREDENTIALS);
            return abort();
        } catch (AuthenticationException ae) {
            setResponseCode(EResponseCode.RC_BAD_CREDENTIALS);
            return abort();
        } catch (Exception e) {
            setResponseCode(EResponseCode.RC_FAILURE);
            return abort();
        }

        AuthTokenDataResponse authTokenDataResponse = new AuthTokenDataResponse();
        try {
            UserDetails userDetails = this.sigmaUserDetailsService.loadUserByUsername(authTokenDataRequest.getUserName());
            String token = this.jwtTokenUtils.generateToken(userDetails, new Device() {
                @Override
                public boolean isNormal() {
                    return true;
                }

                @Override
                public boolean isMobile() {
                    return false;
                }

                @Override
                public boolean isTablet() {
                    return false;
                }

                @Override
                public DevicePlatform getDevicePlatform() {
                    return null;
                }
            });
            authTokenDataResponse.setToken(token);
        } catch (Exception e) {
            setResponseCode(EResponseCode.RC_FAILURE);
            return abort();
        }
        return ResponseEntity.ok(authTokenDataResponse);
    }

    @Override
    public ResponseEntity<?> refresh(HttpServletRequest request) {
        try {
            String token = request.getHeader(this.tokenHeader);
            if (this.jwtTokenUtils.canTokenBeRefreshed(token)) {
                String refreshedToken = this.jwtTokenUtils.refreshToken(token);
                AuthTokenDataResponse authTokenDataResponse = new AuthTokenDataResponse();
                authTokenDataResponse.setToken(refreshedToken);
                return ResponseEntity.ok(authTokenDataResponse);
            } else {
                SecurityContextHolder.clearContext();
                setResponseCode(EResponseCode.RC_BAD_CREDENTIALS);
                return abort();
            }
        } catch (Exception e) {
            SecurityContextHolder.clearContext();
            LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_ENDPOINT, e);
            setResponseCode(EResponseCode.RC_ACCESS_DENIED);
            return abort();
        }
    }


    public ResponseEntity<?> abort() {
        ResponseData responseData = new ResponseData();
        responseData.setResponseCode(getResponseCode().getResponseCode());
        responseData.setResponseMsg(getResponseCode().getResponseMsg());
        return ResponseEntity.status(getResponseCode().getHttpResponse()).contentType(MediaType.APPLICATION_JSON).body(responseData);
    }

    public EResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(EResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}
