package com.amaris.futbol.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.amaris.futbol.domain" })
public class FutbolApplication {

    public static void main(final String[] args) {

        ApplicationContext context =
            SpringApplication.run(FutbolApplication.class, args);

        System.out.println("Contains A  "
            + context.containsBeanDefinition("ProductService"));
    }
}
