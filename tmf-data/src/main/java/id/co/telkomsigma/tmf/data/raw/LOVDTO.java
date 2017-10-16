package id.co.telkomsigma.tmf.data.raw;

import java.io.Serializable;

/**
 *
* @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <KEY>
 * @param <VALUE>
 */
public class LOVDTO<KEY, VALUE> implements Serializable{
    /**
     * 
     * 
     */
    private static final long serialVersionUID = -1117195724949104462L;
    
    private KEY key;
    private VALUE value;

    public KEY getKey() {
        return key;
    }

    public void setKey(KEY key) {
        this.key = key;
    }

    public VALUE getValue() {
        return value;
    }

    public void setValue(VALUE value) {
        this.value = value;
    }
}
