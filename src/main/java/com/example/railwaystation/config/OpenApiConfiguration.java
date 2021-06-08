package com.example.railwaystation.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
  @Bean
  public OpenAPI customOpenApi(){
    return new OpenAPI()
      .info(
        new Info()
          .title("railway-coursework")
          .version("1.0")
          .contact(new Contact()
            .email("voroshchuk721@gmail.com")
            .name("Oleksandr Voroshchuk"))
      );
  }
}
