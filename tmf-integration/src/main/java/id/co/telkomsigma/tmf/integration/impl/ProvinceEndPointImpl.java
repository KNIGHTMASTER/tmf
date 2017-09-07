package id.co.telkomsigma.tmf.integration.impl;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tmf.data.mapper.impl.ProvinceMapper;
import id.co.telkomsigma.tmf.data.model.master.province.Province;
import id.co.telkomsigma.tmf.integration.IProvinceEndPoint;
import id.co.telkomsigma.tmf.integration.exception.EndPointException;
import id.co.telkomsigma.tmf.integration.scaffolding.impl.AScaffoldingEndPoint;
import id.co.telkomsigma.tmf.service.IProvinceService;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class ProvinceEndPointImpl extends AScaffoldingEndPoint<Province> implements IProvinceEndPoint {

    @Autowired
    IProvinceService provinceService;

    @Autowired
    ProvinceMapper provinceMapper;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = provinceService;
        dataMapperIntegration = provinceMapper;
    }

    @Override
    public GenericListResponseDTO findProvinceByCountryId(String p_CountryId) {
        GenericListResponseDTO result = new GenericListResponseDTO();
        result.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
        try {
            result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(provinceService.findProvinceByCountryId(Long.valueOf(p_CountryId))));
        } catch (EndPointException | ServiceException e) {
            LOGGER.error(e.toString());
            result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        }
        return result;
    }

    @Override
    public GenericListResponseDTO findProvinceByCountryCode(String p_CountryCode) {
        GenericListResponseDTO result = new GenericListResponseDTO();
        result.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
        try {
            result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(provinceService.findProvinceByCountryCode(p_CountryCode)));
        } catch (EndPointException | ServiceException e) {
            LOGGER.error(e.toString());
            result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        }
        return result;
    }

    @Override
    public GenericListResponseDTO findProvinceByCountryName(String p_CountryName) {
        GenericListResponseDTO result = new GenericListResponseDTO();
        result.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
        try {
            result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(provinceService.findProvinceByCountryName(p_CountryName)));
        } catch (EndPointException | ServiceException e) {
            LOGGER.error(e.toString());
            result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        }
        return result;
    }

}
