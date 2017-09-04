package id.co.telkomsigma.tmf.service;

import id.co.telkomsigma.tmf.data.model.security.Role;

public interface IRoleService {

	/**
	 * 
	 * @param p_Role
	 * @return -1 : failed || 0 success
	 */
	int insert(Role p_Role);
	
	Role findByAuthority(String p_Authority);
}
