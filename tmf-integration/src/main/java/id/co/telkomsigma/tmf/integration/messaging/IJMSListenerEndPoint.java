package id.co.telkomsigma.tmf.integration.messaging;

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
@Api(value = "JMS Listener EndPoint", description = "JMS Listener End Point")
@RequestMapping("/public")
public interface IJMSListenerEndPoint {

    @ResponseBody
    @GetMapping(value = TMFConstant.PathName.PATH_START_JMS_MANAGER, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "JMS Manager", notes = "JMS Manager API to turn on listener", response = ResponseData.class)
    ResponseData start();

    @ResponseBody
    @GetMapping(value = TMFConstant.PathName.PATH_STOP_JMS_MANAGER, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "JMS Manager", notes = "JMS Manager API to turn off listener", response = ResponseData.class)
    ResponseData stop();
}
