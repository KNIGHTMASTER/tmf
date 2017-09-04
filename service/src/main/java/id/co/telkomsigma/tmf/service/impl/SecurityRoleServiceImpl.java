package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.ISecurityRoleDAO;
import id.co.telkomsigma.tmf.data.model.security.Role;
import id.co.telkomsigma.tmf.service.ISecurityRoleService;
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
public class SecurityRoleServiceImpl extends AScaffoldingService<Role> implements ISecurityRoleService {

	@Autowired
	ISecurityRoleDAO securityRoleDAO;
	
	@PostConstruct
	@Override
	public void init() {
		scaffoldingDAO = securityRoleDAO;
	}

}
