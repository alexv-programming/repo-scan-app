package com.exercise.reposcanms.services;

import com.exercise.reposcanms.dto.ScanDetailDTO;
import com.exercise.reposcanms.dto.ScanRequestDTO;
import com.exercise.reposcanms.dto.ScansSummaryDTO;
import com.exercise.reposcanms.model.Scan;

import javax.naming.NoPermissionException;
import java.util.List;

public interface ScanService {

    Scan initiateScan(ScanRequestDTO scanRequest) throws NoPermissionException;

    List<ScanDetailDTO> getDetailsOnAllScansByUserId(Long userId);

    List<ScansSummaryDTO> getOverviewByUserId(Long userId);
}
