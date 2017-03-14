/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.po.UserPo;

/**
 * $Id UserMapper.java Dec 15,2016 wangguoxing@baidu.com $
 */
@Repository
public interface UserMapper {
    UserPo getUserByName(String username);
}