package com.ucll.da.dentravak.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ucll.da.dentravak.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
class LoadDatabase implements ApplicationRunner {

    @Autowired
    private SandwichRepository sandwichRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Sandwich gezond = Sandwich.builder().name("Gezond").price(new BigDecimal(4.00)).build();
        Sandwich smoske = Sandwich.builder().name("Smoske").price(new BigDecimal(3.50)).build();
        Sandwich brie_ = Sandwich.builder().name("Brie").price(new BigDecimal(3.50)).build();

        List<Ingredient> kaasEnHesp = new ArrayList<>();
        List<Ingredient> groentjes = new ArrayList<>();
        List<Ingredient> brie = new ArrayList<>();
        groentjes.add(Ingredient.builder().name("Groentjes").build());
        kaasEnHesp.add(Ingredient.builder().name("Kaas").build());
        kaasEnHesp.add(Ingredient.builder().name("Hesp").build());
        brie.add(Ingredient.builder().name("Brie").build());
        brie.add(Ingredient.builder().name("Walnoten").build());
        brie.add(Ingredient.builder().name("Honing").build());

        ingredientRepository.saveAll(kaasEnHesp);
        ingredientRepository.saveAll(groentjes);
        ingredientRepository.saveAll(brie);

        gezond.setIngredients(groentjes);
        sandwichRepository.save(gezond);

        smoske.setIngredients(kaasEnHesp);
        sandwichRepository.save(smoske);

        brie_.setIngredients(brie);
        sandwichRepository.save(brie_);

        Order order = Order.builder().mobilePhoneNumber("0487123456").breadType(BreadType.BOTERHAMMEKES).build();
        order.setSandwich(smoske);
        orderRepository.save(order);
    }
}