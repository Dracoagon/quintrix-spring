package com.quintrix.jfs.quintrixspring.controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspring.models.Cat;
import com.quintrix.jfs.quintrixspring.services.CatService;

@RestController
public class CatController {

  private static final Logger logger = LoggerFactory.getLogger(CatController.class);

  @Autowired
  CatService catService;

  @RequestMapping(method = RequestMethod.GET, value = "/cats")
  List<Cat> getCats(@RequestParam(name = "name", required = false) String name) {
    logger.debug("Request: called getCats value: {}", name);
    return catService.getCats(name);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/cats/{id}")
  Cat getCatByID(@PathVariable("id") int id) {

    logger.debug("Request: Called getCatByID value: {}", id);
    return catService.getCatDetails(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/cats")
  Cat addCat(@RequestBody Cat cat) {
    logger.debug("Request: Called addCat params: {}", cat.getId(), cat.getName(), cat.getBreed(),
        cat.getAge());
    return catService.addCat(cat);
  }
}
