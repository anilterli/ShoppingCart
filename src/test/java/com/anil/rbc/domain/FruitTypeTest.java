package com.anil.rbc.domain;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by anilterli on 1/26/16.
 */
public class FruitTypeTest {

    @Test
    public void testGetFruitTypeNullArgument() {
        assertTrue(FruitType.INVALID.equals(FruitType.getFruitType(null)));
    }

    @Test
    public void testGetFruitTypeValidArgument() {
        assertTrue(FruitType.LEMON.equals(FruitType.getFruitType("Lemon")));
    }

    @Test
    public void testGetFruitTypeValidArgumentCaseInsensitive() {
        assertTrue(FruitType.ORANGE.equals(FruitType.getFruitType("OrANge")));
    }
}