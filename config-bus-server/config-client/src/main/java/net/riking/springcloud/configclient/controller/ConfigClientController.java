package net.riking.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config/client")
@RefreshScope//手动刷新配置文件信息
public class ConfigClientController {

    @Value("${name}")
    private String  name;

    @GetMapping
    public String name() {
        return  name ;
    }

}
