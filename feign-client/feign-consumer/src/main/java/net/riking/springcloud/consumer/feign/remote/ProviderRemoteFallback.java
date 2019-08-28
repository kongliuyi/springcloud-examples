package net.riking.springcloud.consumer.feign.remote;

import net.riking.springcloud.consumer.feign.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ProviderRemoteFallback implements ProviderRemote{
    @Override
    public User provider(String username) {
        User user =new User();
        user.setDescription("系统繁忙,请稍候再试");
        return user;
    }

    @Override
    public String port() {
        return "系统繁忙,请稍候再试";
    }
}
