/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author n.lamouchi
 */
@Data
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
}
