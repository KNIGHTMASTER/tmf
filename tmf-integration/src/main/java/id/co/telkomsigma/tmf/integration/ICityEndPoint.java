package id.co.telkomsigma.tmf.integration;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tmf.data.model.master.city.City;
import id.co.telkomsigma.tmf.integration.scaffolding.IScaffoldingEndPoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(value = "City Rest", description = "Rest Web Service for Entity City")
@RequestMapping(TMFConstant.PathName.Master.PATH_CITY)
public interface ICityEndPoint extends IScaffoldingEndPoint<City> {

	@ResponseBody
	@GetMapping(value = TMFConstant.PathName.Master.PATH_CITY_BY_PROVINCE_ID, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Find City By Province Id", notes = "Find City By Province Id", response = GenericListResponseDTO.class)
	GenericListResponseDTO findCityByProvinceId(String p_ProvinceId);

	@ResponseBody
	@GetMapping(value = TMFConstant.PathName.Master.PATH_CITY_BY_PROVINCE_CODE, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Find City By Province Code", notes = "Find City By Province Code", response = GenericListResponseDTO.class)
	GenericListResponseDTO findCityByProvinceCode(String p_ProvinceCode);

	@ResponseBody
	@GetMapping(value = TMFConstant.PathName.Master.PATH_CITY_BY_PROVINCE_NAME, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Find City By Province Name", notes = "Find City By Province Name", response = GenericListResponseDTO.class)
	GenericListResponseDTO findCityByProvinceName(String p_ProvinceName);
}
