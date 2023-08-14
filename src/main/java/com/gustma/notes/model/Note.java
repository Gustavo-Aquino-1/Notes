package com.gustma.notes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * class Note.
 */
@Entity
public class Note {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(nullable = false, length = 150)
  private String title;
  
  @Column(nullable = false, length = 4000)
  private String description;
  
  @Column(nullable = true, length = 4)
  private String pin;
  
  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  /**
   * constructor Note using fields.
   */
  public Note(String title, String description, String pin, User user) {
    this.title = title;
    this.description = description;
    this.pin = pin;
    this.user = user;
  }
  
  public Note() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
