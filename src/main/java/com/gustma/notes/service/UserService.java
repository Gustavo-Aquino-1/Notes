package com.gustma.notes.service;

import com.gustma.notes.dto.UserDto;
import com.gustma.notes.model.User;
import com.gustma.notes.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * class UserService.
 */
@Service
public class UserService {

  @Autowired
  private UserRepository repo;
  
  public User create(UserDto userDto) {
    User user = new User(userDto.getEmail(), DigestUtils.md5Hex(userDto.getPassword()));
    return repo.save(user);
  }
  
  /**
   * login.
   */
  public User login(UserDto userDto) {
    User user = repo.findByEmail(userDto.getEmail());
    if (user == null) { 
      return null;
    }
    if (!user.getPassword().equals(DigestUtils.md5Hex(userDto.getPassword()))) {
      return null;
    }
    User findUser = new User();
    findUser.setId(user.getId());
    findUser.setEmail(user.getEmail());
    return findUser;
  }
}
