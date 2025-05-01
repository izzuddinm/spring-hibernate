package com.izzuddinm.spring_hibernate.service;

import org.springframework.http.ResponseEntity;

public interface CountriesService {

    public ResponseEntity<String> findAllCountries();
}
