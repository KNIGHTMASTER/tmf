package id.co.telkomsigma.tmf.integration;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 9/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(value = "Echo EndPoint", description = "Echo End Point")
@RequestMapping("/public")
public interface IEchoEndPoint {

    @ResponseBody
    @GetMapping(value = TMFConstant.PathName.PATH_ECHO, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "ECHO", notes = "Echo API to Check Connectivity", response = ResponseData.class)
    ResponseData echo();
}
