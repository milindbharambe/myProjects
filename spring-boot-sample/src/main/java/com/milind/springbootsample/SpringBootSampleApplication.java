package com.milind.springbootsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.milind.springbootsample")
// to scan JPA entities in project
// @EntityScan(basePackages = "com.milind.springbootsample")
/*
 * public class SpringBootSampleApplication extends SpringBootServletInitializer {
 * 
 *//**
   * For Web app running as a WAR
   *//*
     * @Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { return
     * builder.sources(SpringBootSampleApplication.class); } }
     */

public class SpringBootSampleApplication {

    /**
     * For eclipse, jar running
     */

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }

}
