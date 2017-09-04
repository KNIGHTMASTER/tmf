package id.co.telkomsigma.tmf.dao;

import id.co.telkomsigma.tmf.data.model.security.SecurityOAuthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISecurityOAuthClientDetailsDAO extends JpaRepository<SecurityOAuthClientDetails, String> {
	
	SecurityOAuthClientDetails findByClientId(String p_ClientId);
}
