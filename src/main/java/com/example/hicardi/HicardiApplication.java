package com.example.hicardi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HicardiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HicardiApplication.class, args);
    }

}
