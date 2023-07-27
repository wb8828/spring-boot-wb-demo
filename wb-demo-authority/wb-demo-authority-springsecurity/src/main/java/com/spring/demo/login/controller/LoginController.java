package com.spring.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class LoginController {


    @GetMapping(value = "/view/login")
    public String loginView() {
        return "login";
    }

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

//    @PostMapping(value = "/login")
//    public String login(String userName,String password) {
//        if ("123".equals(userName) && "123".equals(password)){
//            return  index();
//        }
//        return "login";
//    }
}