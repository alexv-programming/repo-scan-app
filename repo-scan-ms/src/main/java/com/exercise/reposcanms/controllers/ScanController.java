package com.exercise.reposcanms.controllers;

import com.exercise.reposcanms.dto.ScanDetailDTO;
import com.exercise.reposcanms.dto.ScanRequest;
import com.exercise.reposcanms.services.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.exercise.reposcanms.constants.ApiConstants.API;
import static com.exercise.reposcanms.constants.ApiConstants.SCANS;

@RestController
@RequestMapping(API+SCANS)
public class ScanController {

    @Autowired
    private ScanService scanService;

    @GetMapping("/user/{userId}")
    public List<ScanDetailDTO> getAllScans(@PathVariable Long userId) {
        return scanService.getDetailsOnAllScansByUserId(userId);
    }

    @PostMapping
    public Long runScan(@RequestBody ScanRequest scanRequest) {//@Valid
        return scanService.initiateScan(scanRequest).getId();
    }
    
    
}
