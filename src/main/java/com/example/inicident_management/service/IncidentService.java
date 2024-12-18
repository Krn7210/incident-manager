package com.example.inicident_management.service;

import com.example.inicident_management.dto.IncidentDto;
import com.example.inicident_management.entity.Incident;
import com.example.inicident_management.entity.User;
import com.example.inicident_management.exception.IncidentException;
import com.example.inicident_management.exception.UserException;
import com.example.inicident_management.mapper.IncidentMapper;
import com.example.inicident_management.repository.IncidentRepository;
import com.example.inicident_management.repository.UserRepository;
import com.example.inicident_management.utility.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentService {
    @Autowired
    IncidentRepository incidentRepository;
    @Autowired
    UserRepository userRepository;

    public void saveIncident(IncidentDto dto,String userName) {
      User user = userRepository.findByUsername(userName).orElseThrow(
                    ()-> new UserException("unable to find user")
            );
            Incident incident = IncidentMapper.dtoToIncident(dto);

            incident.setUser(user);
            incident.setReporterName(user.getUsername());
            incidentRepository.save(incident);
    }

    public List<IncidentDto> getIncidents(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new UserException("User not found with username: "+username);
        }
        List<IncidentDto> incidentDtos = new ArrayList<>();
        user.get().getIncidents().forEach(i->
               incidentDtos.add(IncidentMapper.IncidentToDto(i))
                );
        return incidentDtos;

    }

    public void updateIncident(IncidentDto dto, String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new UserException("User not found with username: "+username);
        }
        Optional<Incident> incident = user.get().getIncidents().stream().filter(i-> i.getIncidentId().equals(dto.getIncidentId())).findFirst();
        if(incident.isEmpty()){
            throw new IncidentException("No Incident is present for number: " +dto.getIncidentId());
        }
        if(!incident.get().getStatus().equals(Status.OPEN)){
           throw new IncidentException("Incident is not open cannot update the incident: "+dto.getIncidentId());
        }
        Incident updadteIncident = incident.get();
        updadteIncident.setDetails(dto.getDetails());
        updadteIncident.setEnterpriseName(dto.getEnterpriseName());
        updadteIncident.setPriority(dto.getPriority());
        incidentRepository.save(updadteIncident);
}
}
