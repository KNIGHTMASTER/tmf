package id.co.telkomsigma.tmf.integration.scaffolding;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.RequestID;
import id.co.telkomsigma.tmf.integration.exception.EndPointException;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created on 10/17/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ICancellationEndPoint {

    @ResponseBody
    @PutMapping(TMFConstant.PathName.PathScaffolding.PATH_CANCEL_ALL)
    @ApiOperation(value = "Cancel All", notes = "Cancel Collection Data",  response = ResponseData.class)
    @Transactional
    ResponseData cancelAll() throws EndPointException;

    @ResponseBody
    @PutMapping(TMFConstant.PathName.PathScaffolding.PATH_CANCEL_SINGLE_DATA)
    @ApiOperation(value = "Cancel Single Data", notes = "Cancel Single Data",  response = ResponseData.class)
    @Transactional
    ResponseData cancelSingleData(@RequestBody RequestID p_RequestID) throws EndPointException;
}
