/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.billservice;

import com.project.commons.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final RestTemplate restTemplate;

    public DataLoader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... strings) throws Exception {
        ResponseEntity<CustomerDto> customerResponseEntity
                = this.restTemplate.getForEntity(
                        "http://customer-service/api/customers/{id}",
                        CustomerDto.class,
                        2
                );

        log.error("############  " + customerResponseEntity.getBody().toString() + "   ###############");
    }
}
