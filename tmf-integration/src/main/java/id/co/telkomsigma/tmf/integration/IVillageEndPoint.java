package id.co.telkomsigma.tmf.integration;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tmf.data.model.master.village.Village;
import id.co.telkomsigma.tmf.integration.scaffolding.IScaffoldingEndPoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created on 1/10/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(value = "Village Rest", description = "Rest Web Service for Entity Village")
@RequestMapping(TMFConstant.PathName.Master.PATH_VILLAGE)
public interface IVillageEndPoint extends IScaffoldingEndPoint<Village> {

	@ResponseBody
	@GetMapping(value = TMFConstant.PathName.Master.PATH_VILLAGE_BY_DISTRICT_ID, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Find Village By District Id", notes = "Find Village By District Id", response = GenericListResponseDTO.class)
	GenericListResponseDTO findVillageByDistrictId(String p_DistrictId);

	@ResponseBody
	@GetMapping(value = TMFConstant.PathName.Master.PATH_VILLAGE_BY_DISTRICT_CODE, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Find Village By District Code", notes = "Find Village By District Code", response = GenericListResponseDTO.class)
	GenericListResponseDTO findVillageByDistrictCode(String p_DistrictCode);

	@ResponseBody
	@GetMapping(value = TMFConstant.PathName.Master.PATH_VILLAGE_BY_DISTRICT_NAME, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Find Village By District Name", notes = "Find Village By District Name", response = GenericListResponseDTO.class)
	GenericListResponseDTO findVillageByDistrictName(String p_DistrictName);
}
