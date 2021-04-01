package com.oodlefinance.alex.megremis.external;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableAutoConfiguration
@EnableFeignClients
@EnableDiscoveryClient
public class Config {

}
