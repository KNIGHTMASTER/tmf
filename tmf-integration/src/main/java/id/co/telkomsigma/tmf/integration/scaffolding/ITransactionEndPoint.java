package id.co.telkomsigma.tmf.integration.scaffolding;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.integration.exception.EndPointException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * created on 10/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
public interface ITransactionEndPoint<DATA, ID extends Serializable> extends IApprovalEndPoint, ICancellationEndPoint {

    @ResponseBody
    @PutMapping(value = TMFConstant.PathName.PathScaffolding.PATH_UPDATE, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Update Data", notes = "Update Single Data",  response = ResponseData.class)
    ResponseData updateData(@RequestBody DATA p_DATA) throws EndPointException;

    @ResponseBody
    @PostMapping(value = TMFConstant.PathName.PathScaffolding.PATH_INSERT, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Insert Data", notes = "Insert Single Data",  response = ResponseData.class)
    ResponseData insertData(@RequestBody DATA p_DATA) throws EndPointException;

    @ResponseBody
    @PostMapping(value = TMFConstant.PathName.PathScaffolding.PATH_INSERT_AND_FLUSH, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Insert and Flush Data", notes = "Insert Single Data and Directly Persist Record",  response = ResponseData.class)
    ResponseData insertAndFlushData(@RequestBody DATA p_DATA) throws EndPointException;

    @ResponseBody
    @PostMapping(value = TMFConstant.PathName.PathScaffolding.PATH_INSERT_COLLECTION, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Insert Collection", notes = "Update Collection Data",  response = ResponseData.class)
    ResponseData insertCollection(@RequestBody List<DATA> p_DATAs) throws EndPointException;

    @ResponseBody
    @DeleteMapping(value = TMFConstant.PathName.PathScaffolding.PATH_DELETE, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Delete Data", notes = "Delete Single Data",  response = ResponseData.class)
    ResponseData delete(@RequestBody ID p_ID) throws EndPointException;

    @ResponseBody
    @DeleteMapping(value = TMFConstant.PathName.PathScaffolding.PATH_DELETE_BY_ENTITY, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Delete By Code", notes = "Delete Single Data By Code",  response = ResponseData.class)
    ResponseData deleteByEntity(@RequestBody String p_Code) throws EndPointException;

    @ResponseBody
    @DeleteMapping(value = TMFConstant.PathName.PathScaffolding.PATH_DELETE_COLLECTION, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Delete Collection", notes = "Delete Collection Data By Codes",  response = ResponseData.class)
    ResponseData deleteCollection(@RequestBody List<String> p_Codes) throws EndPointException;

    @ResponseBody
    @DeleteMapping(value = TMFConstant.PathName.PathScaffolding.PATH_DELETE_COLLECTION_BY_ID, produces = TMFConstant.Common.APPLICATION_JSON)
    @ApiOperation(value = "Delete Collection By Id", notes = "Delete Collection Data By ID",  response = ResponseData.class)
    ResponseData deleteCollectionById(@RequestBody List<ID> p_ID)  throws EndPointException;
}
