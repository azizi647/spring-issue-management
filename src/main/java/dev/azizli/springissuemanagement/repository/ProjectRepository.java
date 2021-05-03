package dev.azizli.springissuemanagement.repository;

import dev.azizli.springissuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Aziz on 3/31/2021.
 * @project spring-issue-management
 */

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project getAllByProjectCode(String projectCode);

    List<Project> getAllByProjectCodeAndIdNotNull(String projectCode);

    Page<Project> findAll(Pageable pageable);
}
