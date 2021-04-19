package dev.azizli.springissuemanagement.service.impl;

import dev.azizli.springissuemanagement.entity.Project;
import dev.azizli.springissuemanagement.repository.ProjectRepository;
import dev.azizli.springissuemanagement.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aziz on 4/18/2021.
 * @project spring-issue-management
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {

        if(project.getProjectCode()==null)
            throw new IllegalArgumentException("Project code cannot be null");

        return projectRepository.save(project);
    }

    @Override
    public Project getOne(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public Page<Project> findAll(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return projectRepository.getAllByProjectCode(projectCode);
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);
        return Boolean.TRUE;
    }
}
