package id.co.telkomsigma.tmf.service;

import id.co.telkomsigma.tmf.data.model.security.User;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IUserService {
	
	/**
	 * 
	 * @param p_User
	 * @return -1 : failed || 0 : success
	 */
	int insert(User p_User);

	User findByEmail(String p_Email);
	
	User findByUserName(String p_UserName);
	
	User findById(Long p_Id);
	
	/**
	 * 
	 * @param p_User
	 * @return -1 : failed || 0 : success
	 */
	int update(User p_User);
}
