package com.project.billservice.service;

import com.project.commons.dto.BillDto;
import com.project.commons.dto.CustomerDto;
import com.project.commons.dto.RoomDto;
import com.project.billservice.domain.Bill;
import com.project.billservice.domain.Bill;
import com.project.billservice.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.project.billservice.repository.BillRepository;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class BillService {

    private final BillRepository billRepository;
   
    private final RestTemplate restTemplate;

    public List<BillDto> findAll() {
        log.debug("Request to get all Bills");
        return this.billRepository.findAll()
                .stream()
                .map(BillService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BillDto findById(Long id) {
        log.debug("Request to get Bill : {}", id);
        return this.billRepository
                .findById(id)
                .map(BillService::mapToDto)
                .orElse(null);
    }

    public BillDto create(BillDto billDto) {
        log.debug("Request to create Bill : {}", billDto);
     
        ResponseEntity<CustomerDto> customerResponseEntity
                = this.restTemplate.getForEntity(
                        "http://customer-service/api/customers/{id}",
                        CustomerDto.class,
                        billDto.getCustomerId()
                );
        ResponseEntity<RoomDto> roomResponseEntity
                = this.restTemplate.getForEntity(
                        "http://room-service/api/rooms/{id}",
                        RoomDto.class,
                        billDto.getRoomsId()
                );

        return mapToDto(
                this.billRepository.save(
                        new Bill(
                                customerResponseEntity.getBody().getId(),
                                roomResponseEntity.getBody().getId()
                        )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Bill : {}", id);
        this.billRepository.deleteById(id);
    }

    public static BillDto mapToDto(Bill bill) {
        if (bill != null) {
            return new BillDto(
                    bill.getId(),
                    bill.getCustomerId(),
                    bill.getRoomsId()
            );
        }
        return null;
    }

}
