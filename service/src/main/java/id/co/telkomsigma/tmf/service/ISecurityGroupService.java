package id.co.telkomsigma.tmf.service;

import id.co.telkomsigma.tmf.data.model.security.SecurityGroup;
import id.co.telkomsigma.tmf.service.scaffolding.IScaffoldingService;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISecurityGroupService extends IScaffoldingService<SecurityGroup> {
	
	SecurityGroup findByAuthority(String p_Authority);
}
