package com.ucll.da.dentravak.model;

import java.util.List;

public class Lunch{
    private String name;
    private List<Ingredient> ingredients;
    private double price;


    public Lunch(String name, List<Ingredient> ingredients, double price) {
        setName(name);
        setIngredients(ingredients);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null ||name.trim().isEmpty()) throw new IllegalArgumentException("Name can't be empty");
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <=0) throw new IllegalArgumentException("Price can't be 0 or lower");

        this.price = price;
    }
}
