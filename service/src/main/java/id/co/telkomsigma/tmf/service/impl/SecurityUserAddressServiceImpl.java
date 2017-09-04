package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.ISecurityUserAddressDAO;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserAddress;
import id.co.telkomsigma.tmf.service.ISecurityUserAddressService;
import id.co.telkomsigma.tmf.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SecurityUserAddressServiceImpl extends AScaffoldingService<SecurityUserAddress> implements ISecurityUserAddressService {

	@Autowired
	ISecurityUserAddressDAO securityUserAddressDAO;
	
	@PostConstruct
	@Override
	public void init() {
		scaffoldingDAO = securityUserAddressDAO;	
	}

}
