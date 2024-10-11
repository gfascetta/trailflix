package com.galu.trailflix.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Aplica cors a todas las rutas de la api
                        .allowedOrigins("http://localhost:5174") // Dominio del frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                        .allowedHeaders("*") // Permite cualquier encabezado
                        .allowCredentials(true); // Permite enviar credenciales (como cookies o tokens de autenticacion)
            }
        };
    }
}