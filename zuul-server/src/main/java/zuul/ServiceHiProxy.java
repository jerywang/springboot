/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package zuul;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi", fallback = ServiceHystric.class)
public interface ServiceHiProxy {
    @RequestMapping(value = "/demo/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}