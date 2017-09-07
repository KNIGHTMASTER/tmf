package id.co.telkomsigma.tmf.smi.impl;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.RequestMemberActivationDTO;
import id.co.telkomsigma.tmf.data.dto.request.RequestRegistrationMemberDTO;
import id.co.telkomsigma.tmf.data.dto.response.RegistrationMemberResponseDTO;
import id.co.telkomsigma.tmf.smi.IRegistrationEndPoint;
import id.co.telkomsigma.tmf.sms.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class RegistrationEndPointImpl implements IRegistrationEndPoint {

	@Autowired
	IRegistrationService registrationService;
	
	@Override
	public RegistrationMemberResponseDTO registerMember(RequestRegistrationMemberDTO p_RequestRegistrationMemberDTO) {
		RegistrationMemberResponseDTO result = null;
		if (checkMandatoryFields(p_RequestRegistrationMemberDTO)){
			result = registrationService.registerMember(p_RequestRegistrationMemberDTO);
		}else {
			result.setResponseData(new ResponseData(EResponseCode.RC_REGISTRATION_MEMBER_FAILED.getResponseCode(), EResponseCode.RC_REGISTRATION_MEMBER_FAILED.getResponseMsg()));
		}
		return result;
	}
	
	@Override
	public ResponseData activateMember(RequestMemberActivationDTO p_RequestMemberActivationDTO) {
		ResponseData responseData;
		if (p_RequestMemberActivationDTO.getEmail() != null){			
			responseData = registrationService.activateMember(p_RequestMemberActivationDTO);
		}else{
			responseData = new ResponseData(EResponseCode.RC_BAD_REQUEST.getResponseCode(), EResponseCode.RC_BAD_REQUEST.getResponseMsg());
		}
		return responseData;
	}

	@Override
	public boolean checkMandatoryFields(RequestRegistrationMemberDTO p_DATA) {
		if(p_DATA.getEmailAddress() != null){
			if (p_DATA.getLastName() != null){
				if (p_DATA.getSurName() != null){
					if (p_DATA.getPassword() != null){
						if (p_DATA.getPhoneNumber() != null){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
