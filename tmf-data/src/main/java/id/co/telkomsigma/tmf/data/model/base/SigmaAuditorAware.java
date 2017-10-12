package id.co.telkomsigma.tmf.data.model.base;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.TMFAuthenticationDetailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * created on 1/18/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class SigmaAuditorAware implements AuditorAware<TMFAuthenticationDetailDTO>, Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5710521695234805668L;

    private static final Logger LOGGER = LoggerFactory.getLogger(SigmaAuditorAware.class);

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
//            LOGGER.error("Failed to get Authentication Detail. Audit Trailing will use public user instead "+e.toString());
            TMFAuthenticationDetailDTO TMFAuthenticationDetailDTO = new TMFAuthenticationDetailDTO();
        	TMFAuthenticationDetailDTO.setUserName(TMFConstant.Common.PUBLIC_USER);
			return TMFAuthenticationDetailDTO;
		}
    }
}
