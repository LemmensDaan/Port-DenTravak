package com.ucll.da.dentravak.repository;

import java.math.BigDecimal;
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
    private SandwichRepository sandwichRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Sandwich sandwich = Sandwich.builder().name("Sandwich one").price(new BigDecimal(3)).build();
        Sandwich sandwich2 = Sandwich.builder().name("Sandwich two").price(new BigDecimal(3.3)).build();

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(Ingredient.builder().name("Ingredient one").build());
        ingredients.add(Ingredient.builder().name("Ingredient two").build());
        ingredients.add(Ingredient.builder().name("Ingredient three").build());

        ingredientRepository.saveAll(ingredients);

        sandwich.setIngredients(ingredients);
        sandwichRepository.save(sandwich);

        sandwich2.setIngredients(ingredients);
        sandwichRepository.save(sandwich2);
    }
}