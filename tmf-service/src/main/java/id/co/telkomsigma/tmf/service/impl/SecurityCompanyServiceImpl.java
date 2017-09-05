package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.ISecurityCompanyDAO;
import id.co.telkomsigma.tmf.data.model.security.SecurityCompany;
import id.co.telkomsigma.tmf.service.ISecurityCompanyService;
import id.co.telkomsigma.tmf.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SecurityCompanyServiceImpl extends AScaffoldingService<SecurityCompany> implements ISecurityCompanyService {

    @Autowired
    ISecurityCompanyDAO securityCompanyDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = securityCompanyDAO;
    }
}
