package id.co.telkomsigma.tmf.security.provider;


import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserDetails;
import id.co.telkomsigma.tmf.security.service.IAuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created on 8/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * <p>
 *  Used for checking the token from the request and supply the UserDetails if the token is valid
 * </p>
 */
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private IAuthenticationService authenticationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationProvider.class);

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//        UsernamePasswordAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        /*String token = jwtAuthenticationToken.getToken();

        JwtUserDto parsedUser = jwtTokenValidator.parseToken(token);

        if (parsedUser == null) {
            throw new JwtTokenMalformedException("JWT token is not valid");
        }

        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(parsedUser.getRole());

        return new AuthenticatedUser(parsedUser.getUsername(), token, authorityList);*/

        SecurityUserDetails securityUserDetails;
        try {
            securityUserDetails = authenticationService.login(username);
        } catch (Exception e) {
            LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_USER_DETAILS_SERVICE,e);
            throw new UsernameNotFoundException(username);
        }
        if(securityUserDetails != null){
            String clientSecret = securityUserDetails.getPassword();
            if ((clientSecret == null) || (clientSecret.trim().length() == 0)) {
                clientSecret = "";
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


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return super.authenticate(authentication);
    }


}
