package dev.azizli.springissuemanagement.service.impl;

import dev.azizli.springissuemanagement.dto.ProjectDto;
import dev.azizli.springissuemanagement.entity.Project;
import dev.azizli.springissuemanagement.repository.ProjectRepository;
import dev.azizli.springissuemanagement.service.ProjectService;
import dev.azizli.springissuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Aziz on 4/18/2021.
 * @project spring-issue-management
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getAllByProjectCode(project.getProjectCode());
        if (projectCheck !=null)
            throw new IllegalArgumentException("Project Code Already Exist");

        Project projectEntity = modelMapper.map(project, Project.class);

        projectEntity = projectRepository.save(projectEntity);
        project.setId(projectEntity.getId());
        return modelMapper.map(projectEntity, ProjectDto.class);
    }

    @Override
    public ProjectDto getById(Long id) {
        Project project = projectRepository.getOne(id);
        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public List<ProjectDto> getAll() {
        List<Project> projects = projectRepository.findAll();
        return Arrays.asList(modelMapper.map(projects, ProjectDto[].class));
    }

    @Override
    public TPage<ProjectDto> findAll(Pageable pageable) {
        Page<Project> projects = projectRepository.findAll(pageable);
        TPage<ProjectDto> projectDtoTPage = new TPage<>();
        ProjectDto[] projectDtos = modelMapper.map(projects.getContent(), ProjectDto[].class);
        projectDtoTPage.setStat(projects, Arrays.asList(projectDtos));
        return projectDtoTPage;
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Boolean delete(ProjectDto project) {
//        projectRepository.delete(project);
        return Boolean.TRUE;
    }
}
