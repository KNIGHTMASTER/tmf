package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.ISecurityGroupDAO;
import id.co.telkomsigma.tmf.dao.exception.DAOException;
import id.co.telkomsigma.tmf.data.model.security.SecurityGroup;
import id.co.telkomsigma.tmf.service.ISecurityGroupService;
import id.co.telkomsigma.tmf.service.scaffolding.impl.AScaffoldingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SecurityGroupServiceImpl extends AScaffoldingService<SecurityGroup> implements ISecurityGroupService {

    @Autowired
	ISecurityGroupDAO securityGroupDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityGroupServiceImpl.class);
    
    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = securityGroupDAO;
    }

    
	@Override
	public SecurityGroup findByAuthority(String p_Authority) {		
		try {
			return securityGroupDAO.findByRole_Authority(p_Authority);
		} catch (DAOException e) {
			LOGGER.error(e.toString());
			return null;
		}
	}
}
