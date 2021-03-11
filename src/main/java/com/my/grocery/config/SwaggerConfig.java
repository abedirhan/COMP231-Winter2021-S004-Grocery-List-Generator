package com.my.grocery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private final String APIs = "com.my.grocery.controller";

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("APIs")
                .select()
                .apis(RequestHandlerSelectors.basePackage(APIs))
                .paths(PathSelectors.any()).build()
                .apiInfo(apiInfo());
    }
//    @Bean
//    public Docket swaggerApiMy() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("My")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.my.grocery.controller.v1.api.my"))
//                .paths(PathSelectors.any()).build().apiInfo(apiInfo());;
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Ayhan Saglam")
                .description("Ayhan_COMP231_GroceryBuilder").termsOfServiceUrl("")
                .contact(new Contact("Ayhan Saglam", "https://centennialcollege.ca/", "asaglam@my.centennialcollege.ca"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("0.0.1")
                .build();
    }
}
