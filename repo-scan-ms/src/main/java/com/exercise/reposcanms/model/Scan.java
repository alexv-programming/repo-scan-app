package com.exercise.reposcanms.model;

import com.exercise.reposcanms.model.enums.ScanStatus;
import com.exercise.reposcanms.model.enums.ScanType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "scans")
public class Scan {
    @Id
    @GeneratedValue
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

