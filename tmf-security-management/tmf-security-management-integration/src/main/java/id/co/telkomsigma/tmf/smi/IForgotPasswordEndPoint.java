package id.co.telkomsigma.tmf.smi;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.RequestForgotPasswordDTO;
import id.co.telkomsigma.tmf.data.dto.request.RequestResetPasswordDTO;
import id.co.telkomsigma.tmf.data.dto.response.RequestForgotPasswordResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created on 2017-03-08
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(value = "Password End Point", description = "Password End Point")
@RequestMapping(TMFConstant.PathName.Security.PATH_PASSWORD)
public interface IForgotPasswordEndPoint {
	
	@Secured({TMFConstant.Role.ROLE_USER , TMFConstant.Role.ROLE_ADMIN, TMFConstant.Role.ROLE_SUPERADMIN})
    @ResponseBody
    @PutMapping(value = TMFConstant.PathName.Security.PATH_FORGOT_PASSWORD, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Forgot Password", notes = "Forgot Password API", response = ResponseData.class)
    RequestForgotPasswordResponseDTO forgotPasword(RequestForgotPasswordDTO p_RequestForgotPasswordDTO);
    
    @Secured({TMFConstant.Role.ROLE_USER , TMFConstant.Role.ROLE_ADMIN, TMFConstant.Role.ROLE_SUPERADMIN})
    @ResponseBody
    @PutMapping(value = TMFConstant.PathName.Security.PATH_RESET_PASSWORD, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Reset Password", notes = "Reset Password API", response = ResponseData.class)
    ResponseData resetPasword(RequestResetPasswordDTO p_RequestResetPasswordDTO);

}
