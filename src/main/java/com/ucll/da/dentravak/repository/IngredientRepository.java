package com.ucll.da.dentravak.repository;

import com.ucll.da.dentravak.model.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}