package com.gustma.notes.service;

import com.gustma.notes.model.Note;
import com.gustma.notes.repository.NoteRepository;
import com.gustma.notes.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * NoteService.
 */
@Service
public class NoteService {
  
  @Autowired
  private NoteRepository repo;
  
  @Autowired
  private UserRepository repoUser;
  
  /**
   * get.
   */
  public List<Note> get(Integer userId) {
    if (repoUser.existsById(userId)) {
      return repoUser.findById(userId).get().getNotes();
    }
    return new ArrayList<>();
  }
  
}
