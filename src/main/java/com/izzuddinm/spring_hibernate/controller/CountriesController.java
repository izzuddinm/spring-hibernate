package com.izzuddinm.spring_hibernate.controller;

import com.izzuddinm.spring_hibernate.service.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CountriesController {

    @Autowired
    private CountriesService countriesService;

    @GetMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findAllCountries() {
        return countriesService.findAllCountries();
    }
}
