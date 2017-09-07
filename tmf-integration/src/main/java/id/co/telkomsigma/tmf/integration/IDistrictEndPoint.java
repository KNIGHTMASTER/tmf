package id.co.telkomsigma.tmf.integration;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tmf.data.model.master.district.District;
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
@Api(value = "District Type Rest", description = "Rest Web Service for Entity District")
@RequestMapping(TMFConstant.PathName.Master.PATH_DISTRICT)
public interface IDistrictEndPoint extends IScaffoldingEndPoint<District> {

	@ResponseBody
	@GetMapping(value = TMFConstant.PathName.Master.PATH_DISTRICT_BY_CITY_ID, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Find District By City  Id", notes = "Find District By City  Id", response = GenericListResponseDTO.class)
	GenericListResponseDTO findDistrictByCityId(String p_CityId);

	@ResponseBody
	@GetMapping(value = TMFConstant.PathName.Master.PATH_DISTRICT_BY_CITY_CODE, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Find District By City Code", notes = "Find District By City Code", response = GenericListResponseDTO.class)
	GenericListResponseDTO findDistrictByCityCode(String p_CityCode);

	@ResponseBody
	@GetMapping(value = TMFConstant.PathName.Master.PATH_DISTRICT_BY_CITY_NAME, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Find District By City Name", notes = "Find District By City Name", response = GenericListResponseDTO.class)
	GenericListResponseDTO findDistrictByCityName(String p_CityName);
}
