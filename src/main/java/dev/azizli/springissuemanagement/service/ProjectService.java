package dev.azizli.springissuemanagement.service;

import dev.azizli.springissuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Aziz on 4/18/2021.
 * @project spring-issue-management
 */
public interface ProjectService {

    Project save(Project project);

    Project getOne(Long id);

    Page<Project> findAll(Pageable pageable);

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Boolean delete(Project project);
}
