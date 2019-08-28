package net.riking.springcloud.consumer.feign.remote;

import net.riking.springcloud.consumer.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider", fallback = ProviderRemoteFallback.class)
public interface ProviderRemote {
    @GetMapping("/user/provider")
    User provider(@RequestParam String username);

    @GetMapping("/user/provider/port")
     String port();
}
