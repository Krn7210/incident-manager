package com.example.inicident_management.dto;

import com.example.inicident_management.utility.Priority;
import com.example.inicident_management.utility.Status;
import lombok.Data;
import lombok.Getter;


import java.time.LocalDateTime;
@Data
public class IncidentDto {

    private String incidentId;


    private String reporterName;

    private String enterpriseName;


    private String details;


    private LocalDateTime reportedDateTime;


    private Priority priority;


    private Status status;

    public IncidentDto() {
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getReportedDateTime() {
        return reportedDateTime;
    }

    public void setReportedDateTime(LocalDateTime reportedDateTime) {
        this.reportedDateTime = reportedDateTime;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public IncidentDto(String incidentId, String reporterName, String enterpriseName, String details, LocalDateTime reportedDateTime, Priority priority, Status status) {
        this.incidentId = incidentId;
        this.reporterName = reporterName;
        this.enterpriseName = enterpriseName;
        this.details = details;
        this.reportedDateTime = reportedDateTime;
        this.priority = priority;
        this.status = status;
    }
}
