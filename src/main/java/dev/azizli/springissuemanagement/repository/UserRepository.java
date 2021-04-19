package dev.azizli.springissuemanagement.repository;

import dev.azizli.springissuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Aziz on 3/31/2021.
 * @project spring-issue-management
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
