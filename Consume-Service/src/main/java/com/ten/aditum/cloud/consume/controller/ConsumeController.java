package com.ten.aditum.cloud.consume.controller;

import com.ten.aditum.cloud.consume.service.ProduceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/consume")
public class ConsumeController {

    @Autowired
    private ProduceClient produceClient;

//    @Value("${PRODUCESERVICEURL}")
//    private String PRODUCESERVICEURL;

    @RequestMapping(value = "/{string}")
    public String consume(@PathVariable String string) {
        System.out.println("Cousume收到内容：" + string);
        String response;
        try {
            response = produceClient.produce(string);
        } catch (Exception e) {
            System.out.println("Feign调用异常：");
            e.printStackTrace();
            return "Consume调用Feign异常！";
        }
        System.out.println("Consume调用Produce得到结果：" + response);
        return response;
    }

//    ResponseEntity<String> rateResponse =
//            restTemplate.exchange(
//                    PRODUCESERVICEURL + "/produce/" + string,
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<String>() {
//                    });
//    String response = rateResponse.getBody();
}
