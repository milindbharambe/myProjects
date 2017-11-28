package com.milind.springcloudsample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FullNameController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getFullName")
    public @ResponseBody String getSentence() {
        return getFirstName("spring-eureka-client-firstname") + " " + getMiddleName("spring-eureka-client-middlename")
                + " " + getLastName("spring-eureka-client-lastname") + ".";
    }

    private String getLastName(String serviceName) {
        return restTemplate.getForObject("http://" + serviceName + "/getLastName", String.class);
    }

    private String getMiddleName(String serviceName) {
        return restTemplate.getForObject("http://" + serviceName + "/getMiddleName", String.class);
    }

    public String getFirstName(String serviceName) {
        return restTemplate.getForObject("http://" + serviceName + "/getFirstName", String.class);
    }
}
