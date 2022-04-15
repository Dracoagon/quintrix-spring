package com.quintrix.jfs.quintrixspring.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspring.models.Cat;

@RestController
public class CatController {

  // list of cats
  List<Cat> catsList = new ArrayList<>(Arrays.asList(

      new Cat(1, "Carl", "Egyptian", 2), new Cat(2, "Felicia", "Calico", 4),
      new Cat(3, "Spatz", "Persian", 9)));

  // return the full list
  @RequestMapping(method = RequestMethod.GET, value = "/cats")
  List<Cat> getCats(@RequestParam(name = "name", required = false) String name) {

    if (name != null) {
      return catsList.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
    } else {
      return catsList;
    }
  }

  // return cats with a specific id
  @RequestMapping(method = RequestMethod.GET, value = "/cats/{id}")
  Cat getCatDetails(@PathVariable("id") int id) {

    Optional<Cat> result = catsList.stream().filter(p -> p.getId() == id).findAny();

    if (result.isPresent()) {
      return result.get();
    } else {
      return null;
    }
  }

  // add a cat to the list
  @RequestMapping(method = RequestMethod.POST, value = "/cats")
  Cat addCat(@RequestBody Cat cat) {

    catsList.add(cat);

    return cat;
  }



}
