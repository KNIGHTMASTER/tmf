package id.co.telkomsigma.tmf.data.model.base;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.TMFAuthenticationDetailDTO;
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
public class SigmaAuditorAware implements AuditorAware<TMFAuthenticationDetailDTO> {

	@Autowired
    TMFAuthenticationDetailDTO TMFAuthenticationDetailDTO;
	
    @Override
    public TMFAuthenticationDetailDTO getCurrentAuditor() {
        try{
        	TMFAuthenticationDetail TMFAuthenticationDetail = (TMFAuthenticationDetail) SecurityContextHolder.getContext().getAuthentication().getDetails();
            TMFAuthenticationDetailDTO = TMFAuthenticationDetail.getTMFAuthenticationDetailDTO();
            TMFAuthenticationDetailDTO.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
            return TMFAuthenticationDetailDTO;
        }catch (Exception e) {
            TMFAuthenticationDetailDTO TMFAuthenticationDetailDTO = new TMFAuthenticationDetailDTO();
        	TMFAuthenticationDetailDTO.setUserName(TMFConstant.Common.PUBLIC_USER);
			return TMFAuthenticationDetailDTO;
		}
    }
}
