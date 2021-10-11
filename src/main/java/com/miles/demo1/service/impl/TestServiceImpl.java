package com.miles.demo1.service.impl;

import com.miles.demo1.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Classname TestServiceImpl
 * @Description TODO
 * @Date 2021-8-20 16:07
 * @Created by ChenMX
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    @Override
    public void test() {
        System.out.println("TestService.test...");
    }
}
