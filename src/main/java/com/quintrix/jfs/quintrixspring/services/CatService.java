package com.quintrix.jfs.quintrixspring.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quintrix.jfs.quintrixspring.models.Cat;
import com.quintrix.jfs.quintrixspring.repositories.CatRepository;

@Service
public class CatService {

  @Autowired
  private CatRepository catRepo;

  public List<Cat> getCats(String name) {
    List<Cat> catsList = catRepo.findAll();

    if (name != null) {
      return catsList.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
    } else {
      return catsList;
    }
  }

  public Cat getCatDetails(int id) {
    List<Cat> catsList = catRepo.findAll();

    Optional<Cat> cat = catsList.stream().filter(p -> p.getId() == id).findAny();

    if (cat.isPresent()) {
      return cat.get();
    } else {
      return new Cat();
    }
  }

  public Cat addCat(Cat cat) {
    List<Cat> catsList = catRepo.findAll();

    catsList.add(cat);
    return cat;
  }
}
