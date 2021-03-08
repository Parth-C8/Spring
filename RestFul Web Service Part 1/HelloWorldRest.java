package com.example.restfulWebServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRest {

    //@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    @GetMapping(path = "/welcome-rest")
    public String getMessageRest() {
        return "Welcome to spring boot";
    }

    //using a seperate bean for displaying the message
    @GetMapping(path = "/welcome-bean")
    public HelloWorldBean getMessageBean() {
        return new HelloWorldBean("Welcome to spring boot");
    }


    //displaying a name preent in the path along with message
    @GetMapping(path = "/welcome-bean/{name}")
    public HelloWorldBean getMessagePath(@PathVariable String name) {

        return new HelloWorldBean(String.format("Welcome to spring boot %s", name));
    }
}
