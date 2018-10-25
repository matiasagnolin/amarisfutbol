package com.amaris.futbol.controller;

import com.amaris.futbol.Service.ConsultantService;
import com.amaris.futbol.domain.Consultant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultantController {

    @Autowired
    ConsultantService service;

    @GetMapping("/consultants")
    public List<Consultant> retrieveAllConsultants() {
        return service.findAll();
    }

}
