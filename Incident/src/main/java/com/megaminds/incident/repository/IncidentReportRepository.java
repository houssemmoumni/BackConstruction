package com.megaminds.incident.repository;

import com.megaminds.incident.entity.IncidentReport;
import com.megaminds.incident.entity.IncidentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IncidentReportRepository extends JpaRepository<IncidentReport, Long> {
    List<IncidentReport> findByProjectId(Long projectId);
    List<IncidentReport> findByStatus(IncidentStatus status);
    List<IncidentReport> findByStatusNot(IncidentStatus status);
    List<IncidentReport> findByAssignedToId(Long technicianId);

    // Add the delete method for deleting IncidentReports by projectId
    void deleteByProjectId(Long projectId);  // This will delete all incident reports linked to a project
}
