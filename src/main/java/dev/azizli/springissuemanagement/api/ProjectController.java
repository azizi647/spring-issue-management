package dev.azizli.springissuemanagement.api;

import dev.azizli.springissuemanagement.dto.ProjectDto;
import dev.azizli.springissuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aziz on 4/20/2021.
 * @project spring-issue-management
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl){
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getById(){
        List<ProjectDto> projectDtos = projectServiceImpl.getAll();
        return ResponseEntity.ok(projectDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectServiceImpl.save(projectDto));
    }
}
