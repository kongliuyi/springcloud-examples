package net.riking.springcloud.consumer.ribbon.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import net.riking.springcloud.consumer.ribbon.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/consumer")
public class UserConsumerController {


    @Autowired
    UserService userService;

    @GetMapping
    public String consumer(@RequestParam String username) {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String result = userService.consumer(username);
        context.close();
        return  "消费服务："+result ;
    }


    @GetMapping("/port")
    public String port() {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String result = userService.port();
        context.close();
        return  "消费服务："+result ;
    }
}
