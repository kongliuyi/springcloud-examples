package net.riking.springcloud.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/user/provider")
public class UserProviderController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://CONSUMER";

    @Value("${server.port}")
    private String  port;

    @GetMapping("/message")
    public String message(@RequestParam String msg) {
        System.out.println(msg);
        String result = restTemplate.getForObject(REST_URL_PREFIX+"/user/consumer/port", String.class);
        System.out.println("鉴权您的指令为"+result+"，指令正确...");
        return  "可以，请您直接调用我的端口号接口" ;
    }


    @GetMapping("/port")
    public String port() {
        return  port ;
    }

}