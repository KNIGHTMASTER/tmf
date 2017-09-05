package id.co.telkomsigma.tmf.security.handler.base;

import id.co.telkomsigma.tmf.data.dto.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
@Api(value = "API Logout", description = "Rest Web Service Authenticating Users")
@RequestMapping("/auth")
public interface ILogoutContext {

	void onLogoutSuccess(HttpServletRequest request) throws IOException, ServletException;
	
	void onLogoutSuccess() throws IOException, ServletException;

	@GetMapping("/logout")
	@ApiOperation(value = "Logout", notes = "Logout to Make Token Expired",  response = ResponseData.class)
	ResponseData onLogoutSuccessJwt() throws IOException, ServletException;
	
}
