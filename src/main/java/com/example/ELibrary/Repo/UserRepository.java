

package com.example.ELibrary.Repo;


import com.example.ELibrary.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameOrEmail(String usernameOrEmail, String orEmail);
    User findByUsername(String username);
    User findByEmail(String email);
}