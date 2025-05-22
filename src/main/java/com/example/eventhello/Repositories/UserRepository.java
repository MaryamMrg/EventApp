package com.example.eventhello.Repositories;

import com.example.eventhello.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
