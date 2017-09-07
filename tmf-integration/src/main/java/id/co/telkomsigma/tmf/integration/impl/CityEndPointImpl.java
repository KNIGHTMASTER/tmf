package id.co.telkomsigma.tmf.integration.impl;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tmf.data.mapper.impl.CityMapper;
import id.co.telkomsigma.tmf.data.model.master.city.City;
import id.co.telkomsigma.tmf.integration.ICityEndPoint;
import id.co.telkomsigma.tmf.integration.exception.EndPointException;
import id.co.telkomsigma.tmf.integration.scaffolding.impl.AScaffoldingEndPoint;
import id.co.telkomsigma.tmf.service.ICityService;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
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
public class CityEndPointImpl extends AScaffoldingEndPoint<City> implements ICityEndPoint {

    @Autowired
    ICityService cityService;

    @Autowired
    CityMapper cityMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(CityEndPointImpl.class);

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = cityService;
        dataMapperIntegration = cityMapper;
    }

    @Override
    public GenericListResponseDTO findCityByProvinceCode(String p_ProvinceCode) {
        GenericListResponseDTO result = new GenericListResponseDTO();
        result.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
        try {
            result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(cityService.findCityByProvinceCode(p_ProvinceCode)));
        } catch (EndPointException | ServiceException e) {
            LOGGER.error(e.toString());
            result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        }
        return result;
    }

    @Override
    public GenericListResponseDTO findCityByProvinceId(String p_ProvinceId) {
        GenericListResponseDTO result = new GenericListResponseDTO();
        result.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
        try {
            result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(cityService.findCityByProvinceId(Long.valueOf(p_ProvinceId))));
        } catch (EndPointException | ServiceException e) {
            LOGGER.error(e.toString());
            result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        }
        return result;
    }

    @Override
    public GenericListResponseDTO findCityByProvinceName(String p_ProvinceName) {
        GenericListResponseDTO result = new GenericListResponseDTO();
        result.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
        try {
            result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(cityService.findCityByProvinceName(p_ProvinceName)));
        } catch (EndPointException | ServiceException e) {
            LOGGER.error(e.toString());
            result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        }
        return result;
    }
}
