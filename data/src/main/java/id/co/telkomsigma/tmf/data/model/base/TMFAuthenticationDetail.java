package id.co.telkomsigma.tmf.data.model.base;

import id.co.telkomsigma.tmf.data.dto.TMFAuthenticationDetailDTO;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * created on 1/18/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TMFAuthenticationDetail extends WebAuthenticationDetails {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5494857241468322476L;
    private TMFAuthenticationDetailDTO TMFAuthenticationDetailDTO;
    //    private static final Logger LOGGER = LoggerFactory.getLogger(TmsAuthenticationDetail.class);
    /**
     * Records the remote address and will also set the session Id if a session
     * already exists (it won't create one).
     *
     * @param request that the authentication request was received from
     */
    public TMFAuthenticationDetail(HttpServletRequest request) {
        super(request);
        TMFAuthenticationDetailDTO = new TMFAuthenticationDetailDTO();
        TMFAuthenticationDetailDTO.setPlatform(request.getHeader("User-Agent"));
        TMFAuthenticationDetailDTO.setIpAddress(request.getHeader("X-FORWARDED-FOR"));
        if (TMFAuthenticationDetailDTO.getIpAddress() == null) {
            TMFAuthenticationDetailDTO.setIpAddress(request.getRemoteAddr());
        }
    }

    public TMFAuthenticationDetailDTO getTMFAuthenticationDetailDTO() {
        return TMFAuthenticationDetailDTO;
    }

    public void setTMFAuthenticationDetailDTO(TMFAuthenticationDetailDTO TMFAuthenticationDetailDTO) {
        this.TMFAuthenticationDetailDTO = TMFAuthenticationDetailDTO;
    }
}
