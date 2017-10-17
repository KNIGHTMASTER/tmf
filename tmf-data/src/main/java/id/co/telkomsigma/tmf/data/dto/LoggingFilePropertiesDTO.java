package id.co.telkomsigma.tmf.data.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created on 10/17/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
@ConfigurationProperties("logging")
public class LoggingFilePropertiesDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1119725723427977973L;

    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
