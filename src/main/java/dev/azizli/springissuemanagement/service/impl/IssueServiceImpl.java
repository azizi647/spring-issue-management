package dev.azizli.springissuemanagement.service.impl;

import dev.azizli.springissuemanagement.dto.IssueDto;
import dev.azizli.springissuemanagement.entity.Issue;
import dev.azizli.springissuemanagement.repository.IssueRepository;
import dev.azizli.springissuemanagement.service.IssueService;
import dev.azizli.springissuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author Aziz on 4/18/2021.
 * @project spring-issue-management
 */
@Service
public class IssueServiceImpl implements IssueService {

    /*
        bir objectin propertysine 'final' etiketi verdiyimiz zaman
        o objectin (propertinin) runtimeda deyishmesini onlemish oluruq
    */
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate() == null)
            throw new IllegalArgumentException("Issue Date cannot be null!!");

        // objectin hansi class tipinde objecte dondurulmesini qeyd edirik
        Issue issueEntity = modelMapper.map(issue, Issue.class);

        issueEntity = issueRepository.save(issueEntity);
        issue.setId(issueEntity.getId());
        return modelMapper.map(issueEntity, IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {

        Page<Issue> data = issueRepository.findAll(pageable);
        TPage<IssueDto> tPage = new TPage<IssueDto>();
        IssueDto[] issueDtos = modelMapper.map(data.getContent(), IssueDto[].class);
        tPage.setStat(data, Arrays.asList(issueDtos));

        return tPage;
    }

    @Override
    public Boolean delete(IssueDto user) {
        return null;
    }

}
