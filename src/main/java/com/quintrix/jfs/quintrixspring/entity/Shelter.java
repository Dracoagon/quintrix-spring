package com.quintrix.jfs.quintrixspring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shelter {

  @Id
  private Integer id;

  private String name;
  private String manager;
  private String city;
  private Integer numCats;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Integer getNumCats() {
    return numCats;
  }

  public void setNumCats(Integer numCats) {
    this.numCats = numCats;
  }


}
