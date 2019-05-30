package com.example.sender.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/testController")
@RestController
public class testController {

    @Autowired
    private HelloSender helloSender;


    @RequestMapping("/test")
    public void hello() throws Exception {
        helloSender.send();
    }
}
