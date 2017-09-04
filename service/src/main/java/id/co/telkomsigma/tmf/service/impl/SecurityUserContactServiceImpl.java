package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.data.model.master.contact.SecurityUserContact;
import id.co.telkomsigma.tmf.dao.ISecurityUserContactDAO;
import id.co.telkomsigma.tmf.service.ISecurityUserContactService;
import id.co.telkomsigma.tmf.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SecurityUserContactServiceImpl extends AScaffoldingService<SecurityUserContact> implements ISecurityUserContactService {

	@Autowired
	ISecurityUserContactDAO securityUserContactDAO;
	
	@PostConstruct
	@Override
	public void init() {
		scaffoldingDAO = securityUserContactDAO;
	}

}
