package id.co.telkomsigma.tmf.security.api;

import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.AuthTokenDataRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 9/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IAuthenticationTokenEndPoint {

    @PostMapping("/login")
    @ApiOperation(value = "Auth", notes = "Authenticating Users",  response = ResponseData.class)
    ResponseEntity<?> auth(@RequestBody AuthTokenDataRequest authTokenDataRequest);

    @GetMapping("/refresh")
    ResponseEntity<?> refresh(HttpServletRequest request);
}
