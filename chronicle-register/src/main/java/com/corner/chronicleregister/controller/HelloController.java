package com.corner.chronicleregister.controller;

import com.corner.chronicleregister.entity.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("register")
public class HelloController {

    @GetMapping
    @ResponseBody
    public String hello(){
        return "Test data hii";
    }
}
