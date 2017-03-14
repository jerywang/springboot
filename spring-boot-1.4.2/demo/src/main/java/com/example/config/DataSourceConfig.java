/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

/**
 * $Id DataSourceConfig.java Dec 15,2016 wangguoxing@baidu.com $
 */
@Getter
@Component
public class DataSourceConfig {

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceClassName;

    @Value("${spring.datasource.initial-size}")
    private int initialSize;

    @Value("${spring.datasource.max-active}")
    private int maxActive;

    @Value("${spring.datasource.max-idle}")
    private int maxIdle;

    @Value("${spring.datasource.min-idle}")
    private int minIdle;

    @Value("${spring.datasource.test-on-borrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.test-on-return}")
    private boolean testOnReturn;

    @Value("${spring.datasource.validation-query}")
    private String validationQuery;

}