package com.exercise.reposcanms.dto;

import com.exercise.reposcanms.model.enums.ScanType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
@NoArgsConstructor
public class ScansSummaryDTO implements Serializable {
    private ScanType scanType;
    private Long scansCount;
    private Long issues;

    public ScansSummaryDTO(ScanType scanType, Long scansCount, Long issues) {
        this.scanType = scanType;
        this.scansCount = scansCount;
        this.issues = issues;
    }
}
