package net.riking.springcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user/consumer")
public class UserConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${server.port}")
    private String  port;

    private static final String REST_URL_PREFIX = "http://PROVIDER";


    @GetMapping("/port")
    public String port() {
        return  port ;
    }

    @GetMapping("/message")
    public String message() {
        String result = restTemplate.getForObject(REST_URL_PREFIX+"/user/provider/message?msg=我能查看一下你的端口号吗？", String.class);
        System.out.println(result);
        result= restTemplate.getForObject(REST_URL_PREFIX+"/user/provider/port", String.class);
        return  "提供方端口号："+result ;
    }


}