/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.commons.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author n.lamouchi
 */
@AllArgsConstructor
@Data
public class BillDto {
    private Long id;
    private Long customerId;
    private Set<Long> rommsId;
}
