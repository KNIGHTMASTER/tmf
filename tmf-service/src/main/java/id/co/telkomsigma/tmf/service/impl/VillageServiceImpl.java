package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.IVillageDAO;
import id.co.telkomsigma.tmf.dao.exception.DAOException;
import id.co.telkomsigma.tmf.data.model.master.district.District;
import id.co.telkomsigma.tmf.data.model.master.village.Village;
import id.co.telkomsigma.tmf.service.IVillageService;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.service.scaffolding.impl.AScaffoldingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * created on 1/10/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class VillageServiceImpl extends AScaffoldingService<Village> implements IVillageService {

    @Autowired
	IVillageDAO villageDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(VillageServiceImpl.class);
    
    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = villageDAO;
    }

    @Override
    public List<District> findVillageByDistrictId(Long p_DistrictId) throws ServiceException {
    	List<District> result = new ArrayList<>();
    	try {
			result = villageDAO.findByDistrict_id(p_DistrictId);
		} catch (DAOException e) {
			LOGGER.error(e.toString());			
		}
    	return result;
    }
    
	@Override
	public List<District> findVillageByDistrictCode(String p_DistrictCode) throws ServiceException {
		List<District> result = new ArrayList<>();
    	try {
			result = villageDAO.findByDistrict_code(p_DistrictCode);
		} catch (DAOException e) {
			LOGGER.error(e.toString());			
		}
    	return result;
	}

	@Override
	public List<District> findVillageByDistrictName(String p_DistrictName) throws ServiceException {
		List<District> result = new ArrayList<>();
    	try {
			result = villageDAO.findByDistrict_name(p_DistrictName);
		} catch (DAOException e) {
			LOGGER.error(e.toString());			
		}
    	return result;
	}
    
    
}
