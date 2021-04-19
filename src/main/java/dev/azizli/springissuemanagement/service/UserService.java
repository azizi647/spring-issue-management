package dev.azizli.springissuemanagement.service;

import dev.azizli.springissuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Aziz on 4/18/2021.
 * @project spring-issue-management
 */
public interface UserService {

    User save(User user);

    User getOne(Long id);

    Page<User> findAll(Pageable pageable);

    Boolean delete(User user);

    User getByUsername(String username);
}
