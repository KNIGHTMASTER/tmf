package id.co.telkomsigma.tmf.service;

import id.co.telkomsigma.tmf.data.model.master.district.District;
import id.co.telkomsigma.tmf.data.model.master.village.Village;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.service.scaffolding.IScaffoldingService;

import java.util.List;

/**
 * created on 1/10/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IVillageService extends IScaffoldingService<Village> {
	
	List<District> findVillageByDistrictId(Long p_DistrictId) throws ServiceException;
	
	List<District> findVillageByDistrictCode(String p_DistrictCode) throws ServiceException;
	
	List<District> findVillageByDistrictName(String p_DistrictName) throws ServiceException;

}
