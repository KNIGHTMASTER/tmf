package id.co.telkomsigma.tmf.service;

import id.co.telkomsigma.tmf.data.model.master.city.City;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.service.scaffolding.IScaffoldingService;

import java.util.List;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ICityService extends IScaffoldingService<City> {
	
	List<City> findCityByProvinceCode(String p_ProvinceCode) throws ServiceException;
	
	List<City> findCityByProvinceName(String p_ProvinceName) throws ServiceException;
	
	List<City> findCityByProvinceId(Long p_ProvinceId) throws ServiceException;
}
