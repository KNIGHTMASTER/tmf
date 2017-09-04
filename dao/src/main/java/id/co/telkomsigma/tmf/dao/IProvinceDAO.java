package id.co.telkomsigma.tmf.dao;

import id.co.telkomsigma.tmf.dao.exception.DAOException;
import id.co.telkomsigma.tmf.dao.scaffolding.IScaffoldingDAO;
import id.co.telkomsigma.tmf.data.model.master.province.Province;

import java.util.List;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IProvinceDAO extends IScaffoldingDAO<Province> {
	
	List<Province> findProvinceByCountry_id(Long p_Id) throws DAOException;
	
	List<Province> findProvinceByCountry_code(String p_Code) throws DAOException;
	
	List<Province> findProvinceByCountry_name(String p_Name) throws DAOException;
}
