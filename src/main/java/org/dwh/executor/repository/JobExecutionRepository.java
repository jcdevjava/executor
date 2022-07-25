package org.dwh.executor.repository;

import org.dwh.executor.model.JobExecution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobExecutionRepository extends JpaRepository<JobExecution, Long> {

    Optional<JobExecution> findByExecutionId(Long executionId);

}
