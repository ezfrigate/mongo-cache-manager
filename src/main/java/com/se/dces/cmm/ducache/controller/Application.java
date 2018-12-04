package com.se.dces.cmm.ducache.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.se.dces.cmm.ducache"})
@EnableMongoRepositories(basePackages= {"com.se.dces.cmm.ducache.mongo"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}