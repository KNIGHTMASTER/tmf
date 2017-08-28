package id.co.telkomsigma.tms.data.model.base;

import id.co.telkomsigma.tms.data.dto.AuthenticationDetailDTO;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * created on 1/18/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TmsAuthenticationDetail extends WebAuthenticationDetails {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5494857241468322476L;
    private AuthenticationDetailDTO authenticationDetailDTO;
    //    private static final Logger LOGGER = LoggerFactory.getLogger(TmsAuthenticationDetail.class);
    /**
     * Records the remote address and will also set the session Id if a session
     * already exists (it won't create one).
     *
     * @param request that the authentication request was received from
     */
    public TmsAuthenticationDetail(HttpServletRequest request) {
        super(request);
        authenticationDetailDTO = new AuthenticationDetailDTO();
        authenticationDetailDTO.setPlatform(request.getHeader("User-Agent"));
        authenticationDetailDTO.setIpAddress(request.getHeader("X-FORWARDED-FOR"));
        if (authenticationDetailDTO.getIpAddress() == null) {
            authenticationDetailDTO.setIpAddress(request.getRemoteAddr());
        }
    }

    public AuthenticationDetailDTO getAuthenticationDetailDTO() {
        return authenticationDetailDTO;
    }

    public void setAuthenticationDetailDTO(AuthenticationDetailDTO authenticationDetailDTO) {
        this.authenticationDetailDTO = authenticationDetailDTO;
    }
}
