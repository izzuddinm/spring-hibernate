package com.izzuddinm.spring_hibernate.client.countries.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "countries-api", url = "${feign.client.countries.baseUrl}"
//        fallbackFactory = CountriesFallbackClient.class
)
public interface CountriesFeignClient {

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findAllCountries();
}
