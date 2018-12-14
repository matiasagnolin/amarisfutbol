/**
 * $Id$
 * @author magnolin@scytl.net
 * @date   Dec 14, 2018 3:10:42 PM
 *
 * Copyright (C) 2018 Amaris
 *
 * All rights reserved.
 *
 */
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

import com.amaris.futbol.domain.Event;
import com.amaris.futbol.service.EventService;

/**
 *
 */
public class EventController {
    @Autowired
    private final EventService service;

    public EventController(final EventService service) {
        this.service = service;
    }

    @GetMapping(value = "/list")
    public Iterable<Event> list(final Model model) {
        return service.findAll();
    }

    @GetMapping(value = "/show/{id}")
    public Event showManager(@PathVariable final long id, final Model model) {
        return service.findById(id);

    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> saveConsultant(
        @RequestBody final Event event) {
        service.save(event);
        return new ResponseEntity<>("Manager saved successfully",
            HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateConsultant(
        @PathVariable final Long id, @RequestBody final Event event) {
        service.update(event);
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
