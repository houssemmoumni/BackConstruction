package tn.esprit.gestion_negociation.Configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Applique sur toutes les URL
                .allowedOrigins("http://localhost:4200") // Autorise Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Méthodes HTTP permises
                .allowedHeaders("*") // Tous les headers sont autorisés
                .allowCredentials(true); // Autorise l'envoi de credentials (cookies, autorisations, etc.)
    }
}