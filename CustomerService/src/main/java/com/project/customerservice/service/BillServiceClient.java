package com.project.customerservice.service;

import com.project.commons.dto.CustomerDto;
import com.project.commons.dto.BillDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@FeignClient(name = "bill-service")
public interface BillServiceClient {

    @RequestMapping(value = "/api/bills", method = POST)
    BillDto create(CustomerDto customerDto);

}
