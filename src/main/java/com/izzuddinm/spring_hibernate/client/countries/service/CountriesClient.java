package com.izzuddinm.spring_hibernate.client.countries.service;

import org.springframework.http.ResponseEntity;

public interface CountriesClient {

    public ResponseEntity<String> findAllCountries();
}
