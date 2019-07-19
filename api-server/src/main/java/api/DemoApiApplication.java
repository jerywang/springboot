/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * api.DemoApiApplication.java 10 Mar 2019 wangguoxing
 * <p>
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DemoApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApiApplication.class, args);
    }
}
