package com.milind.springcloudsample.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FullNameController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/getFullName")
    public @ResponseBody String getSentence() {
        return getFirstName("spring-eureka-client-firstname") + " " + getMiddleName("spring-eureka-client-middlename")
                + " " + getLastName("spring-eureka-client-lastname") + ".";
    }

    private String getLastName(String serviceName) {
        List<ServiceInstance> list = client.getInstances(serviceName);
        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();
            if (uri != null) {
                return (new RestTemplate()).getForObject(uri + "/getLastName", String.class);
            }
        }
        return null;
    }

    private String getMiddleName(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();
            if (uri != null) {
                return (new RestTemplate()).getForObject(uri + "/getMiddleName", String.class);
            }
        }
        return null;
    }

    public String getFirstName(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();
            if (uri != null) {
                return (new RestTemplate()).getForObject(uri + "/getFirstName", String.class);
            }
        }
        return null;
    }
}
