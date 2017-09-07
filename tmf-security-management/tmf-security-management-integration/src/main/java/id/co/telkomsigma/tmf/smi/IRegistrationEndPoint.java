package id.co.telkomsigma.tmf.smi;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.RequestMemberActivationDTO;
import id.co.telkomsigma.tmf.data.dto.request.RequestRegistrationMemberDTO;
import id.co.telkomsigma.tmf.data.dto.response.RegistrationMemberResponseDTO;
import id.co.telkomsigma.tmf.service.transaction.ISingleTransaction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(value = "Registration EndPoint", description = "Registration EndPoint")
@RequestMapping(TMFConstant.PathName.Security.PATH_REGISTRATION)
public interface IRegistrationEndPoint extends ISingleTransaction<RequestRegistrationMemberDTO> {

	@ResponseBody
	@PostMapping(value = TMFConstant.PathName.Security.PATH_REGISTRATION_MEMBER, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Register Member", notes = "Api for Registering Member / User", response = RegistrationMemberResponseDTO.class)
	RegistrationMemberResponseDTO registerMember(RequestRegistrationMemberDTO p_RequestRegistrationMemberDTO);

	@ResponseBody
	@GetMapping(value = TMFConstant.PathName.Security.PATH_ACTIVATE_MEMBER, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Activate Member", notes = "API for Activating Registered User", response = ResponseData.class)
	ResponseData activateMember(RequestMemberActivationDTO p_RequestMemberActivationDTO);
	
}
