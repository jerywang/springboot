/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.DemoConfig;
import com.example.mapper.UserMapper;
import com.example.po.UserPo;

import lombok.extern.log4j.Log4j;

/**
 * $Id DemoController.java Dec 14,2016 wangguoxing@baidu.com $
 */
@Log4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/{name}")
    public UserPo demoView(@PathVariable("name") String name) {
        log.info("当前机房: " + System.getProperty("idc"));
        return userMapper.getUserByName(name);
    }
}