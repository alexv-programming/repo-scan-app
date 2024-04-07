package com.exercise.reposcanms.dto;

import com.exercise.reposcanms.model.enums.ScanStatus;
import com.exercise.reposcanms.model.enums.ScanType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
public class ScanDetailDTO {
    private Long workspaceId;
    private String workspaceName;
    private Long repoId;
    private String repoName;
    private Long branchId;
    private String branchName;
    private Long scanId;
    private ScanType scanType;
    private ScanStatus scanStatus;
    private Integer scanIssues;
    private Boolean scanValid;

    public ScanDetailDTO(Long workspaceId, String workspaceName, Long repoId, String repoName, Long branchId, String branchName, Long scanId, ScanType scanType, ScanStatus scanStatus, Integer scanIssues, Boolean scanValid) {
        this.workspaceId = workspaceId;
        this.workspaceName = workspaceName;
        this.repoId = repoId;
        this.repoName = repoName;
        this.branchId = branchId;
        this.branchName = branchName;
        this.scanId = scanId;
        this.scanType = scanType;
        this.scanStatus = scanStatus;
        this.scanIssues = scanIssues;
        this.scanValid = scanValid;
    }

}
