package net.riking.springcloud.consumer.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class AppConsumer {
    public static void main(String[] args) {
        SpringApplication.run(AppConsumer.class, args);
    }

    @Bean
    @LoadBalanced   //如果提供者服务为集群，当在请求时，拥有客户端负载均衡的能力,这里就不做演示
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
