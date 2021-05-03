package dev.azizli.springissuemanagement.service;

import dev.azizli.springissuemanagement.dto.ProjectDto;
import dev.azizli.springissuemanagement.entity.Project;
import dev.azizli.springissuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Aziz on 4/18/2021.
 * @project spring-issue-management
 */
public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    List<ProjectDto> getAll();

    TPage<ProjectDto> findAll(Pageable pageable);

    ProjectDto getByProjectCode(String projectCode);

    List<ProjectDto> getByProjectCodeContains(String projectCode);

    Boolean delete(ProjectDto project);
}
