package id.co.telkomsigma.tmf.integration;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tmf.data.model.master.province.Province;
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
@Api(value = "Province Rest", description = "Rest Web Service for Entity Province")
@RequestMapping(TMFConstant.PathName.Master.PATH_PROVINCE)
public interface IProvinceEndPoint extends IScaffoldingEndPoint<Province> {

	@ResponseBody
	@GetMapping(value = TMFConstant.PathName.Master.PATH_PROVINCE_BY_COUNTRY_ID, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Find Province By Country Id", notes = "Find Province By Country Id", response = GenericListResponseDTO.class)
	GenericListResponseDTO findProvinceByCountryId(String p_ProvinceId);

	@ResponseBody
	@GetMapping(value = TMFConstant.PathName.Master.PATH_PROVINCE_BY_COUNTRY_CODE, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Find Province By Country Code", notes = "Find Province By Country Code", response = GenericListResponseDTO.class)
	GenericListResponseDTO findProvinceByCountryCode(String p_ProvinceCode);

	@ResponseBody
	@GetMapping(value = TMFConstant.PathName.Master.PATH_PROVINCE_BY_COUNTRY_NAME, produces = TMFConstant.Common.APPLICATION_JSON)
	@ApiOperation(value = "Find Province By Country Name", notes = "Find Province By Country Name", response = GenericListResponseDTO.class)
	GenericListResponseDTO findProvinceByCountryName(String p_ProvinceName);
}
