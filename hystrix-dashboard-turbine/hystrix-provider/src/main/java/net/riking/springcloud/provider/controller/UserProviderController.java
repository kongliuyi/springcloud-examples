package net.riking.springcloud.provider.controller;

import net.riking.springcloud.provider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/provider")
public class UserProviderController {

    @Autowired
    private DiscoveryClient client;

    @Value("${server.port}")
    private String  port;

    @GetMapping
    public User provider(@RequestParam String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword("provider-eureka7001");
        user.setDescription("注册服务提供者");
        return  user ;
    }

    @GetMapping("/port")
    public String port() {
        return  "调用提供者provider端口号："+port ;
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
