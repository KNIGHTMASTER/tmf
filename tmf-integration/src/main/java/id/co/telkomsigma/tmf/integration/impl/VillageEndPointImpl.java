package id.co.telkomsigma.tmf.integration.impl;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tmf.data.mapper.impl.VillageMapper;
import id.co.telkomsigma.tmf.data.model.master.village.Village;
import id.co.telkomsigma.tmf.integration.IVillageEndPoint;
import id.co.telkomsigma.tmf.integration.exception.EndPointException;
import id.co.telkomsigma.tmf.integration.scaffolding.impl.AScaffoldingEndPoint;
import id.co.telkomsigma.tmf.service.IVillageService;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * created on 1/10/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class VillageEndPointImpl extends AScaffoldingEndPoint<Village> implements IVillageEndPoint {
	@Autowired
	IVillageService villageService;

	@Autowired
	VillageMapper villageMapper;

	@PostConstruct
	@Override
	public void init() {
		scaffoldingService = villageService;
		dataMapperIntegration = villageMapper;
	}

	@Override
	public GenericListResponseDTO findVillageByDistrictId(String p_DistrictId) {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
		try {
			result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(villageService.findVillageByDistrictId(Long.valueOf(p_DistrictId))));
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(e.toString());
			result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findVillageByDistrictCode(String p_DistrictCode) {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
		try {
			result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(villageService.findVillageByDistrictCode(p_DistrictCode)));
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(e.toString());
			result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findVillageByDistrictName(String p_DistrictName) {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
		try {
			result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(villageService.findVillageByDistrictName(p_DistrictName)));
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(e.toString());
			result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		}
		return result;
	}


}
