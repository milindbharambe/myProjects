package com.milind.springcloudsample.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiddleNameController {

    @Value("${middleNames}")
    private String middleNames;

    @GetMapping("/getMiddleName")
    public @ResponseBody String getMiddleName() {
        String[] wordArray = middleNames.split(",");
        int i = (int) Math.round(Math.random() * (wordArray.length - 1));
        return wordArray[i];
    }
}
