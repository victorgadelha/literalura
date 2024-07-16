package br.com.victorgadelha.literalura.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class EnvConfiguration {

    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure().load();
    }
}
