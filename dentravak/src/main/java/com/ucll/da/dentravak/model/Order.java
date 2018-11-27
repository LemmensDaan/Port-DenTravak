package com.ucll.da.dentravak.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`order`")
public class Order {
    private @Id @GeneratedValue Long id;
    private BreadType breadType;
    private String name;
    private BigDecimal price;
    private String mobilePhoneNumber;
    @Default
    private LocalDateTime creationDate = LocalDateTime.now();
    private @ManyToOne Sandwich sandwich;
}
