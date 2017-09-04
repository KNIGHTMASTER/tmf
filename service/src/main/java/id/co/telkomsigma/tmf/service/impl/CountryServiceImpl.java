package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.ICountryDAO;
import id.co.telkomsigma.tmf.data.model.master.country.Country;
import id.co.telkomsigma.tmf.service.ICountryService;
import id.co.telkomsigma.tmf.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CountryServiceImpl extends AScaffoldingService<Country> implements ICountryService {

    @Autowired
    ICountryDAO countryDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = countryDAO;
    }
}
