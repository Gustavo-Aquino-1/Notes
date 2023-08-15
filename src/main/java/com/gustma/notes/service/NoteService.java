package com.gustma.notes.service;

import com.gustma.notes.dto.NoteDto;
import com.gustma.notes.model.Note;
import com.gustma.notes.model.User;
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
  
  /**
   * create.
   */
  public Note create(Integer userId, NoteDto noteDto) {
    if (repoUser.existsById(userId)) {
      User user = repoUser.findById(userId).get();
      Note note = new Note(noteDto.getTitle(), noteDto.getDescription(),
          noteDto.getPin(), user);
      return repo.save(note);
    }
    return null;
  }
  
  /**
   * update.
   */
  public Note update(Integer id, NoteDto noteDto) {
    if (repo.existsById(id)) {
      Note note = repo.findById(id).get();
      note.setTitle(noteDto.getTitle());
      note.setDescription(noteDto.getDescription());
      note.setPin(noteDto.getPin());
      return repo.save(note);
    }
    return null;
  }
  
  /**
   * delete.
   */
  public boolean delete(Integer id) {
    if (repo.existsById(id)) {
      repo.deleteById(id);
      return true;
    }
    return false;
  }
}
