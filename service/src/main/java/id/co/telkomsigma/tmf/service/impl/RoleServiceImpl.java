package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.IRoleDAO;
import id.co.telkomsigma.tmf.data.model.security.Role;
import id.co.telkomsigma.tmf.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	IRoleDAO roleDAO;
	
	@Override
	public int insert(Role p_Role) {
		try{
			roleDAO.save(p_Role);
			return 0;
		}catch (Exception e) {
			return -1;
		}
	}

	@Override
	public Role findByAuthority(String p_Authority) {
		return roleDAO.findByAuthority(p_Authority);
	}

}
