package com.ucll.da.dentravak.model;

public class Ingredient {
    private String name;

    public Ingredient(String name) {
       setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null ||name.trim().isEmpty()) throw new IllegalArgumentException("Name can't be empty");
        this.name = name;
    }
}
