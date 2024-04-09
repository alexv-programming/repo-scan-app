package com.exercise.reposcanms.delegate;

import com.exercise.reposcanms.model.Scan;
import com.exercise.reposcanms.model.enums.ScanStatus;
import com.exercise.reposcanms.repositories.ScanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DelegateScanMockService {


    ScanRepo scanRepo;
    @Autowired
    public DelegateScanMockService(ScanRepo scanRepo) {
        this.scanRepo = scanRepo;
    }

    @Async
    public void mockRunScan(Scan scan) {
        Random random = new Random();
        int issues = random.nextInt(10);

        long sleepTime = switch (scan.getType()) {
            case SCA -> 12000; // 2 minutes
            case SAST -> 6000; // 1 minute
            case RENOVATE -> 3000; // 30 seconds
        };

        // Simulate scan time
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Set final scan status and issues
        scan.setStatus(ScanStatus.COMPLETED);
        scan.setIssues(issues);
        scan.setValid(issues == 0);
        scanRepo.save(scan);
    }
}
