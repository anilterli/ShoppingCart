package com.anil.rbc.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by anilterli on 1/26/16.
 */
public enum FruitType {

    BANANA("Banana", 1.0),
    APPLE("Apple", 2.0),
    ORANGE("Orange", 2.5),
    PEACH("Peach", 3.0),
    LEMON("Lemon", 1.5),
    INVALID("Invalid", 0);

    private final String name;
    private final double pricePerPound;

    FruitType(String name, double price) {
        this.name=name;
        this.pricePerPound=price;
    }

    public String getName() {
        return name;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

    public static FruitType getFruitType(String name) {
        if ( StringUtils.isEmpty(name)) {
            return INVALID;
        }
        FruitType returnType = FruitType.INVALID;
        for (FruitType type : FruitType.values()) {
            if (type.name.toUpperCase().equals(name.toUpperCase())) {
                returnType = type;
            }
        }
        return returnType;
    }

    @Override
    public String toString() {
        return new StringBuilder("Name: ")
                .append(this.getName())
                .append(", Price/Pound:")
                .append(this.getPricePerPound())
                .toString();
    }
}
