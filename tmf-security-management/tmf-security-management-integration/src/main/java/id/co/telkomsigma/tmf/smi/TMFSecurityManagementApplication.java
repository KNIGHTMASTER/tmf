package id.co.telkomsigma.tmf.smi;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created on 8/31/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(TMFConstant.Common.BASE_PACKAGES)
@EntityScan(TMFConstant.Common.BASE_PACKAGES)
@EnableJpaRepositories(TMFConstant.Common.BASE_PACKAGES)
public class TMFSecurityManagementApplication {

    public static void main(String [] args){
        SpringApplication.run(TMFSecurityManagementApplication.class, args);
    }
}
