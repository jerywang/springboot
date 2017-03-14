/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.example.po;

import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * $Id UserPo.java Dec 15,2016 wangguoxing@baidu.com $
 */
@Setter
@Getter
@Component
public class UserPo {
    private int id;
    private String username;
    private String password;
    void test() throws Exception {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.accept();
    }
}
