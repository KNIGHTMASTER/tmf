package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.ISecurityFunctionAssignmentDAO;
import id.co.telkomsigma.tmf.data.model.security.SecurityFunctionAssignment;
import id.co.telkomsigma.tmf.service.ISecurityFunctionAssignmentService;
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
public class SecurityFunctionAssignmentServiceImpl extends AScaffoldingService<SecurityFunctionAssignment> implements ISecurityFunctionAssignmentService {
    @Autowired
    ISecurityFunctionAssignmentDAO securityFunctionAssignmentDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = securityFunctionAssignmentDAO;
    }
}
