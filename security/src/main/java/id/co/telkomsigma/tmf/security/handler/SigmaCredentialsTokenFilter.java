package id.co.telkomsigma.tmf.security.handler;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component
public class SigmaCredentialsTokenFilter extends AbstractAuthenticationProcessingFilter {
	private AuthenticationEntryPoint authenticationEntryPoint;
	private boolean allowOnlyPost;

	public SigmaCredentialsTokenFilter() {
		this(TMFConstant.PathName.PATH_OAUTH_TOKEN);
	}

	public SigmaCredentialsTokenFilter(String path) {
		super(path);
		this.allowOnlyPost = false;
		setRequiresAuthenticationRequestMatcher(new ClientCredentialsRequestMatcher(path));
	}

	public void setAllowOnlyPost(boolean allowOnlyPost) {
		this.allowOnlyPost = allowOnlyPost;
	}

	public void setAuthenticationEntryPoint(AuthenticationEntryPoint authenticationEntryPoint) {
		this.authenticationEntryPoint = authenticationEntryPoint;
	}

	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		setAuthenticationFailureHandler(new AuthenticationFailureHandler() {

			@Override
			public void onAuthenticationFailure(javax.servlet.http.HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException exception) throws IOException, ServletException {
				if (exception instanceof BadCredentialsException) {
					exception = new BadCredentialsException(
							exception.getMessage(),
							new BadCredentialsException(""));
				}
				SigmaCredentialsTokenFilter.this.authenticationEntryPoint.commence(httpServletRequest, httpServletResponse, exception);
			}
		});
		setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
			@Override
			public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

			}
		});
	}

	@Override
	public Authentication attemptAuthentication(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
		if ((this.allowOnlyPost) && (!(TMFConstant.Common.METHOD_POST.equalsIgnoreCase(request.getMethod())))) {
			throw new HttpRequestMethodNotSupportedException(
					request.getMethod(), new String[] { TMFConstant.Common.METHOD_POST });
		}

		String clientId = request.getParameter(TMFConstant.Common.CLIENT_IDENTIFIER);
		String clientSecret = request.getParameter(TMFConstant.Common.CLIENT_SECRET);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if ((authentication != null) && (authentication.isAuthenticated())) {
			return authentication;
		}

		if (clientId == null) {
			throw new BadCredentialsException(TMFConstant.InfoMarkerConstant.INF_BAD_CREDENTIAL_EXCEPTION);
		}

		if (clientSecret == null) {
			clientSecret = "";
		}

		clientId = clientId.trim();
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(clientId, clientSecret);

		return getAuthenticationManager().authenticate(authRequest);
	}


	@Override
	@Autowired
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}

	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}

	protected static class ClientCredentialsRequestMatcher implements RequestMatcher {
		private String path;

		public ClientCredentialsRequestMatcher(String path) {
			this.path = path;
		}

		@Override
		public boolean matches(javax.servlet.http.HttpServletRequest request) {
			String uri = request.getRequestURI();
			int pathParamIndex = uri.indexOf(59);

			if (pathParamIndex > 0) {
				uri = uri.substring(0, pathParamIndex);
			}

			String clientId = request.getParameter(TMFConstant.Common.CLIENT_IDENTIFIER);

			if (clientId == null) {
				return false;
			}

			if ("".equals(request.getContextPath())) {
				return uri.endsWith(this.path);
			}

			return uri.endsWith(request.getContextPath() + this.path);
		}
	}
}