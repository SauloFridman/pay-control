package br.com.paycontrol.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("RESTful API with Java 19 adapted in Spring Boot 3.1.0-M2")
                        .version("v1")
                        .description("API for persistence in database about players and your payments")
                        .termsOfService("http://pub.saulo.com.br/people")
                        .license(new License().name("Apache 2.0")
                                .url("http://pub.saulo.com.br/people"))
                );
    }
}
