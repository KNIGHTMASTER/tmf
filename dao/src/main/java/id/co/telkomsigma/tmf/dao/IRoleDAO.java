package id.co.telkomsigma.tmf.dao;

import id.co.telkomsigma.tmf.data.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDAO extends JpaRepository<Role, Integer> {

	Role findByAuthority(String p_Authority);
}
