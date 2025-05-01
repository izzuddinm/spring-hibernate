package com.izzuddinm.spring_hibernate.service;

import com.izzuddinm.spring_hibernate.client.countries.feign.CountriesFeignClient;
import com.izzuddinm.spring_hibernate.client.countries.service.CountriesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CountriesServiceImpl implements CountriesService {

    @Autowired
    private CountriesClient countriesClient;

    @Override
    public ResponseEntity<String> findAllCountries() {
        return countriesClient.findAllCountries();
    }
}
