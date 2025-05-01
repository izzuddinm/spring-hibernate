package com.izzuddinm.spring_hibernate.client.countries.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CountriesFallbackClient implements FallbackFactory<CountriesFeignClient> {
    @Override
    public CountriesFeignClient create(Throwable cause) {
        return new CountriesFeignClient() {
            @Override
            public ResponseEntity<String> findAllCountries() {
                return new ResponseEntity<>("Error From Client.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        };
    }
}
