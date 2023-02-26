package com.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@PropertySource("classpath:application-${spring.properties.active:default}.properties")
@SpringBootApplication
public class SpringBootBookSellerApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringBootBookSellerApplication.class, args);
    }

}
