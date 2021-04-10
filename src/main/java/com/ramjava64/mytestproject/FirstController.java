package com.ramjava64.mytestproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @RequestMapping(method= RequestMethod.GET, path = "/home")
    public String name(){
        return "Ramchander";
    }
}
