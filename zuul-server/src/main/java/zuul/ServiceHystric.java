/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package zuul;

import org.springframework.stereotype.Component;

/**
 * ServiceHystric.java 04 Apr 2019 wangguoxing
 * <p>
 * Description:
 */
@Component
public class ServiceHystric implements ServiceHiProxy {
    public String sayHiFromClientOne(String name) {
        return "Service is not available";
    }
}
