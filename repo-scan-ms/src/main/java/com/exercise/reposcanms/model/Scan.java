package com.exercise.reposcanms.model;

import com.exercise.reposcanms.model.enums.ScanStatus;
import com.exercise.reposcanms.model.enums.ScanType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "scans")
public class Scan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer issues;
    private Boolean valid;

    @Enumerated(EnumType.STRING)
    private ScanType type;
    @Enumerated(EnumType.STRING)
    private ScanStatus status;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
    @CreatedDate
    private LocalDateTime submissionTime;
}

