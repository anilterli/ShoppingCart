package com.anil.rbc.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by anilterli on 1/26/16.
 */
public abstract class Fruit implements Item {

    private String name;
    private double pricePerPound;

    public Fruit(String name, double pricePerPound) {
        this.name = name;
        this.pricePerPound = pricePerPound;
    }

    public String getName() {
        return this.name;
    }

    public double getPricePerPound() {
        return this.pricePerPound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        Fruit fruit = (Fruit) o;

        return new EqualsBuilder()
                .append(pricePerPound, fruit.pricePerPound)
                .append(name, fruit.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(pricePerPound)
                .toHashCode();
    }
}
