package br.com.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages = "br.com.desafio.*")
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

