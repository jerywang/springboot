/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.example.config;

import javax.annotation.PreDestroy;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * $Id MyBatisConfig.java Dec 15,2016 wangguoxing@baidu.com $
 */
@Configuration
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer {

    private DataSource dataSource;

    @Autowired
    private DataSourceConfig config;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        this.dataSource = new DataSource();
        this.dataSource.setDriverClassName(config.getDataSourceClassName());
        this.dataSource.setUrl(config.getDataSourceUrl());
        this.dataSource.setUsername(config.getUser());
        this.dataSource.setPassword(config.getPassword());
        this.dataSource.setInitialSize(config.getInitialSize());
        this.dataSource.setMaxActive(config.getMaxActive());
        this.dataSource.setMaxIdle(config.getMaxIdle());
        this.dataSource.setMinIdle(config.getMinIdle());
        this.dataSource.setTestOnBorrow(config.isTestOnBorrow());
        this.dataSource.setTestOnReturn(config.isTestOnReturn());
        this.dataSource.setValidationQuery(config.getValidationQuery());
        return this.dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(this.dataSource());
        bean.setTypeAliasesPackage("com.example.po");

        //        //分页插件
        //        PageHelper pageHelper = new PageHelper();
        //        Properties properties = new Properties();
        //        properties.setProperty("reasonable", "true");
        //        properties.setProperty("supportMethodsArguments", "true");
        //        properties.setProperty("returnPageInfo", "check");
        //        properties.setProperty("params", "count=countSql");
        //        pageHelper.setProperties(properties);
        //
        //        //添加插件
        //        bean.setPlugins(new Interceptor[]{pageHelper});

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }

    @PreDestroy
    public void close() {
        if (this.dataSource != null) {
            this.dataSource.close();
        }
    }
}