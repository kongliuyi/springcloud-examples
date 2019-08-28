package net.riking.springcloud.consumer.feign.controller;

import net.riking.springcloud.consumer.feign.entity.User;
import net.riking.springcloud.consumer.feign.remote.ProviderRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/consumer")
public class UserConsumerController {


    @Autowired
    ProviderRemote providerRemote;

    @GetMapping
    public User consumer(@RequestParam String username) {
        User user = providerRemote.provider(username);
        user.setDescription("消费服务:"+user.getDescription());
        return  user;
    }


    @GetMapping("/port")
    public String port() {
        return  "消费服务："+providerRemote.port() ;
    }
}
