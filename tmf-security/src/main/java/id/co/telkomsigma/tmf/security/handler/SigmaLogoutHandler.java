package id.co.telkomsigma.tmf.security.handler;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.security.handler.base.AbstractHandler;
import id.co.telkomsigma.tmf.security.handler.base.ILogoutContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component
public class SigmaLogoutHandler extends AbstractHandler implements LogoutSuccessHandler {

	private ILogoutContext logoutContext;

	public void setLogoutContext(ILogoutContext logoutContext) {
		this.logoutContext = logoutContext;
	}

	@Override
	public EResponseCode getResponseCode() {
		return EResponseCode.RC_LOGOUT_SUCCESS;
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		logoutContext.onLogoutSuccess(request);
		super.handle(response);
	}

}
