package com.quintrix.jfs.quintrixspring.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.quintrix.jfs.quintrixspring.models.User;

@Service
public class UserService {

  @Autowired
  RestTemplate restTemplate;

  public List<User> getUsers(String name) {
    ResponseEntity<List<User>> userListResponseBody =
        restTemplate.exchange("https://gorest.co.in/public/v2/users", HttpMethod.GET, null,
            new ParameterizedTypeReference<List<User>>() {});

    List<User> userList = null;

    if (userListResponseBody.getStatusCode() == HttpStatus.OK) {
      userList = userListResponseBody.getBody();
    }

    if (name != null) {
      return userList.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
    } else {
      return userList;
    }
  }

  public User getUserDetails(Integer id) {
    ResponseEntity<List<User>> userListResponseBody =
        restTemplate.exchange("https://gorest.co.in/public/v2/users", HttpMethod.GET, null,
            new ParameterizedTypeReference<List<User>>() {});

    List<User> userList = null;

    if (userListResponseBody.getStatusCode() == HttpStatus.OK) {
      userList = userListResponseBody.getBody();
    }

    Optional<User> user = userList.stream().filter(p -> p.getId().equals(id)).findAny();

    if (user.isPresent()) {
      return user.get();
    } else {
      throw new IllegalStateException("Could not find matching Id");
    }
  }

  public User addUser(User user) {
    User newUser =
        restTemplate.postForObject("https://gorest.co.in/public/v2/users", user, User.class);

    return newUser;
  }

}
