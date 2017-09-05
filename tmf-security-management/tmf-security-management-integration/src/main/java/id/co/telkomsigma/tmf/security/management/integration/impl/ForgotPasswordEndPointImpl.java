package id.co.telkomsigma.tmf.security.management.integration.impl;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.RequestForgotPasswordDTO;
import id.co.telkomsigma.tmf.data.dto.request.RequestResetPasswordDTO;
import id.co.telkomsigma.tmf.data.dto.response.RequestForgotPasswordResponseDTO;
import id.co.telkomsigma.tmf.security.management.integration.IForgotPasswordEndPoint;
import id.co.telkomsigma.tmf.security.management.service.ISecurityUserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * created on 2017-03-08
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class ForgotPasswordEndPointImpl implements IForgotPasswordEndPoint {

	@Autowired
	ISecurityUserProfileService securityUserProfileService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ForgotPasswordEndPointImpl.class);
	
	@Override
	public RequestForgotPasswordResponseDTO forgotPasword(@RequestBody RequestForgotPasswordDTO p_RequestForgotPasswordDTO) {
		RequestForgotPasswordResponseDTO rfPasswordResponseDTO = new RequestForgotPasswordResponseDTO();
		try{
			rfPasswordResponseDTO = securityUserProfileService.requestForgotPassword(p_RequestForgotPasswordDTO);
        }catch (Exception e){
            LOGGER.error("Cannot execute forgot pasword "+e.toString());
            rfPasswordResponseDTO.setResponseData(new ResponseData(EResponseCode.RC_REQUEST_FORGOT_PASSWORD_FAILED.getResponseCode(), EResponseCode.RC_REQUEST_FORGOT_PASSWORD_FAILED.getResponseMsg()));
        }
		return rfPasswordResponseDTO;
	}

	@Override
	public ResponseData resetPasword(@RequestBody RequestResetPasswordDTO p_RequestResetPasswordDTO) {
		ResponseData responseData;
        try{        	
            responseData = securityUserProfileService.resetPassword(p_RequestResetPasswordDTO);
        }catch (Exception e){
            LOGGER.error("Cannot reset pasword "+e.toString());
            responseData = new ResponseData(EResponseCode.RC_UPDATE_PASSWORD_FAILED.getResponseCode(), EResponseCode.RC_UPDATE_PASSWORD_FAILED.getResponseMsg());
        }
		return responseData;
	}

}
