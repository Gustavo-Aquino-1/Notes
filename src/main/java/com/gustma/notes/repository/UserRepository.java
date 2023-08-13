package com.gustma.notes.repository;

import com.gustma.notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
