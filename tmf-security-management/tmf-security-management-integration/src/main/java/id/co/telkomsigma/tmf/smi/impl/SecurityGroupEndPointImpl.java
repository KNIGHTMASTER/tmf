package id.co.telkomsigma.tmf.smi.impl;

import id.co.telkomsigma.tmf.data.model.security.SecurityGroup;
import id.co.telkomsigma.tmf.integration.scaffolding.impl.AScaffoldingEndPoint;
import id.co.telkomsigma.tmf.service.ISecurityGroupService;
import id.co.telkomsigma.tmf.smi.ISecurityGroupEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class SecurityGroupEndPointImpl extends AScaffoldingEndPoint<SecurityGroup> implements ISecurityGroupEndPoint {
    @Autowired
    ISecurityGroupService securityGroupService;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = securityGroupService;
    }
}
