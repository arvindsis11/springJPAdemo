package com.arvind.jpademo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any()).build()
                .apiInfo(metaData());

    }
    private ApiInfo metaData() {
        return new ApiInfo(
                "Spring Boot REST API",
                "one-to-many mapping demo",
                "1.0",
                "Terms of service",
                new Contact("Arvind Sisodiya", "https://github.com/arvindsis11", "arvindsis35@gmail.com"),
                "Open source",
                "https://github.com/arvindsis11");

    }

}
