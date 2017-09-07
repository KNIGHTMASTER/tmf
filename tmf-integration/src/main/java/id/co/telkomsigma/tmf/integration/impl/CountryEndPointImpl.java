package id.co.telkomsigma.tmf.integration.impl;

import id.co.telkomsigma.tmf.data.mapper.impl.CountryMapper;
import id.co.telkomsigma.tmf.data.model.master.country.Country;
import id.co.telkomsigma.tmf.integration.ICountryEndPoint;
import id.co.telkomsigma.tmf.integration.scaffolding.impl.AScaffoldingEndPoint;
import id.co.telkomsigma.tmf.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class CountryEndPointImpl extends AScaffoldingEndPoint<Country> implements ICountryEndPoint {

    @Autowired
    ICountryService countryService;

    @Autowired
    CountryMapper countryMapper;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = countryService;
        dataMapperIntegration = countryMapper;
    }

}
