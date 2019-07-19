/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    ServiceHiProxy serviceHiProxy;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return serviceHiProxy.sayHiFromClientOne(name);
    }
}