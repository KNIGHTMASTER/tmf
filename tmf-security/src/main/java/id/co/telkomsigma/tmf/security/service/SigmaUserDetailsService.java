package id.co.telkomsigma.tmf.security.service;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component
public class SigmaUserDetailsService implements UserDetailsService {

	private static Logger LOGGER = LoggerFactory.getLogger(SigmaUserDetailsService.class);
	private String emptyPassword = "";
	
	@Autowired
	private IAuthenticationService authenticationService;

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.emptyPassword = passwordEncoder.encode("");
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecurityUserDetails securityUserDetails = null;
		try {
			securityUserDetails = authenticationService.login(username);
		} catch (Exception e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_USER_DETAILS_SERVICE, e);
			throw new UsernameNotFoundException(username);
		}		
		if(securityUserDetails != null){
			String clientSecret = securityUserDetails.getPassword();
			if ((clientSecret == null) || (clientSecret.trim().length() == 0)) {
				clientSecret = this.emptyPassword;
			}
			return new User(username, clientSecret,
					securityUserDetails.isEnabled(),
					securityUserDetails.isAccountNonExpired(),
					securityUserDetails.isCredentialsNonExpired(),
					securityUserDetails.isAccountNonLocked(),
					securityUserDetails.getAuthorities());
		}
		return null;
	}

}
