package net.riking.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  ///开启对EurekaClient的支持，即：作为Eureka客户端，高版本可省略
public class AppProvider {
    public static void main(String[] args) {
        SpringApplication.run(AppProvider.class, args);
    }

}
