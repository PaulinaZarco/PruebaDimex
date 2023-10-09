package com.dimex.examen;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages =
{
    "com.dimex.examen"
})

public class ExamenApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ExamenApplication.class, args);
    }
    /*
    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion)
    {
        return new OpenAPI().info(new Info()
                .title("Swagger")
                .version(appVersion)
                .description("Swagger")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0")
                        .url("http://springdoc.org")));
    }
     */
}
