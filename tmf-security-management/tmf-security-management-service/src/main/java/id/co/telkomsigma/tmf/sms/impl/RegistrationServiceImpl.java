package id.co.telkomsigma.tmf.sms.impl;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.RequestMemberActivationDTO;
import id.co.telkomsigma.tmf.data.dto.request.RequestRegistrationMemberDTO;
import id.co.telkomsigma.tmf.data.dto.response.RegistrationMemberResponseDTO;
import id.co.telkomsigma.tmf.data.model.master.contact.SecurityUserContact;
import id.co.telkomsigma.tmf.data.model.security.*;
import id.co.telkomsigma.tmf.security.policy.IPasswordPolicy;
import id.co.telkomsigma.tmf.service.IRoleService;
import id.co.telkomsigma.tmf.service.ISecurityGroupService;
import id.co.telkomsigma.tmf.service.ISecurityOAuthClientDetailsService;
import id.co.telkomsigma.tmf.service.IUserService;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.service.util.IEmailValidation;
import id.co.telkomsigma.tmf.sms.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * created on 1/20/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class RegistrationServiceImpl implements IRegistrationService {

	@Autowired
	IEmailValidation emailValidation;

	@Autowired
	ISecurityUserProfileService securityUserProfileService;

	@Autowired
	IUserService userService;

	@Autowired
	ISecurityGroupService securityGroupService;

	@Autowired
	ISecurityUserContactService securityUserContactService;

	@Autowired
	IRoleService roleService;

	@Autowired
	ISecurityOAuthClientDetailsService securityOAuthClientDetailsService;
	
	@Autowired
	ISecurityUserVerificationService securityUserVerificationService;
	
	@Autowired
	ISecurityUserAddressService securityUserAddressService;

	@Autowired
	IPasswordPolicy passwordPolicy;

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);

	@Transactional
	@Override	
	public RegistrationMemberResponseDTO registerMember(RequestRegistrationMemberDTO p_RequestRegistrationMemberDTO) {
		RegistrationMemberResponseDTO result = new RegistrationMemberResponseDTO(); 
		if (checkMandatoryFields(p_RequestRegistrationMemberDTO)) {			
			if (emailValidation.isReadyToRegister(p_RequestRegistrationMemberDTO.getEmailAddress())) {
				if (passwordPolicy.isValid(p_RequestRegistrationMemberDTO.getPassword())) {
					SecurityGroup securityGroup = securityGroupService.findByAuthority(TMFConstant.Role.ROLE_USER);
					if (securityGroup != null) {
						String userName = p_RequestRegistrationMemberDTO.getEmailAddress().split(TMFConstant.Common.Punctuation.AT_MARK)[0];
						SecurityOAuthClientDetails secOAuthClientDetails = securityOAuthClientDetailsService.generateNewAPIClient(userName, p_RequestRegistrationMemberDTO.getPassword(),TMFConstant.Role.ROLE_USER);
						int clientDetailStatus = securityOAuthClientDetailsService.insertNewClientDetails(secOAuthClientDetails);
						if (clientDetailStatus == TMFConstant.Common.GeneralValue.ZERO) {
							User user = new User();
							user.setRole(roleService.findByAuthority(TMFConstant.Role.ROLE_USER));
							user.setUsername(userName);
							user.setEnabled(TMFConstant.Common.GeneralValue.ZERO);
							user.setGroup(securityGroup);
							user.setUsername(secOAuthClientDetails.getClientId());
							user.setEnabled(TMFConstant.Common.GeneralValue.ZERO);
							user.setNonLocked(TMFConstant.Common.GeneralValue.ONE);
							userService.insert(user);

							String name = p_RequestRegistrationMemberDTO.getSurName().concat(TMFConstant.Common.Punctuation.SPACE).concat(p_RequestRegistrationMemberDTO.getLastName());
							SecurityUserContact securityUserContact = new SecurityUserContact();
							securityUserContact.setEmail(p_RequestRegistrationMemberDTO.getEmailAddress());
							securityUserContact.setName(name);
							securityUserContact.setPhoneNumber1(p_RequestRegistrationMemberDTO.getPhoneNumber());
							securityUserContact.setCode(securityUserContactService.generateRandomCode());
							try {
								securityUserContactService.insert(securityUserContact);
							} catch (ServiceException e) {
								LOGGER.error("Error inserting Contact ".concat(e.toString()));
								result.setResponseData(new ResponseData(EResponseCode.RC_REGISTRATION_MEMBER_FAILED.getResponseCode(), EResponseCode.RC_REGISTRATION_MEMBER_FAILED.getResponseMsg()));
							}

							SecurityUserAddress securityUserAddress = new SecurityUserAddress();
							try {
								securityUserAddressService.insert(securityUserAddress);
							} catch (ServiceException e1) {
								LOGGER.error("Error inserting Address ".concat(e1.toString()));
								result.setResponseData(new ResponseData(EResponseCode.RC_REGISTRATION_MEMBER_FAILED.getResponseCode(),EResponseCode.RC_REGISTRATION_MEMBER_FAILED.getResponseMsg()));
							}

							SecurityUserProfile securityUserProfile = new SecurityUserProfile();
							securityUserProfile.setContact(securityUserContact);
							securityUserProfile.setAddress(securityUserAddress);
							securityUserProfile.setCode(securityUserProfileService.generateRandomCode());
							securityUserProfile.setName(name);
							securityUserProfile.setUser(user);
							securityUserProfile.setStatus(TMFConstant.Common.GeneralValue.ONE);
							try {
								securityUserProfileService.insert(securityUserProfile);
							} catch (ServiceException e) {
								result.setResponseData(new ResponseData(EResponseCode.RC_REGISTRATION_MEMBER_FAILED.getResponseCode(),EResponseCode.RC_REGISTRATION_MEMBER_FAILED.getResponseMsg()));
							}

							SecurityUserVerification verfication = new SecurityUserVerification();
							verfication.setUser(user);
							String tokenVerfication = securityUserVerificationService.insert(verfication);

							result.setToken(tokenVerfication);
							result.setResponseData(new ResponseData(EResponseCode.RC_REGISTRATION_MEMBER_SUCCESS.getResponseCode(), EResponseCode.RC_REGISTRATION_MEMBER_SUCCESS.getResponseMsg()));
							return result;
						} else {
							result.setResponseData(new ResponseData(EResponseCode.RC_REGISTRATION_MEMBER_FAILED.getResponseCode(),EResponseCode.RC_REGISTRATION_MEMBER_FAILED.getResponseMsg()));
						}
					} else {
						LOGGER.error("Group is not found ");
						result.setResponseData(new ResponseData(EResponseCode.RC_GROUP_NOT_FOUND.getResponseCode(),EResponseCode.RC_GROUP_NOT_FOUND.getResponseMsg()));
					}
				}else {
					LOGGER.error("Password doesn't match our policy");
					result.setResponseData(new ResponseData(EResponseCode.RC_PASSWORD_UNMATCH.getResponseCode(),EResponseCode.RC_PASSWORD_UNMATCH.getResponseMsg()));
				}
			} else {
				LOGGER.error("Email is not valid || Not Ready to register");
				result.setResponseData(new ResponseData(EResponseCode.RC_EMAIL_NOT_VALID.getResponseCode(),EResponseCode.RC_EMAIL_NOT_VALID.getResponseMsg()));
			}
		} else {
			LOGGER.error("Mandatory Fields not completed");
			result.setResponseData(new ResponseData(EResponseCode.RC_MANDATORY_NOT_COMPLETED.getResponseCode(),EResponseCode.RC_MANDATORY_NOT_COMPLETED.getResponseMsg()));
		}
		return result;
	}

	@Override
	@Transactional
	public ResponseData activateMember(RequestMemberActivationDTO p_RequestMemberActivationDTO) {
		User user = userService.findByEmail(p_RequestMemberActivationDTO.getEmail());
		ResponseData responseData = null;
		if (user != null) {			
			boolean isVerified = securityUserVerificationService.verifyToken(p_RequestMemberActivationDTO.getToken());
			if (isVerified){
				user.setEnabled(TMFConstant.Common.GeneralValue.ONE);
				userService.insert(user);
				responseData = new ResponseData(EResponseCode.RC_MEMBER_ACTIVATION_SUCCESS.getResponseCode(),
						EResponseCode.RC_MEMBER_ACTIVATION_SUCCESS.getResponseMsg());
			}else{
				LOGGER.error("Token is expired");
				responseData = new ResponseData(EResponseCode.RC_TOKEN_EXPIRED.getResponseCode(),
						EResponseCode.RC_TOKEN_EXPIRED.getResponseMsg());
			}
		} else {
			LOGGER.error("User is not found");
			responseData = new ResponseData(EResponseCode.RC_USER_NOT_EXISTS.getResponseCode(),
					EResponseCode.RC_USER_NOT_EXISTS.getResponseMsg());
		}
		return responseData;
	}

	@Override
	public boolean checkMandatoryFields(RequestRegistrationMemberDTO p_RequestRegistrationMemberDTO) {
		if (p_RequestRegistrationMemberDTO.getSurName() != null) {
			if (p_RequestRegistrationMemberDTO.getLastName() != null) {
				if (p_RequestRegistrationMemberDTO.getEmailAddress() != null) {
					if (p_RequestRegistrationMemberDTO.getPhoneNumber() != null) {
						if (p_RequestRegistrationMemberDTO.getPassword() != null) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
