package com.ucll.da.dentravak.repository;

import java.util.ArrayList;
import java.util.List;

import com.ucll.da.dentravak.model.Ingredient;
import com.ucll.da.dentravak.model.Sandwich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
class LoadDatabase implements ApplicationRunner {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private SandwichRepository sandwichRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(Ingredient.builder().name("Ingredient one").build());

        ingredients = ingredientRepository.saveAll(ingredients);

        sandwichRepository.save(Sandwich.builder().name("Name").ingredients(ingredients).price(3.0).build());
        sandwichRepository.save(Sandwich.builder().name("Name2").ingredients(ingredients).price(3.2).build());
    }
}