package com.quintrix.jfs.quintrixspring.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspqing.services.CatService;
import com.quintrix.jfs.quintrixspring.models.Cat;

@RestController
public class CatController {

  @Autowired
  CatService catService;

  @RequestMapping(method = RequestMethod.GET, value = "/cats")
  List<Cat> getCats(@RequestParam(name = "name", required = false) String name) {
    return catService.getCats(name);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/cats/{id}")
  Cat getCatByID(@PathVariable("id") int id) {
    return catService.getCatDetails(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/cats")
  Cat addCat(@RequestBody Cat cat) {

    return catService.addCat(cat);
  }
}
