package Luca.Utzeri.capstone.Project.repositories;

import Luca.Utzeri.capstone.Project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserDAO extends JpaRepository<User, UUID>{
    Optional<User> findByEmail(String email);
}
