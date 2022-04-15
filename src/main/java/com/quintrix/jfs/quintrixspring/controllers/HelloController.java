package com.quintrix.jfs.quintrixspring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @RequestMapping("/")
  String HelloWorld() {
    String hello = "Hello World, Spring Boot!";
    return hello;
  }

}
