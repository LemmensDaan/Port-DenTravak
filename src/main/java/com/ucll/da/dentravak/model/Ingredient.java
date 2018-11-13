package com.ucll.da.dentravak.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    private @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "fk_sandwich") Sandwich sandwich;
}
