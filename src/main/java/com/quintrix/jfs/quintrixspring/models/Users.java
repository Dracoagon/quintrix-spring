package com.quintrix.jfs.quintrixspring.models;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"usersList"})
@Generated("josnschema2pojo")
public class Users {

  @JsonProperty("usersList")
  private List<User> usersList = null;

  @JsonProperty("usersList")
  public List<User> getUsersList() {
    return usersList;
  }

  @JsonProperty("usersList")
  public void setUsersList(List<User> usersList) {
    this.usersList = usersList;
  }

}

