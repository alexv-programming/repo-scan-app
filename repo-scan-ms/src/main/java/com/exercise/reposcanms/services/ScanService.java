package com.exercise.reposcanms.services;

import com.exercise.reposcanms.dto.ScanDetailDTO;
import com.exercise.reposcanms.dto.ScanRequest;
import com.exercise.reposcanms.model.Scan;

import java.util.List;

public interface ScanService {

    Scan initiateScan(ScanRequest scanRequest);

    List<ScanDetailDTO> getDetailsOnAllScansByUserId(Long userId);
}
