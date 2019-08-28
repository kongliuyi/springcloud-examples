package net.riking.springcloud.consumer.feign.entity;

import lombok.Data;

@Data
public class User {
/*        private String name;
        private String mobile;*/
        private String username;
        private String password;
        private String description;
/*        private Boolean enabled;
        private Boolean accountNonExpired;
        private Boolean credentialsNonExpired;
        private Boolean accountNonLocked;*/
}
