package id.co.telkomsigma.tmf.integration.config;

import id.co.telkomsigma.tmf.integration.exception.TMFAsyncUncaughtExceptionHandler;
import id.co.telkomsigma.tmf.util.common.network.FTPConnection;
import id.co.telkomsigma.tmf.util.common.network.ParamFTPServer;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.concurrent.Executor;

/**
 * Created on 7/26/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
@EnableAsync
@Order(2)
public class WebServiceConfig implements AsyncConfigurer {

    @Value("${thread.corepoolsize}")
    int threadCorePoolSize;

    @Value("${thread.maxpoolsize}")
    int threadMaxPoolSize;

    @Value("${thread.queuecapacity}")
    int threadQueueCapacity;

    @Value("${ftp.host}")
    private String ipServer;

    @Value("${ftp.port}")
    private String ftpPort;

    @Value("${ftp.username}")
    private String ftpUserName;

    @Value("${ftp.password}")
    private String ftpPassword;

    @Value("${ftp.passivemode}")
    private String ftpPassiveMode;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /*@Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(threadCorePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(threadMaxPoolSize);
        threadPoolTaskExecutor.setQueueCapacity(threadQueueCapacity);
        return threadPoolTaskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new TMFAsyncUncaughtExceptionHandler();
    }

    @Bean
    @ConditionalOnProperty(name = "ftp.enabled", havingValue = "true", matchIfMissing = true)
    public ParamFTPServer paramFTPServer(){
        ParamFTPServer paramFTPServer = new ParamFTPServer();
        paramFTPServer.setIpServer(ipServer);
        paramFTPServer.setFtpPort(ftpPort);
        paramFTPServer.setFtpUserName(ftpUserName);
        paramFTPServer.setFtpPassword(ftpPassword);
        paramFTPServer.setFtpPassiveMode(ftpPassiveMode);
        return paramFTPServer;
    }

    @Bean
    @ConditionalOnProperty(name = "ftp.enabled", havingValue = "true", matchIfMissing = true)
    public FTPConnection ftpConnection(){
        return new FTPConnection(new FTPClient());
    }

}
