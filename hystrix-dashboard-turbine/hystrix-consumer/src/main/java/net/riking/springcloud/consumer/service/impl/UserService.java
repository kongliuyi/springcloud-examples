package net.riking.springcloud.consumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://PROVIDER";


    @HystrixCommand(fallbackMethod = "consumerFallback")//服务降级处理
    @CacheResult//开启请求缓存功能
    public String consumer( String username) {
        String result = restTemplate.getForObject(REST_URL_PREFIX+"/user/provider?username="+username, String.class);
        return  "消费服务："+result ;
    }


    @HystrixCommand(fallbackMethod = "userFallback")//服务降级处理
    @CacheResult//开启请求缓存功能
    public String port() {
        String result = restTemplate.getForObject(REST_URL_PREFIX+"/user/provider/port", String.class);
        return  "消费服务："+result ;
    }
    //服务降级处理实现
    public String consumerFallback(String username) {
        return "系统繁忙,请稍候再试";
    }
    //服务降级处理实现
    public String userFallback() {
        return "系统繁忙,请稍候再试";
    }
}
