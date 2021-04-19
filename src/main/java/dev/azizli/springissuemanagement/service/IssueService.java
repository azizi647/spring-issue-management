package dev.azizli.springissuemanagement.service;

import dev.azizli.springissuemanagement.dto.IssueDto;
import dev.azizli.springissuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

/**
 * @author Aziz on 4/18/2021.
 * @project spring-issue-management
 */
public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto user);
}
