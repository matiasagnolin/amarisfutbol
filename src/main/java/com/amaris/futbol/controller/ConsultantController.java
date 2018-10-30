package com.amaris.futbol.controller;

import com.amaris.futbol.Service.PlayerService;
import com.amaris.futbol.domain.Consultant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/consultant")
public class ConsultantController {


    private PlayerService service;

    @Autowired
    public ConsultantController(PlayerService service){
        this.service=service;
    }

    @GetMapping(value = "/list")
    public Iterable list(Model model){
        return service.findAll();
    }

    @GetMapping(value = "/show/{id}")
    public Consultant showConsultant(@PathVariable long id, Model model){
        return (Consultant) service.findById(id);

    }


    @PostMapping(value = "/add")
    public ResponseEntity saveConsultant(@RequestBody Consultant consultant){
        service.save(consultant);
        return new ResponseEntity("Consultant saved successfully", HttpStatus.OK);
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateConsultant(@PathVariable Long id, @RequestBody Consultant consultant){
        service.update(consultant);
        return new ResponseEntity("Consultant updated successfully", HttpStatus.OK);
    }


    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);

    }


}
