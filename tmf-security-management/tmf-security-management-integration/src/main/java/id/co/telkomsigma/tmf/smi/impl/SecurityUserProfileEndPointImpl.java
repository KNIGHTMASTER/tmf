package id.co.telkomsigma.tmf.smi.impl;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.RequestUpdatePasswordDTO;
import id.co.telkomsigma.tmf.data.dto.request.RequestUpdateProfileDTO;
import id.co.telkomsigma.tmf.data.dto.response.AddressResponseDTO;
import id.co.telkomsigma.tmf.data.dto.response.ContactResponseDTO;
import id.co.telkomsigma.tmf.data.dto.response.ProfileResponseDTO;
import id.co.telkomsigma.tmf.data.mapper.impl.SecurityUserProfileMapper;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserProfile;
import id.co.telkomsigma.tmf.integration.scaffolding.impl.AScaffoldingEndPoint;
import id.co.telkomsigma.tmf.security.provider.UserAuthenticationContext;
import id.co.telkomsigma.tmf.smi.ISecurityUserProfileEndPoint;
import id.co.telkomsigma.tmf.sms.ISecurityUserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * created on 12/28/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class SecurityUserProfileEndPointImpl extends AScaffoldingEndPoint<SecurityUserProfile> implements ISecurityUserProfileEndPoint {


    @Autowired
    ISecurityUserProfileService securityUserProfileService;

    @Autowired
    SecurityUserProfileMapper securityUserProfileMapper;

    private static Logger LOGGER = LoggerFactory.getLogger(SecurityUserProfileEndPointImpl.class);

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = securityUserProfileService;
        dataMapperIntegration = securityUserProfileMapper;
    }

    @Override
    public ProfileResponseDTO getProfile() {
        ProfileResponseDTO<AddressResponseDTO, ContactResponseDTO> profileResponseDTO = new ProfileResponseDTO<>();
        try{
            profileResponseDTO = securityUserProfileService.getProfile(UserAuthenticationContext.getInstance().getCurrentUsername());
            profileResponseDTO.setResponseData(new ResponseData(EResponseCode.RC_GET_PROFILE_SUCCESS.getResponseCode(), EResponseCode.RC_GET_PROFILE_SUCCESS.getResponseMsg()));
        }catch (Exception e){
            LOGGER.error("Cannot get profile "+e.toString());
            profileResponseDTO.setResponseData(new ResponseData(EResponseCode.RC_GET_PROFILE_FAILED.getResponseCode(), EResponseCode.RC_GET_PROFILE_FAILED.getResponseMsg()));
        }
        return profileResponseDTO;
    }

	@Override
	public ResponseData updateProfile(@RequestBody RequestUpdateProfileDTO p_RequestUpdateProfileDTO) {
        ResponseData responseData;
        try{
            responseData = securityUserProfileService.updateProfile(p_RequestUpdateProfileDTO);
        }catch (Exception e){
            LOGGER.error("Cannot update profile "+e.toString());
            responseData = new ResponseData(EResponseCode.RC_UPDATE_PROFILE_FAILED.getResponseCode(), EResponseCode.RC_UPDATE_PROFILE_FAILED.getResponseMsg());
        }
		return responseData;
	}

	@Override
	public ResponseData updatePasword(@RequestBody RequestUpdatePasswordDTO p_RequestUpdatePasswordDTO) {
		ResponseData responseData;
        try{
            responseData = securityUserProfileService.updatePassword(p_RequestUpdatePasswordDTO);
        }catch (Exception e){
            LOGGER.error("Cannot update pasword "+e.toString());
            responseData = new ResponseData(EResponseCode.RC_UPDATE_PASSWORD_FAILED.getResponseCode(), EResponseCode.RC_UPDATE_PASSWORD_FAILED.getResponseMsg());
        }
		return responseData;
	}
	
}
