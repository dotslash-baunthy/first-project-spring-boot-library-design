package com.akshitbaunthiyal.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket libraryApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("Library-API")
                .select().apis(RequestHandlerSelectors.basePackage("com.akshitbaunthiyal.library.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Library API")
                .description("Library-API reference for developers")
                .termsOfServiceUrl("https://fakelibrary.com")
                .contact(new Contact("Fake Library", "https://fakelibrary.com", "akshit.baunthy@gmail.com"))
                .license("Library License")
                .licenseUrl("https://fakelibrary.com")
                .version("1.0")
                .build();
    }
}
