package id.co.telkomsigma.tmf.integration.config;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 7/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
@ComponentScan(basePackages = TMFConstant.Common.BASE_PACKAGES)
@EnableSwagger2
@Order(5)
public class SwaggerConfiguration {

    @Bean
    public Docket coreAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Core APIs")
                .apiInfo(metaData())
                .select()
                .apis(RequestHandlerSelectors.basePackage(TMFConstant.Common.BASE_PACKAGES))
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }

    @Bean
    public Docket securityAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Security APIs")
                .apiInfo(metaData())
                .select()
                .apis(RequestHandlerSelectors.basePackage(TMFConstant.Common.BASE_PACKAGES))
                .paths(PathSelectors.regex("/auth.*"))
                .build();
    }

    @Bean
    public Docket publicAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Public APIs")
                .apiInfo(metaData())
                .select()
                .apis(RequestHandlerSelectors.basePackage(TMFConstant.Common.BASE_PACKAGES))
                .paths(PathSelectors.regex("/public.*"))
                .build();
    }

    private ApiInfo metaData() {
        List<VendorExtension> vendorExtensions = new ArrayList<>();
        vendorExtensions.add(new SampleVendorExtension());
        return new ApiInfo(
                "Telkomsigma REST API",
                "Telkomsigma REST API for Microservices Projects",
                "1.0",
                "Terms of service",
                new Contact("Achmad Fauzi", "https://telkomsigma.co.id", "fauzi.knightmaster.achmad@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                vendorExtensions);
    }


    private class SampleVendorExtension implements VendorExtension<String>{

        @Override
        public String getName() {
            return "sample vendor extension";
        }

        @Override
        public String getValue() {
            return "1.0.0";
        }
    }
    /*private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/api.*")).build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        new SecurityReference("mykey", authorizationScopes);
        List<SecurityReference> result = new ArrayList<>();
        result.add(new SecurityReference("mykey", authorizationScopes));
        return result;
    }

    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration("123456", "test-app-realm", "clientapp", "apiKey");
    }*/

}
