package com.exercise.reposcanms.services;

import com.exercise.reposcanms.delegate.DelegateScanMockService;
import com.exercise.reposcanms.dto.ScanDetailDTO;
import com.exercise.reposcanms.dto.ScanRequestDTO;
import com.exercise.reposcanms.dto.ScansSummaryDTO;
import com.exercise.reposcanms.exceptions.BranchNotFoundException;
import com.exercise.reposcanms.model.Scan;
import com.exercise.reposcanms.model.Branch;
import com.exercise.reposcanms.model.enums.ScanStatus;
import com.exercise.reposcanms.repositories.BranchRepo;
import com.exercise.reposcanms.repositories.ScanRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NoPermissionException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ScanServiceImpl implements ScanService {

    ScanRepo scanRepo;
    DelegateScanMockService delegateScanService;
    BranchRepo branchRepo;

    @Autowired
    public ScanServiceImpl(ScanRepo scanRepo, DelegateScanMockService delegateScanService, BranchRepo branchRepo) {
        this.scanRepo = scanRepo;
        this.delegateScanService = delegateScanService;
        this.branchRepo = branchRepo;
    }

    @Override
    public List<ScanDetailDTO> getDetailsOnAllScansByUserId(Long userId) {

        return scanRepo.findAllDataOnScanByUserId(userId);
    }

    @Override
    public List<ScansSummaryDTO> getOverviewByUserId(Long userId) {

        return scanRepo.getOverviewByUserId(userId);
    }

    @Override
    public ScanDetailDTO initiateScan(ScanRequestDTO scanRequestDTO) throws NoPermissionException {

        Branch branch = branchRepo
                .findById(scanRequestDTO.getBranchId())
                .orElseThrow(() -> new BranchNotFoundException("Branch not found"));
        if (!branch.getRepo().getWorkspace().getUser().getId().equals(scanRequestDTO.getUserId())) {
            throw new NoPermissionException("user does not have access to this branch");
        }

        Scan newScan = new Scan();
        newScan.setBranch(branch);
        newScan.setType(scanRequestDTO.getScanType());
        newScan.setStatus(ScanStatus.PENDING);
        newScan.setSubmissionTime(LocalDateTime.now());

        delegateScanService.mockRunScan(newScan);

        return new ScanDetailDTO(scanRepo.save(newScan));
    }



}
