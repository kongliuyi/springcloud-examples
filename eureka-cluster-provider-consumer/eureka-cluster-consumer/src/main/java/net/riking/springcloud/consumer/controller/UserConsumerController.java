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
        return  "消费服务："+result ;
    }

    @GetMapping("/port")
    public String port() {
        String result = restTemplate.getForObject(REST_URL_PREFIX+"/user/provider/port", String.class);
        return  "消费服务："+result ;
    }

    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @GetMapping(value = "/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/provider/discovery", Object.class);
    }


}
