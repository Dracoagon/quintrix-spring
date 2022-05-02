package com.quintrix.jfs.quintrixspring.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quintrix.jfs.quintrixspring.models.Cat;
import com.quintrix.jfs.quintrixspring.repositories.CatRepository;

@Service
public class CatService {

  private static final Logger logger = LoggerFactory.getLogger(CatService.class);

  @Autowired
  private CatRepository catRepo;

  public List<Cat> getCats(String name) {
    List<Cat> catsList = catRepo.findAll();

    if (name != null) {
      logger.debug("Service: Retrieved name value: {}", name);
      return catsList.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
    } else {
      logger.debug("Service: Retrieved all");
      return catsList;
    }
  }

  public Cat getCatDetails(int id) {
    List<Cat> catsList = catRepo.findAll();

    Optional<Cat> cat = catsList.stream().filter(p -> p.getId() == id).findAny();

    if (cat.isPresent()) {
      logger.debug("Service: Retrieved ID value: {}", id);
      return cat.get();
    } else {
      logger.error("Service error: Could not retrieve ID value: {}", id);
      throw new IllegalStateException("Could not find mathcing Id");
    }
  }

  public Cat addCat(Cat cat) {
    List<Cat> catsList = catRepo.findAll();

    catsList.add(cat);
    logger.debug("Service: post completed.");
    return cat;
  }
}
