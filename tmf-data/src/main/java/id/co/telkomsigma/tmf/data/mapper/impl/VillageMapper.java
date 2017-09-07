package id.co.telkomsigma.tmf.data.mapper.impl;

import id.co.telkomsigma.tmf.data.mapper.ADATAMapper;
import id.co.telkomsigma.tmf.data.model.master.village.Village;
import id.co.telkomsigma.tmf.data.raw.VillageRawDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * created on 2017-03-06
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class VillageMapper extends ADATAMapper<Village, VillageRawDTO> {
	/**
	 *
	 *
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(VillageMapper.class);
	
	@Override
	public VillageRawDTO convert(Village village) {
		VillageRawDTO result = null;
		try{
			result = new VillageRawDTO();
			result.setCode(village.getCode());
			result.setName(village.getName());
			result.setStatus(village.getStatus());
			result.setRemarks(village.getRemarks());
			result.setCreatedBy(village.getCreatedBy());
			result.setCreatedIP(village.getCreatedIP());
			result.setCreatedOn(village.getCreatedOn());
			result.setCreatedPlatform(village.getCreatedPlatform());
			result.setModifiedBy(village.getModifiedBy());
			result.setModifiedIP(village.getModifiedIP());
			result.setModifiedOn(village.getModifiedOn());
			result.setModifiedPlatform(village.getModifiedPlatform());
		}catch (Exception e) {
			LOGGER.error(e.toString());
		}
		return result;
	}

}
