package id.co.telkomsigma.tms.data.model.base;

import id.co.telkomsigma.tms.data.constant.TmsConstant;
import id.co.telkomsigma.tms.data.dto.AuthenticationDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * created on 1/18/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class SigmaAuditorAware implements AuditorAware<AuthenticationDetailDTO> {

	@Autowired
    AuthenticationDetailDTO authenticationDetailDTO;
	
    @Override
    public AuthenticationDetailDTO getCurrentAuditor() {
        try{
        	TmsAuthenticationDetail tmsAuthenticationDetail = (TmsAuthenticationDetail) SecurityContextHolder.getContext().getAuthentication().getDetails();
            authenticationDetailDTO = tmsAuthenticationDetail.getAuthenticationDetailDTO();
            authenticationDetailDTO.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
            return authenticationDetailDTO;
        }catch (Exception e) {
            AuthenticationDetailDTO authenticationDetailDTO = new AuthenticationDetailDTO();
        	authenticationDetailDTO.setUserName(TmsConstant.Common.PUBLIC_USER);
			return authenticationDetailDTO;
		}
    }
}
