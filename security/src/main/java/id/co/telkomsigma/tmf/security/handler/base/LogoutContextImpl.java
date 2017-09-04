package id.co.telkomsigma.tmf.security.handler.base;


import id.co.telkomsigma.tmf.security.util.JwtTokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component
public class LogoutContextImpl implements ILogoutContext {
	
	private static Logger LOGGER = LoggerFactory.getLogger(LogoutContextImpl.class);

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
	public void onLogoutSuccessJwt() throws IOException, ServletException {
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}	

}
