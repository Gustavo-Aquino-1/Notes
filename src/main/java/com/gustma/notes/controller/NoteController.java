package com.gustma.notes.controller;

import com.gustma.notes.model.Note;
import com.gustma.notes.service.NoteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class NoteController.
 */
@RestController
@RequestMapping("/note")
public class NoteController {
  
  private final String json = "application/json";
  
  @Autowired
  private NoteService service;
  
  @GetMapping(value = "/{id}", produces = json)
  public List<Note> get(@PathVariable("id") Integer id) {
    return service.get(id);
  }
}
