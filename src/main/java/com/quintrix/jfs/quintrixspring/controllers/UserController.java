package com.quintrix.jfs.quintrixspring.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspring.models.User;
import com.quintrix.jfs.quintrixspring.services.UserService;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(method = RequestMethod.GET, value = "/users")
  List<User> getUsers(@RequestParam(name = "name", required = false) String name) {
    return userService.getUsers(name);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
  User getUserByID(@PathVariable("id") int id) {
    return userService.getUserDetails(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/users")
  User addCat(@RequestBody User user) {

    return userService.addUser(user);
  }
}
