package com.gustma.notes.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * class UserDto.
 */
public class UserDto {

  @NotNull
  @NotBlank
  @Email
  private String email;
  
  @NotNull
  @NotBlank
  @Size(min = 8)
  private String password;

  public UserDto(@NotNull @NotBlank @Email String email,
      @NotNull @NotBlank @Size(min = 8) String password) {
    this.email = email;
    this.password = password;
  }
  
  public UserDto() {}

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }  
}
