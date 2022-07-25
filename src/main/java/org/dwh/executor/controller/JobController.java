package org.dwh.executor.controller;

import org.dwh.executor.model.JobExecution;
import org.dwh.executor.response.MessageResponse;
import org.dwh.executor.service.JobExecutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController()
@RequestMapping("/api/jobs")
public class JobController {

    private final JobExecutionService service;

    public JobController(JobExecutionService service) {
        this.service = service;
    }

    @RequestMapping("/{executionId}")
    public ResponseEntity<?> findByExecutionId(@PathVariable Long executionId) {
        Optional<JobExecution> jobExecution = service.findByExecutionId(executionId);
        return jobExecution
            .<ResponseEntity<?>>map(ResponseEntity::ok)
            .orElseGet(() -> {
                var messageResponse = MessageResponse.error(String.format("Job execution '%d' not found.", executionId));
                return new ResponseEntity<>(messageResponse, HttpStatus.NOT_FOUND);
            });

    }

    @RequestMapping("/status/{executionId}")
    public ResponseEntity<MessageResponse> getJobExecutionStatus(@PathVariable Long executionId) {
        Optional<JobExecution> jobExecution = service.findByExecutionId(executionId);
        return jobExecution
            .map(job -> {
                var messageResponse = MessageResponse.ok(job.getStatus().name());
                return new ResponseEntity<>(messageResponse, HttpStatus.OK);
            })
            .orElseGet(() -> {
                var messageResponse = MessageResponse.error(String.format("Job execution '%d' not found.", executionId));
                return new ResponseEntity<>(messageResponse, HttpStatus.NOT_FOUND);
            });
    }
}
