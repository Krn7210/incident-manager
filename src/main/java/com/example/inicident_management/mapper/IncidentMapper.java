package com.example.inicident_management.mapper;

import com.example.inicident_management.dto.IncidentDto;
import com.example.inicident_management.entity.Incident;
import com.example.inicident_management.utility.Utillity;

import java.time.LocalDateTime;

public class IncidentMapper {

    public static IncidentDto IncidentToDto(Incident incident){
        IncidentDto dto = new IncidentDto();
        dto.setIncidentId(incident.getIncidentId());
        dto.setDetails(incident.getDetails());
        dto.setEnterpriseName(incident.getEnterpriseName());
        dto.setReportedDateTime(incident.getReportedDateTime());
        dto.setPriority(incident.getPriority());
        dto.setStatus(incident.getStatus());
        dto.setReporterName(incident.getReporterName());
        return dto;
    }
    public static Incident dtoToIncident(IncidentDto dto){
        Incident incident = new Incident();
        incident.setDetails(dto.getDetails());
        incident.setIncidentId(Utillity.generateIncidentNumber());
        incident.setEnterpriseName(dto.getEnterpriseName());
        incident.setReportedDateTime(LocalDateTime.now());
        incident.setPriority(dto.getPriority());
        incident.setStatus(dto.getStatus());
        return incident;

    }
}
