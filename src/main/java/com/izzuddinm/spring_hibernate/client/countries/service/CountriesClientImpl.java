package com.izzuddinm.spring_hibernate.client.countries.service;

import com.izzuddinm.spring_hibernate.client.countries.feign.CountriesFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CountriesClientImpl implements CountriesClient {

    @Autowired
    private CountriesFeignClient countriesFeignClient;

    @Override
    public ResponseEntity<String> findAllCountries() {
        return countriesFeignClient.findAllCountries();
    }
}
