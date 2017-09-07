package id.co.telkomsigma.tmf.smi.impl;

import id.co.telkomsigma.tmf.data.model.security.SecurityFunctionAssignment;
import id.co.telkomsigma.tmf.integration.scaffolding.impl.AScaffoldingEndPoint;
import id.co.telkomsigma.tmf.service.ISecurityFunctionAssignmentService;
import id.co.telkomsigma.tmf.smi.ISecurityFunctionAssignmentEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class SecurityFunctionAssignmentEndPointImpl extends AScaffoldingEndPoint<SecurityFunctionAssignment> implements ISecurityFunctionAssignmentEndPoint {
    @Autowired
    ISecurityFunctionAssignmentService securityFunctionAssignmentService;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = securityFunctionAssignmentService;
    }
}
