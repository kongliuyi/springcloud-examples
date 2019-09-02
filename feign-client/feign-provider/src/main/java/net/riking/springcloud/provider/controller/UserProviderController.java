package net.riking.springcloud.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/provider")
public class UserProviderController {

    @Autowired
    private DiscoveryClient client;

    @Value("${server.port}")
    private String  port;

    @GetMapping("/port")
    public String port() {
        return  "调用提供者provider端口号："+port ;
    }

}