package id.co.telkomsigma.tmf.smi.impl;

import id.co.telkomsigma.tmf.data.model.security.SecurityCompany;
import id.co.telkomsigma.tmf.integration.scaffolding.impl.AScaffoldingEndPoint;
import id.co.telkomsigma.tmf.service.ISecurityCompanyService;
import id.co.telkomsigma.tmf.smi.ISecurityCompanyEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class SecurityCompanyEndPointImpl extends AScaffoldingEndPoint<SecurityCompany> implements ISecurityCompanyEndPoint {
    @Autowired
    ISecurityCompanyService securityCompanyService;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = securityCompanyService;
    }
}
