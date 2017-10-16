package id.co.telkomsigma.tmf.data.model.base;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created on 10/16/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@MappedSuperclass
public abstract class ACrudDATA<KEY extends Serializable> implements ISingleKeyDATA<KEY> {

    private KEY id;

    void setId (KEY p_Id) {
        this.id = p_Id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public KEY getId() {
        return id;
    }
}
