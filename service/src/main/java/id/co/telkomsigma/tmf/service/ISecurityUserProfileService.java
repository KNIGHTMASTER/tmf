package id.co.telkomsigma.tmf.service;

import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.RequestForgotPasswordDTO;
import id.co.telkomsigma.tmf.data.dto.request.RequestResetPasswordDTO;
import id.co.telkomsigma.tmf.data.dto.request.RequestUpdatePasswordDTO;
import id.co.telkomsigma.tmf.data.dto.request.RequestUpdateProfileDTO;
import id.co.telkomsigma.tmf.data.dto.response.AddressResponseDTO;
import id.co.telkomsigma.tmf.data.dto.response.ContactResponseDTO;
import id.co.telkomsigma.tmf.data.dto.response.ProfileResponseDTO;
import id.co.telkomsigma.tmf.data.dto.response.RequestForgotPasswordResponseDTO;
import id.co.telkomsigma.tmf.data.model.security.I18NLocale;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserProfile;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.service.scaffolding.IScaffoldingService;

import javax.transaction.Transactional;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * 
 */
public interface ISecurityUserProfileService extends IScaffoldingService<SecurityUserProfile> {

	SecurityUserProfile findByEmail(String email);

	SecurityUserProfile findByPhone(String phone);

	SecurityUserProfile findByUsername(String username);

	ProfileResponseDTO<AddressResponseDTO, ContactResponseDTO> getProfile(String p_CurrentUserName);

	int setProfileLocale(I18NLocale i18NLocale, String username);

	@Transactional
	ResponseData updateProfile(RequestUpdateProfileDTO p_RequestUpdateProfileDTO) throws ServiceException;
	
	@Transactional
	ResponseData updatePassword(RequestUpdatePasswordDTO p_RequestUpdatePasswordDTO);

	@Transactional
	RequestForgotPasswordResponseDTO requestForgotPassword(RequestForgotPasswordDTO p_RequestForgotPasswordDTO);
	
	@Transactional
	ResponseData resetPassword(RequestResetPasswordDTO p_RequestResetPasswordDTO);
}
