package com.ucll.da.dentravak.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
public class Ingredient {
    private @Id @GeneratedValue Long id;
    private String name;
    private @ManyToMany(mappedBy = "ingredients") @JsonBackReference List<Sandwich> sandwiches;
}
