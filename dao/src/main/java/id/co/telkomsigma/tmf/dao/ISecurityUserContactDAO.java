package id.co.telkomsigma.tmf.dao;

import id.co.telkomsigma.tmf.dao.scaffolding.IScaffoldingDAO;
import id.co.telkomsigma.tmf.data.model.master.contact.SecurityUserContact;

/**
 * created on 1/20/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISecurityUserContactDAO extends IScaffoldingDAO<SecurityUserContact> {
	
	SecurityUserContact findByEmail(String p_Email);
}
