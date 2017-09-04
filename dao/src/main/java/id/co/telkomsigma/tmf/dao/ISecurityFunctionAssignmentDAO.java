package id.co.telkomsigma.tmf.dao;

import id.co.telkomsigma.tmf.dao.scaffolding.IScaffoldingDAO;
import id.co.telkomsigma.tmf.data.model.security.SecurityFunctionAssignment;
import id.co.telkomsigma.tmf.data.model.security.SecurityGroup;

import java.util.List;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISecurityFunctionAssignmentDAO extends IScaffoldingDAO<SecurityFunctionAssignment> {

    List<SecurityFunctionAssignment> findByGroup(SecurityGroup p_Group);
}
