package id.co.telkomsigma.tmf.integration.messaging;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(value = "Sample Mail EndPoint", description = "Sample Mail End Point")
@RequestMapping("/public")
public interface ISampleMailEndPoint {

    @ResponseBody
    @GetMapping(value = "/samplejms/mail", produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Send Sample Mail", notes = "Send Sample Mail", response = ResponseData.class)
    ResponseData sendMail();
}
