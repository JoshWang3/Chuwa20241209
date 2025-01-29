package com.chuwa.redbook.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Chuwa RedBook")
                        .version("1.0.0")
                        .description("API documentation for Chuwa RedBook")
                        .termsOfService("***")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")));
    }
}