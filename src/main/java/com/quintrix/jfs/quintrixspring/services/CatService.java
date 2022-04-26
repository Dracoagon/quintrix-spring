package com.quintrix.jfs.quintrixspring.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.quintrix.jfs.quintrixspring.models.Cat;

@Service
public class CatService {

  List<Cat> catsList = new ArrayList<>(Arrays.asList(

      new Cat(1, "Carl", "Egyptian", 2), new Cat(2, "Felicia", "Calico", 4),
      new Cat(3, "Spatz", "Persian", 9)));

  public List<Cat> getCats(String name) {
    if (name != null) {
      return catsList.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
    } else {
      return catsList;
    }
  }

  public Cat getCatDetails(int id) {
    Optional<Cat> cat = catsList.stream().filter(p -> p.getId() == id).findAny();

    if (cat.isPresent()) {
      return cat.get();
    } else {
      return new Cat();
    }
  }

  public Cat addCat(Cat cat) {
    catsList.add(cat);
    return cat;
  }
}
