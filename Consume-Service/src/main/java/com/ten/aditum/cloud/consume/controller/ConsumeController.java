package com.ten.aditum.cloud.consume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/consume")
public class ConsumeController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${PRODUCESERVICEURL}")
    private String PRODUCESERVICEURL;

    @RequestMapping(value = "/{string}")
    public String consume(@PathVariable String string) {
        System.out.println("Cousume收到内容：" + string);
        ResponseEntity<String> rateResponse =
                restTemplate.exchange(
                        PRODUCESERVICEURL + "/produce/" + string,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<String>() {
                        });
        String response = rateResponse.getBody();
        System.out.println("Consume调用Produce得到结果：" + response);
        return response;
    }
}
