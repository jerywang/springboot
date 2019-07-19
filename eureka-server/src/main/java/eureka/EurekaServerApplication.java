/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
// idea启动配置--spring.profiles.active=eureka-server1

// 命令行启动如下
// java -jar target/eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=eureka-server1
// java -jar target/eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=eureka-server2
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
