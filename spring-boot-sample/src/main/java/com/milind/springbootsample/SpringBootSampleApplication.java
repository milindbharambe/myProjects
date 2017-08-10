package com.milind.springbootsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.milind.springbootsample")
// to scan JPA entities in project
// @EntityScan(basePackages = "com.milind.springbootsample")
public class SpringBootSampleApplication extends SpringBootServletInitializer {

    /**
     * For eclipse, jar running
     * 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }

    /**
     * For Web app running as a WAR
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootSampleApplication.class);
    }

}

/**
 * For eclipse, jar running
 */
/*
 * public class SpringBootSampleApplication {
 * 
 * public static void main(String[] args) { SpringApplication.run(SpringBootSampleApplication.class, args); } }
 */
