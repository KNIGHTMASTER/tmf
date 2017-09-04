package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.IProvinceDAO;
import id.co.telkomsigma.tmf.dao.exception.DAOException;
import id.co.telkomsigma.tmf.data.model.master.province.Province;
import id.co.telkomsigma.tmf.service.IProvinceService;
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
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProvinceServiceImpl extends AScaffoldingService<Province> implements IProvinceService {

    @Autowired
    IProvinceDAO provinceDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProvinceServiceImpl.class);

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = provinceDAO;
    }

    @Override
    public List<Province> findProvinceByCountryId(Long p_CountryId) throws ServiceException {
        List<Province> result = new ArrayList<>();
        try {
            result = provinceDAO.findProvinceByCountry_id(p_CountryId);
        } catch (DAOException e) {
            LOGGER.error(e.toString());
        }
        return result;
    }

    @Override
    public List<Province> findProvinceByCountryCode(String p_CountryCode) throws ServiceException {
        List<Province> result = new ArrayList<>();
        try {
            result = provinceDAO.findProvinceByCountry_code(p_CountryCode);
        } catch (DAOException e) {
            LOGGER.error(e.toString());
        }
        return result;
    }

    @Override
    public List<Province> findProvinceByCountryName(String p_CountryName) throws ServiceException {
        List<Province> result = new ArrayList<>();
        try {
            result = provinceDAO.findProvinceByCountry_name(p_CountryName);
        } catch (DAOException e) {
            LOGGER.error(e.toString());
        }
        return result;
    }
}
