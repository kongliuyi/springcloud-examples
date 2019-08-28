package net.riking.springcloud.eureka.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer//开启对EurekaServer的支持，即：作为Eureka服务端
@SpringBootApplication
public class AppEurekaCluster7002 {

    public static void main(String[] args) {
        SpringApplication.run(AppEurekaCluster7002.class, args);
    }

}
