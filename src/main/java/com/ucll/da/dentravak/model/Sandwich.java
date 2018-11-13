package com.ucll.da.dentravak.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    private @OneToMany(mappedBy = "sandwich") List<Ingredient> ingredients;
    private double price;
}
