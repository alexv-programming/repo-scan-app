package com.exercise.reposcanms.services;

import com.exercise.reposcanms.dto.ScanDetailDTO;
import com.exercise.reposcanms.dto.ScanRequest;
import com.exercise.reposcanms.dto.ScansSummaryDTO;
import com.exercise.reposcanms.model.Scan;

import java.util.List;

public interface ScanService {

    Scan initiateScan(ScanRequest scanRequest);

    List<ScanDetailDTO> getDetailsOnAllScansByUserId(Long userId);

    List<ScansSummaryDTO> getOverviewByUserId(Long userId);
}
