package com.example.railwaystation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth/")
public class AuthController {

    @GetMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/success")
    @CrossOrigin(origins = "http://localhost:4200")
    public String getSuccessPage(){
        return "success";
    }
}
