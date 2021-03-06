package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.IUserDAO;
import id.co.telkomsigma.tmf.data.model.security.User;
import id.co.telkomsigma.tmf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDAO userDAO;

	@Override
	@Transactional
	public int insert(User p_User) {
		try{
			userDAO.save(p_User);
			return 0;
		}catch (Exception e) {
			return -1;
		}		
	}

	@Override
	public User findByEmail(String p_Email) {		
		return userDAO.findByEmail(p_Email);
	}
	
	@Override
	public User findByUserName(String p_UserName) {
		return userDAO.findByUsername(p_UserName);
	}
	
	@Override
	public User findById(Long p_Id) {
		return userDAO.findOne(p_Id);
	}
	
	@Override
	@Modifying
	@Transactional
	public int update(User p_User) {
		try{
			userDAO.save(p_User);
			return 0;
		}catch (Exception e) {
			return -1;
		}
	}

}

