package com.ucll.da.dentravak.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ucll.da.dentravak.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import  java.time.LocalDateTime;
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

        List<Ingredient> kaasEnHesp = new ArrayList<>();
        List<Ingredient> groentjes = new ArrayList<>();
        groentjes.add(Ingredient.builder().name("Groentjes").build());
        kaasEnHesp.add(Ingredient.builder().name("Kaas").build());
        kaasEnHesp.add(Ingredient.builder().name("Hesp").build());

        ingredientRepository.saveAll(kaasEnHesp);
        ingredientRepository.saveAll(groentjes);

        gezond.setIngredients(groentjes);
        sandwichRepository.save(gezond);

        smoske.setIngredients(kaasEnHesp);
        sandwichRepository.save(smoske);

        Order order = Order.builder().name("Smoske").price(new BigDecimal(3.5)).mobilePhoneNumber("0487\\/123456").breadType(BreadType.BOTERHAMMEKES).creationDate(LocalDateTime.now()).build();
        order.setSandwich(smoske);
        orderRepository.save(order);
    }
}