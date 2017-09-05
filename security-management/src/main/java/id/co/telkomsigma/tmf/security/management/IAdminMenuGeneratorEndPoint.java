package id.co.telkomsigma.tmf.security.management;


import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.response.AdminMenuDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RequestMapping("/api/security")
@Api(value = "API Menu Generator", description = "Rest Web Service for Generating Menu for Authorized Users")
public interface IAdminMenuGeneratorEndPoint {

    @ResponseBody
    @GetMapping(TMFConstant.PathName.PATH_ADMIN_MENU_GENERATOR)
    @ApiOperation(value = "Generate Menu", notes = "Generate Menu From Authorized Users",  response = List.class)
    public List<AdminMenuDTO> generateMenu();
}
