package com.project.billservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.commons.domain.AbstractEntity;
import com.project.billservice.domain.enumeration.BillStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * A Bill.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "bills")
public class Bill extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "total_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal totalPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BillStatus status;

    private Long customerId;
    
    private Set<Long> roomsId;

    public Bill() {
        // Empty Constructor for JPA
    }

    public Bill(BigDecimal totalPrice, BillStatus status,
            Long customerId, Set<Long> roomsId) {
        this.totalPrice = totalPrice;
        this.status = status;
        this.customerId = customerId;
        this.roomsId = roomsId;
    }

}
