package net.javaguides.springboot_rest_api.Project0.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // HTTP GET Request
    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld() {

        return "Hello World";
    }

}
