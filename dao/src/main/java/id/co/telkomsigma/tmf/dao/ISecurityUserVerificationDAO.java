package id.co.telkomsigma.tmf.dao;

import id.co.telkomsigma.tmf.data.model.security.SecurityUserVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISecurityUserVerificationDAO extends JpaRepository<SecurityUserVerification, Long> {

	SecurityUserVerification findByToken(String p_Token);
}
