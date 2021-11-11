package br.com.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.desafio.*")
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

