package id.co.telkomsigma.tmf.dao;

import id.co.telkomsigma.tmf.dao.exception.DAOException;
import id.co.telkomsigma.tmf.dao.scaffolding.IScaffoldingDAO;
import id.co.telkomsigma.tmf.data.model.master.district.District;
import id.co.telkomsigma.tmf.data.model.master.village.Village;

import java.util.List;

/**
 * created on 1/10/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IVillageDAO extends IScaffoldingDAO<Village> {

	List<District> findByDistrict_id(Long p_DistrictId) throws DAOException;
	
	List<District> findByDistrict_code(String p_DistrictCode) throws DAOException;

	List<District> findByDistrict_name(String p_DistrictName) throws DAOException;
}
