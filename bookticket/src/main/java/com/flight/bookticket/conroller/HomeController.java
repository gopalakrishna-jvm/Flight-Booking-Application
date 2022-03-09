package com.flight.bookticket.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.bookticket.repository.UserRepository;

@RestController
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String homePage(){
        return "home.html";
    }

    @RequestMapping("/AdminLogin")
    public String adminLoginPage(){
        return "adminLogin.html";
    }

    @RequestMapping("/Registration")
    public String userRegistrationPage(){ return "userRegistration.html";}

    @RequestMapping("/UserLogin")
    public String userLoginPage(){

        return "userLogin.html";
    }
}