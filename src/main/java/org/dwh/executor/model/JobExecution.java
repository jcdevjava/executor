package org.dwh.executor.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "JOB_EXECUTION")
@Data
public class JobExecution {

    private @Id @GeneratedValue Long id;

    @Column(name = "PRGM_ID")
    private Long programId;

    @Column(name = "PRGM_EXEC_ID")
    private Long executionId;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Language language;

    private String data;

    private String parameters;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "ERROR_MSG")
    private String errorMessage;

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED,
        ERROR
    }

    public enum Type {
        SHELL_SCRIPT,
        COMMAND,
        SQL
    }

    public enum Language {
        DOS,
        BASH,
        CUBE,
        OLAP_CUBE,
        SQL
    }

}
