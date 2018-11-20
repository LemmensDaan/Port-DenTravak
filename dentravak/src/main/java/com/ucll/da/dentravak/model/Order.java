package com.ucll.da.dentravak.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="`order`")
public class Order {
    private @Id @GeneratedValue Long id;
    private BreadType breadType;
    private String name;
    private BigDecimal price;
    private String mobilePhoneNumber;
    private LocalDateTime creationDate;
}
