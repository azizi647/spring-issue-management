package dev.azizli.springissuemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Aziz on 4/18/2021.
 * @project spring-issue-management
 */
@Data

@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    private Long id;
    @NotNull
    private String projectName;
    @NotNull
    private String projectCode;

}
