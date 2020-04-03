package net.riking.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient  ///开启对EurekaClient的支持，即：作为Eureka客户端，高版本可省略
public class AppProvider {
    private static final ThreadLocal<String> threadCtx = new ThreadLocal<>();
    public static void main(String[] args) {
        SpringApplication.run(AppProvider.class, args);
    }

}
