package id.co.telkomsigma.tmf.integration.scaffolding.impl;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tmf.data.dto.response.GenericSingleDATAResponseDTO;
import id.co.telkomsigma.tmf.integration.exception.EndPointException;
import id.co.telkomsigma.tmf.integration.scaffolding.IResponseConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created on 10/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
@Service
public class ResponseConstructorImpl<DATA> implements IResponseConstructor<DATA> {

    private static Logger LOGGER = LoggerFactory.getLogger(ResponseConstructorImpl.class);

    @Override
    public GenericSingleDATAResponseDTO constructSingleFindResponse(DATA p_DATA) throws EndPointException {
        GenericSingleDATAResponseDTO response = new GenericSingleDATAResponseDTO();
        response.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        try{
            if (p_DATA == null){
                LOGGER.info(TMFConstant.InfoMarkerConstant.INFO_DATA_NOT_FOUND);
            }
            response.setContent(p_DATA);
            response.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), (EResponseCode.RC_SUCCESS.getResponseMsg())));
        } catch (Exception e) {
            LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT, e);
        }
        return response;
    }

    @Override
    public GenericSingleDATAResponseDTO constructDTOSingleFindResponse(Object p_DATA) throws EndPointException {
        GenericSingleDATAResponseDTO response = new GenericSingleDATAResponseDTO();
        response.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        try{
            if (p_DATA == null){
                LOGGER.info(TMFConstant.InfoMarkerConstant.INFO_DATA_NOT_FOUND);
            }
            response.setContent(p_DATA);
            response.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), (EResponseCode.RC_SUCCESS.getResponseMsg())));
        } catch (Exception e) {
            LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT, e);
        }
        return response;
    }

    @Override
    public GenericListResponseDTO constructListFindResponse(List<DATA> p_DATA) throws EndPointException {
        GenericListResponseDTO responseDTO = new GenericListResponseDTO();
        responseDTO.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        try{
            if (p_DATA.size() > 0){
                responseDTO.setContent(p_DATA);
                responseDTO.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), (EResponseCode.RC_SUCCESS.getResponseMsg())));
            }else{
            	responseDTO.setResponseData(new ResponseData(EResponseCode.RC_DATA_IS_EMPTY.getResponseCode(), (EResponseCode.RC_DATA_IS_EMPTY.getResponseMsg())));
                LOGGER.info(TMFConstant.InfoMarkerConstant.INFO_DATA_NOT_FOUND);
            }
        } catch (Exception e) {
            LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT, e);
        }
        return responseDTO;
    }

    @Override
    public GenericListResponseDTO constructDTOListFindResponse(List<?> p_DATA) throws EndPointException {
        List<?> response;
        GenericListResponseDTO responseDTO = new GenericListResponseDTO();
        responseDTO.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        try{
            if (p_DATA.size() > 0){
                response = p_DATA;
                responseDTO.setContent(response);
                responseDTO.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), (EResponseCode.RC_SUCCESS.getResponseMsg())));
            }else{
            	responseDTO.setResponseData(new ResponseData(EResponseCode.RC_DATA_IS_EMPTY.getResponseCode(), (EResponseCode.RC_DATA_IS_EMPTY.getResponseMsg())));
                LOGGER.info(TMFConstant.InfoMarkerConstant.INFO_DATA_NOT_FOUND);
            }
        } catch (Exception e) {
            LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT, e);
        }
        return responseDTO;
    }

    @Override
    public Page<DATA> constructPaginationResponse(Page<DATA> p_DATAPage) {
        try{
            if (p_DATAPage == null){
                LOGGER.info(TMFConstant.InfoMarkerConstant.INFO_DATA_NOT_FOUND);
            }
            return p_DATAPage;
        } catch (Exception e) {
            LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT, e);
            return null;
        }
    }

    @Override
    public Page<?> constructDTOPaginationResponse(Page<?> p_DATAPage) throws EndPointException {
        try{
            if (p_DATAPage == null){
                LOGGER.info(TMFConstant.InfoMarkerConstant.INFO_DATA_NOT_FOUND);
            }
            return p_DATAPage;
        } catch (Exception e) {
            LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT, e);
            return null;
        }
    }

    @Override
    public ResponseData constructSimpleTransactionResponse(ResponseData p_ResponseData) {
        ResponseData responseData = new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg());
        try{
            if (p_ResponseData == null){
                LOGGER.info(TMFConstant.InfoMarkerConstant.INFO_DATA_NOT_FOUND);
            }
            return responseData;
        } catch (Exception e) {
            LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT, e);
            return null;
        }
    }
}
