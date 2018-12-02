
package com.project.billservice.web;

import com.project.billservice.service.BillService;
import com.project.commons.dto.BillDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.commons.utils.Web.API;

/**
 * @author n.lamouchi
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/bill")
public class BillResource {

    private final BillService itemService;

    @GetMapping
    public List<BillDto> findAll() {
        return this.itemService.findAll();
    }

    @GetMapping("/{id}")
    public BillDto findById(@PathVariable Long id) {
        return this.itemService.findById(id);
    }

    @PostMapping
    public BillDto create(@RequestBody BillDto billDto) {
        return this.itemService.create(billDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.itemService.delete(id);
    }

}
