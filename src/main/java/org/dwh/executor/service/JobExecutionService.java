package org.dwh.executor.service;

import org.dwh.executor.model.JobExecution;
import org.dwh.executor.repository.JobExecutionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobExecutionService {

    private final JobExecutionRepository repository;

    public JobExecutionService(JobExecutionRepository repository) {
        this.repository = repository;
    }

    public Optional<JobExecution> findByExecutionId(Long executionId) {
        return repository.findByExecutionId(executionId);
    }

}
