package net.riking.springcloud.provider.controller;

import net.riking.springcloud.provider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/provider")
public class UserProviderController {
    @Autowired
    private DiscoveryClient client;

    @GetMapping
    public User provider(@RequestParam String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword("provider-eureka7001");
        user.setDescription("注册服务提供者");
        return  user ;
    }

    @GetMapping(value = "/discovery")
    public Object discovery()
    {
        List<String> list = client.getServices();
        list.stream().forEach(a->
                {
                    List<ServiceInstance> srvList = client.getInstances(a);
                    srvList.stream().forEach(element->System.out.println("ServiceId:"+element.getServiceId() + "\t Host:" + element.getHost() + "\t Port:"
                            + element.getPort() + "\t Uri:"+ element.getUri()));
                }
        );
        return this.client;
    }
}