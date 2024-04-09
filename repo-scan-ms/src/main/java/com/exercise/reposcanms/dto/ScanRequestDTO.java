package com.exercise.reposcanms.dto;

import com.exercise.reposcanms.model.enums.ScanType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Data
public class ScanRequestDTO implements Serializable {
    private Long userId;
    private Long branchId;
    private ScanType scanType;

    public ScanRequestDTO(Long userId, Long branchId, ScanType scanType) {
        this.userId = userId;
        this.branchId = branchId;
        this.scanType = scanType;
    }
}
