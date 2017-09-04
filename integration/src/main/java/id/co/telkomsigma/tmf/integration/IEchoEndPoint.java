package id.co.telkomsigma.tmf.integration;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 9/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@Api(value = "Echo EndPoint", description = "Echo End Point")
@RequestMapping("/public")
public interface IEchoEndPoint {

    @ResponseBody
    @GetMapping(TMFConstant.PathName.PATH_ECHO)
    @ApiOperation(value = "ECHO", notes = "Echo API to Check Connectivity", response = ResponseData.class)
    ResponseData echo();
}
