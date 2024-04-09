package com.exercise.reposcanms.dto;

import com.exercise.reposcanms.model.Branch;
import com.exercise.reposcanms.model.Repo;
import com.exercise.reposcanms.model.Scan;
import com.exercise.reposcanms.model.Workspace;
import com.exercise.reposcanms.model.enums.ScanStatus;
import com.exercise.reposcanms.model.enums.ScanType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
public class ScanDetailDTO implements Serializable {
    private Long id;
    private Long workspaceId;
    private String workspaceName;
    private Long repoId;
    private String repoName;
    private Long branchId;
    private String branchName;
    private ScanType scanType;
    private ScanStatus scanStatus;
    private Integer scanIssues;
    private Boolean scanValid;
    private LocalDateTime submissionTime;

    public ScanDetailDTO(Long workspaceId, String workspaceName, Long repoId, String repoName, Long branchId,
                         String branchName, Long scanId, ScanType scanType, ScanStatus scanStatus,
                         Integer scanIssues, Boolean scanValid, LocalDateTime submissionTime) {
        this.workspaceId = workspaceId;
        this.workspaceName = workspaceName;
        this.repoId = repoId;
        this.repoName = repoName;
        this.branchId = branchId;
        this.branchName = branchName;
        this.id = scanId;
        this.scanType = scanType;
        this.scanStatus = scanStatus;
        this.scanIssues = scanIssues;
        this.scanValid = scanValid;
        this.submissionTime = submissionTime;
    }

    public ScanDetailDTO(Scan scan) {
        this.id = scan.getId();
        this.scanType = scan.getType();
        this.scanStatus = scan.getStatus();
        this.scanIssues = scan.getIssues();
        this.scanValid = scan.getValid();
        this.submissionTime = scan.getSubmissionTime();
        Branch branch = scan.getBranch();
        this.branchId = branch.getId();
        this.branchName = branch.getName();
        Repo repo = branch.getRepo();
        this.repoId = repo.getId();
        this.repoName = repo.getName();
        Workspace workspace = repo.getWorkspace();
        this.workspaceId = workspace.getId();
        this.workspaceName = workspace.getName();

    }

}
