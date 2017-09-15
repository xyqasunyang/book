package com.sun.www.service.impl;

import org.springframework.stereotype.Component;

/**
 * @author suny
 * @version 1.0
 * @date 2017年09月05日
 */
@Component
public class TaskTest {

    public void run() throws Exception {
        while (true) {
            Thread.sleep(2000);
            System.out.println("test");
        }
    }
}
