package com.exercise.reposcanms.repositories;

import com.exercise.reposcanms.dto.ScanDetailDTO;
import com.exercise.reposcanms.dto.ScansSummaryDTO;
import com.exercise.reposcanms.model.Scan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScanRepo extends CrudRepository<Scan, Long> {

    @Query("SELECT new com.exercise.reposcanms.dto.ScanDetailDTO(" +
            "w.id, w.name, r.id, r.name, b.id, b.name, s.id, s.type, s.status, s.issues, s.valid) " +
            "FROM User u " +
            "JOIN u.workspaces w " +
            "JOIN w.repos r " +
            "JOIN r.branches b " +
            "JOIN b.scans s " +
            "WHERE u.id = :userId")
    List<ScanDetailDTO> findAllDataOnScanByUserId(Long userId);

    @Query("SELECT new com.exercise.reposcanms.dto.ScansSummaryDTO(s.type, COUNT(s), SUM(s.issues)) " +
            "FROM Scan s JOIN s.branch b JOIN b.repo r JOIN r.workspace w JOIN w.user u " +
            "WHERE u.id = :userId " +
            "GROUP BY s.type")
    List<ScansSummaryDTO> getOverviewByUserId(Long userId);
}
