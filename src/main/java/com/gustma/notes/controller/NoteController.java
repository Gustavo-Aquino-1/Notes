package com.gustma.notes.controller;

import com.gustma.notes.dto.NoteDto;
import com.gustma.notes.message.Message;
import com.gustma.notes.model.Note;
import com.gustma.notes.service.NoteService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  
  /**
   * create.
   */
  @PostMapping(value = "/{id}", consumes = json, produces = json)
  public ResponseEntity<?> create(@Valid @RequestBody NoteDto noteDto,
      @PathVariable("id") Integer id) {
    Note note = service.create(id, noteDto);
    if (note == null) {
      return ResponseEntity.status(404).body(new Message("user not found"));
    }
    return ResponseEntity.status(201).body(note);
  }
  
  /**
   * update.
   */
  @PutMapping(value = "/{id}", consumes = json, produces = json)
  public ResponseEntity<?> update(@Valid @RequestBody NoteDto noteDto, 
      @PathVariable("id") Integer id) {
    Note note = service.update(id, noteDto);
    if (note == null) {
      return ResponseEntity.status(404).body(new Message("note not found"));
    }
    return ResponseEntity.status(200).body(note);
  }
  
  /**
   * delete.
   */
  @DeleteMapping(value = "/{id}", produces = json)
  public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
    boolean result = service.delete(id);
    if (!result) {
      return ResponseEntity.status(404).body(new Message("note not found"));
    }
    return ResponseEntity.status(204).build();
  }
}
