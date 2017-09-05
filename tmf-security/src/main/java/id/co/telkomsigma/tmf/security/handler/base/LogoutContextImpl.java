package id.co.telkomsigma.tmf.security.handler.base;


import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.security.util.JwtTokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@RestController
public class LogoutContextImpl implements ILogoutContext {
	
	private static Logger LOGGER = LoggerFactory.getLogger(LogoutContextImpl.class);

	@Autowired
	private HttpServletRequest request;

	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	private JwtTokenUtils tokenUtils;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request) throws IOException, ServletException {
		this.setRequest(request);
		this.onLogoutSuccess();
	}
	
	@Override
	public void onLogoutSuccess() throws IOException, ServletException {

	}

	@Override
	public ResponseData onLogoutSuccessJwt() throws IOException, ServletException {
		ResponseData responseData = new ResponseData(EResponseCode.RC_LOGOUT_FAILED.getResponseCode(), EResponseCode.RC_LOGOUT_FAILED.getResponseMsg());
		String tokenValue = null;
		if (this.request != null) {
				tokenValue = this.request.getHeader(tokenHeader);
		}
		LOGGER.info("Token Value "+tokenValue);
		if(tokenValue != null){
			tokenUtils.setTokenToBeExpired(tokenValue);
			LOGGER.info("Token Set To Expired XX");
			try {
				SecurityContextHolder.clearContext();
				LOGGER.info("Context Security Cleared");
				responseData = new ResponseData(EResponseCode.RC_LOGOUT_SUCCESS.getResponseCode(), EResponseCode.RC_LOGOUT_SUCCESS.getResponseMsg());
			} catch (Exception e) {
				LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_LOGOUT, e);
			}
		}else{
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_LOGOUT);
		}
		return responseData;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}	

}
