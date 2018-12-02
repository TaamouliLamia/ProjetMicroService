/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.commons.dto;

import java.math.BigDecimal;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author n.lamouchi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    private Long id;
    private BigDecimal price;
    private String status;
    
}
