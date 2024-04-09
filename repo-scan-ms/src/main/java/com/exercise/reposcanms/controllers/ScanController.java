package com.exercise.reposcanms.controllers;

import com.exercise.reposcanms.dto.ScanDetailDTO;
import com.exercise.reposcanms.dto.ScanRequestDTO;
import com.exercise.reposcanms.dto.ScansSummaryDTO;
import com.exercise.reposcanms.services.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.NoPermissionException;
import java.util.List;

import static com.exercise.reposcanms.constants.ApiConstants.API;
import static com.exercise.reposcanms.constants.ApiConstants.SCANS;

@RestController
@RequestMapping(API+SCANS)
public class ScanController {

    private ScanService scanService;

    @Autowired
    public ScanController(ScanService scanService) {
        this.scanService = scanService;
    }

    @GetMapping("/user/{userId}")
    public List<ScanDetailDTO> getAllScans(@PathVariable Long userId) {
        return scanService.getDetailsOnAllScansByUserId(userId);
    }

    @GetMapping("/user/{userId}/overview")
    public List<ScansSummaryDTO> getOverviewByUserId(@PathVariable Long userId) {
        return scanService.getOverviewByUserId(userId);
    }

    @PostMapping
    public ScanDetailDTO runScan(@RequestBody ScanRequestDTO scanRequest) throws NoPermissionException {//@Valid
        return scanService.initiateScan(scanRequest);
    }
    
    
}
