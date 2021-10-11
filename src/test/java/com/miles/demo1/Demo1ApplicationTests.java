package com.miles.demo1;

import com.miles.demo1.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Demo1ApplicationTests {
    @Resource
    public TestService testService;

    @Test
    void contextLoads() {
        testService.test();
    }

}
