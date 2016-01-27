package com.anil.rbc.domain;

/**
 * Created by anilterli on 1/26/16.
 */
public class FruitFactory {
    public static Fruit getFruit(FruitType type) {
        Fruit returnFruit = null;

        if ( FruitType.INVALID.equals(type) ) {
            return null;
        }
        if ( FruitType.BANANA.equals(type)) {
            returnFruit = new Banana(type.getName(), type.getPricePerPound());
        } else if ( FruitType.APPLE.equals(type)) {
            returnFruit = new Apple(type.getName(), type.getPricePerPound());
        } else if ( FruitType.ORANGE.equals(type)) {
            returnFruit = new Orange(type.getName(), type.getPricePerPound());
        } else if ( FruitType.PEACH.equals(type)) {
            returnFruit = new Peach(type.getName(), type.getPricePerPound());
        } else if ( FruitType.LEMON.equals(type)) {
            returnFruit = new Lemon(type.getName(), type.getPricePerPound());
        }

        return returnFruit;
    }
}
