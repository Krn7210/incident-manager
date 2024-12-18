package com.example.inicident_management.controller;

import com.example.inicident_management.dto.IncidentDto;
import com.example.inicident_management.dto.ResponseDto;
import com.example.inicident_management.repository.IncidentRepository;
import com.example.inicident_management.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incident")
public class IncidentController {
    @Autowired
    IncidentService incidentservice;

    @PostMapping("{username}")
    public ResponseEntity<ResponseDto> saveIncident(@RequestBody IncidentDto dto, @PathVariable String username){
             incidentservice.saveIncident(dto,username);
        return   ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("201","Incident Created"));


    }
    @GetMapping("{username}")
    public ResponseEntity<List<IncidentDto>> getIncident(@PathVariable String username){
        List<IncidentDto> incidentDtos = incidentservice.getIncidents(username);
        return   ResponseEntity.status(HttpStatus.CREATED).body(incidentDtos);


    }

    @PutMapping("{username}")
    public ResponseEntity<ResponseDto> updateIncident(@RequestBody IncidentDto dto,@PathVariable String username){
        incidentservice.updateIncident(dto,username);
        return   ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.toString(),"Incident Updated Successfully"));


    }

}
