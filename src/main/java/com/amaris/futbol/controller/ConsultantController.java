package com.amaris.futbol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amaris.futbol.domain.Consultant;
import com.amaris.futbol.domain.Player;
import com.amaris.futbol.service.PlayerService;

@RestController
@RequestMapping(value = "/consultant")
public class ConsultantController {

    private final PlayerService service;

    @Autowired
    public ConsultantController(final PlayerService service) {
        this.service = service;
    }

    @GetMapping(value = "/list")
    public Iterable<Player> list(final Model model) {
        return service.findAll();
    }

    @GetMapping(value = "/show/{id}")
    public Consultant showConsultant(@PathVariable final long id,
            final Model model) {
        return (Consultant) service.findById(id);

    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> saveConsultant(
            @RequestBody final Consultant consultant) {
        service.save(consultant);
        return new ResponseEntity<>("Consultant saved successfully",
            HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateConsultant(
            @PathVariable final Long id,
            @RequestBody final Consultant consultant) {
        service.update(consultant);
        return new ResponseEntity<>("Consultant updated successfully",
            HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable final Integer id) {
        service.deleteById(id);
        return new ResponseEntity<>("Product deleted successfully",
            HttpStatus.OK);

    }

}
