/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

/**
 * $Id DemoConfig.java Dec 15,2016 wangguoxing@baidu.com $
 */
@Getter
@Component
public class DemoConfig {
    @Value("${email}")
    private String email;
}
