package com.gustma.notes.controller;

import com.gustma.notes.dto.UserDto;
import com.gustma.notes.model.User;
import com.gustma.notes.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class UserController.
 */
@RestController
@RequestMapping("/user")
public class UserController {
  private final String json = "application/json";
  
  @Autowired
  private UserService service;
  
  @PostMapping(consumes = json, produces = json)
  public ResponseEntity<User> create(@Valid @RequestBody UserDto userDto) {
    return ResponseEntity.status(201).body(service.create(userDto));
  }
  
  
  /**
   * login.
   */
  @PostMapping(value = "/login", consumes = json, produces = json)
  public ResponseEntity<User> login(@Valid @RequestBody UserDto userDto) {
    User user = service.login(userDto);
    if (user == null) {
      return ResponseEntity.status(404).build();
    }
    return ResponseEntity.status(200).body(user);
  }
}
