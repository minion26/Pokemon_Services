package com.fiipractic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartingPageApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(StartingPageApplication.class, args);
    }
}