package id.co.telkomsigma.tmf.security.handler.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface ILogoutContext {

	public void onLogoutSuccess(HttpServletRequest request) throws IOException, ServletException;
	
	public void onLogoutSuccess() throws IOException, ServletException;

	public void onLogoutSuccessJwt() throws IOException, ServletException;
	
}