package net.riking.springcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user/consumer")
public class UserConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://PROVIDER";

    @GetMapping
    public String consumer(@RequestParam String username) {
        String result = restTemplate.getForObject(REST_URL_PREFIX+"/user/provider?username="+username, String.class);
        return  "消费者服务："+result ;
    }

}