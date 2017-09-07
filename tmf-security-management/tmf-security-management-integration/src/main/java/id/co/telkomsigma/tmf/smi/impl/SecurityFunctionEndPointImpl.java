package id.co.telkomsigma.tmf.smi.impl;

import id.co.telkomsigma.tmf.data.model.security.SecurityFunction;
import id.co.telkomsigma.tmf.integration.scaffolding.impl.AScaffoldingEndPoint;
import id.co.telkomsigma.tmf.service.ISecurityFunctionService;
import id.co.telkomsigma.tmf.smi.ISecurityFunctionEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class SecurityFunctionEndPointImpl extends AScaffoldingEndPoint<SecurityFunction> implements ISecurityFunctionEndPoint {

    @Autowired
    ISecurityFunctionService securityFunctionService;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = securityFunctionService;
    }
}
