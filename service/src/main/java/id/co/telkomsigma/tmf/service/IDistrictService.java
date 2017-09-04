package id.co.telkomsigma.tmf.service;

import id.co.telkomsigma.tmf.data.model.master.district.District;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.service.scaffolding.IScaffoldingService;

import java.util.List;


/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IDistrictService extends IScaffoldingService<District> {
	
	List<District> findDistrictByCityId(Long p_CityId) throws ServiceException;
	
	List<District> findDistrictByCityCode(String p_CityCode) throws ServiceException;
	
	List<District> findDistrictByCityName(String p_CityName) throws ServiceException;
}
