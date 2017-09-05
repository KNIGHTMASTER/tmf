package id.co.telkomsigma.tmf.security.management.integration;


import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.RequestUpdatePasswordDTO;
import id.co.telkomsigma.tmf.data.dto.request.RequestUpdateProfileDTO;
import id.co.telkomsigma.tmf.data.dto.response.ProfileResponseDTO;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserProfile;
import id.co.telkomsigma.tmf.integration.scaffolding.IScaffoldingEndPoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created on 12/28/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(value = "Profiling End Point", description = "Profiling End Point")
@RequestMapping(TMFConstant.PathName.Security.PATH_PROFILE)
public interface ISecurityUserProfileEndPoint extends IScaffoldingEndPoint<SecurityUserProfile> {

    @Secured({TMFConstant.Role.ROLE_USER , TMFConstant.Role.ROLE_ADMIN, TMFConstant.Role.ROLE_SUPERADMIN})
    @ResponseBody
    @GetMapping(value = TMFConstant.PathName.Security.PATH_GET_PROFILE, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Get Profile", notes = "Get Profile API", response = ResponseData.class)
    ProfileResponseDTO getProfile();

    @Secured({TMFConstant.Role.ROLE_USER , TMFConstant.Role.ROLE_ADMIN, TMFConstant.Role.ROLE_SUPERADMIN})
    @ResponseBody
    @PostMapping(value = TMFConstant.PathName.Security.PATH_UPDATE_PROFILE, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Update Profile", notes = "Update Profile API", response = ResponseData.class)
    ResponseData updateProfile(RequestUpdateProfileDTO p_RequestUpdateProfileDTO);
    
    @Secured({TMFConstant.Role.ROLE_USER , TMFConstant.Role.ROLE_ADMIN, TMFConstant.Role.ROLE_SUPERADMIN})
    @ResponseBody
    @PostMapping(value = TMFConstant.PathName.Security.PATH_UPDATE_PASSWORD, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Update Password", notes = "Update Password API", response = ResponseData.class)
    ResponseData updatePasword(RequestUpdatePasswordDTO p_RequestUpdatePasswordDTO);
}
