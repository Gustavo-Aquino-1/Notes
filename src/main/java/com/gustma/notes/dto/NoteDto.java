package com.gustma.notes.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * class NoteDto.
 */
public class NoteDto {

  @NotNull
  @NotBlank
  @Size(min = 1, max = 150)
  private String title;
  
  @NotNull
  @NotBlank
  @Size(min = 1, max = 4000)
  private String description;
  
  @Size(min = 4, max = 4)
  private String pin;

  /**
   * constructor NoteDto using fields.
   */
  public NoteDto(@NotNull @NotBlank @Size(min = 1, max = 150) String title,
      @NotNull @NotBlank @Size(min = 1, max = 4000) String description, String pin) {
    this.title = title;
    this.description = description;
    this.pin = pin;
  }
  
  public NoteDto() {}

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
}
