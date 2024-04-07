package com.exercise.reposcanms.services;

import com.exercise.reposcanms.dto.ScanDetailDTO;
import com.exercise.reposcanms.dto.ScanRequest;
import com.exercise.reposcanms.model.Scan;
import com.exercise.reposcanms.model.enums.ScanStatus;
import com.exercise.reposcanms.repositories.ScanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScanServiceImpl implements ScanService {

    @Autowired
    ScanRepo scanRepo;

    @Override
    public List<ScanDetailDTO> getDetailsOnAllScansByUserId(Long userId) {

        return scanRepo.findAllDataOnScanByUserId(userId);
    }

    @Override
    public Scan initiateScan(ScanRequest scanRequest) {




//        scanRepo.save();

        return null;
    }


}
