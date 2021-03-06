package com.ucll.da.dentravak.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sandwich {

    private @Id @GeneratedValue Long id;
    private String name;
    private BigDecimal price;
    private @ManyToMany List<Ingredient> ingredients;
    private @OneToMany(mappedBy = "sandwich") @JsonBackReference List<Order> orders;
}
