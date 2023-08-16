package com.danicodes.spring.proyecto.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        Server devServer = new Server();
        devServer.setUrl("http://localhost:8090/");
        devServer.setDescription("URL del servidor Local");

        Server prodServer = new Server();
        prodServer.setUrl("https://logistic-project.com");
        prodServer.setDescription("URL del servidor en Producción");

        Contact contact = new Contact();
        contact.setEmail("soporte@logistic-project.com");
        contact.setName("SoporteTI");
        contact.setUrl("https://www.logistic-project.com");

        Info info = new Info()
                .title("Logistic Project API")
                .version("1.0")
                .contact(contact)
                .description("Documento que expone la API construida en la aplicación: Logistic Project")
                .termsOfService("https://www.logistic-project.com/terms");

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer, prodServer));
    }

    @Bean
    public ModelResolver modelResolver(ObjectMapper objectMapper) {

        return new ModelResolver(objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE));
    }
}
