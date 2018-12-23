package com.ucll.da.dentravak.model;

import java.util.HashMap;

public class SandwichPreferences extends HashMap<Long, Float> {

    public Float getRatingForSandwich(Long sandwichId) {
        return super.get(sandwichId);
    }
}