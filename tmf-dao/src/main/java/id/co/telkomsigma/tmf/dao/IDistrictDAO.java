package id.co.telkomsigma.tmf.dao;

import id.co.telkomsigma.tmf.dao.exception.DAOException;
import id.co.telkomsigma.tmf.dao.scaffolding.IScaffoldingDAO;
import id.co.telkomsigma.tmf.data.model.master.district.District;

import java.util.List;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IDistrictDAO extends IScaffoldingDAO<District> {
	
	List<District> findByCity_id(Long p_CityId) throws DAOException;
	
	List<District> findByCity_code(String p_CityCode) throws DAOException;
	
	List<District> findByCity_name(String p_CityName) throws DAOException;
}
