package id.co.telkomsigma.tmf.smi.impl;

import id.co.telkomsigma.tmf.data.model.security.Role;
import id.co.telkomsigma.tmf.integration.scaffolding.impl.AScaffoldingEndPoint;
import id.co.telkomsigma.tmf.service.ISecurityRoleService;
import id.co.telkomsigma.tmf.smi.ISecurityRoleEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class SecurityRoleEndPointImpl extends AScaffoldingEndPoint<Role> implements ISecurityRoleEndPoint {

	@Autowired
	ISecurityRoleService securityRoleService;
	
	@PostConstruct
	@Override
	public void init() {
		scaffoldingService = securityRoleService;
	}

}
