package dev.azizli.springissuemanagement.repository;

import dev.azizli.springissuemanagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aziz on 3/31/2021.
 * @project spring-issue-management
 */
public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {
}
