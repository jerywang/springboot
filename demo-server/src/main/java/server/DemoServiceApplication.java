/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * server.DemoServiceApplication.java 10 Mar 2019 wangguoxing
 * <p>
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/demo")
public class DemoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoServiceApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }
}
