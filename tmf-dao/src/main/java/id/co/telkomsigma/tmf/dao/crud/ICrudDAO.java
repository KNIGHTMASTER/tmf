package id.co.telkomsigma.tmf.dao.crud;

import id.co.telkomsigma.tmf.data.model.base.ACrudDATA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created on 10/16/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
@NoRepositoryBean
public interface ICrudDAO<DATA extends ACrudDATA> extends JpaRepository<DATA, Long> {
}
