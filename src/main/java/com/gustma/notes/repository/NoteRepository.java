package com.gustma.notes.repository;

import com.gustma.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * interface NoteRepository.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
}
