package pl.pjwstk.edu.jaz18552nbp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.pjwstk.edu.jaz18552nbp"))
                .paths(PathSelectors.any())
                .build().apiInfo(myApiInfo());

    }

    private ApiInfo myApiInfo() {
        return new ApiInfo(
                "NBP REST API",
                "NBP REST API",
                "v1.00",
                "NbpServiceZaliczenie",
                new Contact("Jakub Słomiński", "https://www.example.com", "s18552@pjwstk.edu.pl"),
                "my own LicenseX123", "www.example123.com", Collections.emptyList());

    }
}