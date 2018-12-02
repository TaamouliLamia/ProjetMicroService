package com.project.roomservice.service;

import com.project.commons.dto.ProductDto;
import com.project.roomservice.domain.Room;
import com.project.roomservice.domain.enumeration.RoomStatus;
import com.project.roomservice.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class RoomService {

    private final RoomRepository roomRepository;

    public List<RoomDto> findAll() {
        log.debug("Request to get all rooms");
        return this.roomRepository.findAll()
                .stream()
                .map(RoomService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RoomDto findById(Long id) {
        log.debug("Request to get Room : {}", id);
        return this.roomRepository.findById(id).map(RoomService::mapToDto).orElse(null);
    }

    public RoomDto create(RoomDto roomDto) {
        log.debug("Request to create Room : {}", roomDto);

        return mapToDto(this.roomRepository.save(
                new Room(
                        productDto.getPrice(),
                        RoomStatus.valueOf(roomDto.getStatus()),
                )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Room : {}", id);
        this.roomRepository.deleteById(id);
    }

    public static RoomDto mapToDto(Room room) {
        if (room != null) {
            return new RoomDto(
                    room.getId(),
                    room.getPrice(),
                    room.getStatus().name(),
            );
        }
        return null;
    }
}
