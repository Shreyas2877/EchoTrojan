package com.trojan.echotrojan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EchoTrojanApplication {

    public static void main(String[] args) {
        SpringApplication.run(EchoTrojanApplication.class, args);
    }

};