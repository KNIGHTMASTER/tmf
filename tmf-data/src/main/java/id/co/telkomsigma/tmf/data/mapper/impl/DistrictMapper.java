package id.co.telkomsigma.tmf.data.mapper.impl;

import id.co.telkomsigma.tmf.data.mapper.ADATAMapper;
import id.co.telkomsigma.tmf.data.model.master.district.District;
import id.co.telkomsigma.tmf.data.raw.DistrictRawDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * created on 2017-03-06
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class DistrictMapper extends ADATAMapper<District, DistrictRawDTO> {
    /**
     *
     *
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DistrictMapper.class);

    @Override
    public DistrictRawDTO convert(District district) {
        DistrictRawDTO result = null;
        try {
            result = new DistrictRawDTO();
            result.setId(district.getId());
            result.setCode(district.getCode());
            result.setName(district.getName());
            result.setStatus(district.getStatus());
            result.setRemarks(district.getRemarks());
            result.setCreatedBy(district.getCreatedBy());
            result.setCreatedIP(district.getCreatedIP());
            result.setCreatedOn(district.getCreatedOn());
            result.setCreatedPlatform(district.getCreatedPlatform());
            result.setModifiedBy(district.getModifiedBy());
            result.setModifiedIP(district.getModifiedIP());
            result.setModifiedOn(district.getModifiedOn());
            result.setModifiedPlatform(district.getModifiedPlatform());
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
        return result;
    }

}
