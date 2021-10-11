package com.miles.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname HelloController
 * @Description 1
 * @Date 2021-8-10 14:02
 * @Created by ChenMX
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "002_javascript01";
    }

     @RequestMapping("/helloWorld")
    public String helloWorld() {
        return "001_helloWorld";
    }
}