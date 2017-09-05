package id.co.telkomsigma.tmf.integration.scaffolding;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.RequestID;
import id.co.telkomsigma.tmf.integration.exception.EndPointException;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created on 10/17/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IApprovalEndPoint {

    @ResponseBody
    @PutMapping(value = TMFConstant.PathName.PathScaffolding.PATH_APPROVE_ALL, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Approve All", notes = "Approve Collection Data",  response = ResponseData.class)
    ResponseData approveAll() throws EndPointException, ServiceException;

    @ResponseBody
    @PutMapping(value = TMFConstant.PathName.PathScaffolding.PATH_APPROVE_SINGLE_DATA, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Approve Single Data", notes = "Approve Single Data",  response = ResponseData.class)
    ResponseData approveSingleData(@RequestBody RequestID p_RequestID) throws EndPointException, ServiceException;
}
