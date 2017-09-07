package id.co.telkomsigma.tmf.integration.impl;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tmf.data.mapper.impl.DistrictMapper;
import id.co.telkomsigma.tmf.data.model.master.district.District;
import id.co.telkomsigma.tmf.integration.IDistrictEndPoint;
import id.co.telkomsigma.tmf.integration.exception.EndPointException;
import id.co.telkomsigma.tmf.integration.scaffolding.impl.AScaffoldingEndPoint;
import id.co.telkomsigma.tmf.service.IDistrictService;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.service.impl.DistrictServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class DistrictEndPointImpl extends AScaffoldingEndPoint<District> implements IDistrictEndPoint {

    @Autowired
    IDistrictService districtService;

    @Autowired
    DistrictMapper districtMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(DistrictServiceImpl.class);

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = districtService;
        dataMapperIntegration = districtMapper;
    }

    @Override
    public GenericListResponseDTO findDistrictByCityId(String p_CityId) {
        GenericListResponseDTO result = new GenericListResponseDTO();
        result.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
        try {
            result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(districtService.findDistrictByCityId(Long.valueOf(p_CityId))));
        } catch (EndPointException | ServiceException e) {
            LOGGER.error(e.toString());
            result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        }
        return result;
    }

    @Override
    public GenericListResponseDTO findDistrictByCityCode(String p_CityCode) {
        GenericListResponseDTO result = new GenericListResponseDTO();
        result.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
        try {
            result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(districtService.findDistrictByCityCode(p_CityCode)));
        } catch (EndPointException | ServiceException e) {
            LOGGER.error(e.toString());
            result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        }
        return result;
    }

    @Override
    public GenericListResponseDTO findDistrictByCityName(String p_CityName) {
        GenericListResponseDTO result = new GenericListResponseDTO();
        result.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
        try {
            result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(districtService.findDistrictByCityName(p_CityName)));
        } catch (EndPointException | ServiceException e) {
            LOGGER.error(e.toString());
            result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        }
        return result;
    }
}
