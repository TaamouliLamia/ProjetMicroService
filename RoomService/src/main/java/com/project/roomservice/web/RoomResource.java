package com.project.roomservice.web;

import com.project.commons.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.commons.utils.Web.API;
import com.project.roomservice.service.RoomService;

/**
 * @author n.lamouchi
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/rooms")
public class RoomResource {

    private final RoomService roomService;

    @GetMapping
    public List<RoomDto> findAll() {
        return this.roomService.findAll();
    }

    @GetMapping("/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return this.roomService.findById(id);
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto roomDto) {
        return this.roomService.create(roomDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.roomService.delete(id);
    }
}
