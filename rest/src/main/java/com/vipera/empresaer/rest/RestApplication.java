package com.vipera.empresaer.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.vipera.empresaer.dao.repositories")
@ComponentScan(basePackages = {"com.vipera.empresaer.dao.repositories","com.vipera.empresaer.*"})
@EntityScan(basePackages = "com.vipera.empresaer.dao.models")
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}
