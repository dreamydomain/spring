package com.horace.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BeginController {

    @RequestMapping("/")
    public String index() {
        return "common/index.jsp";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
