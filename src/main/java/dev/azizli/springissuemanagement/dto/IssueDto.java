package dev.azizli.springissuemanagement.dto;

import dev.azizli.springissuemanagement.entity.IssueStatus;
import lombok.Data;

import java.util.Date;

/**
 * @author Aziz on 4/18/2021.
 * @project spring-issue-management
 */

@Data
public class IssueDto {

    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDto assignee;
    private ProjectDto project;
}
