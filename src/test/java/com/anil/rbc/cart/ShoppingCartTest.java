package com.anil.rbc.cart;

import com.anil.rbc.domain.FruitFactory;
import com.anil.rbc.domain.FruitType;
import org.junit.Test;

import java.util.Collection;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by anilterli on 1/26/16.
 */
public class ShoppingCartTest {

    @Test
    public void testAddItem(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.PEACH), 20));

        Collection<CartItem> items = cart.getCartItems();
        assertNotNull(items);
        assertEquals("Cart count is incorrect", 1, items.size());
    }

    @Test
    public void testAddSameItemAgain(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.PEACH), 20));
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.PEACH), 30));

        Collection<CartItem> items = cart.getCartItems();
        assertNotNull(items);
        assertEquals("Cart count is incorrect", 1, items.size());
        assertEquals("Item quantity is incorrect", 50, items.iterator().next().getQuantity());
    }

    @Test
    public void testAddMultipleItems(){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.PEACH), 20));
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.PEACH), 30));
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.LEMON), 70));

        Collection<CartItem> items = cart.getCartItems();
        assertNotNull(items);
        assertEquals("Cart count is incorrect", 2, items.size());
        for (CartItem item : items) {
            if (item.getItem().getName().equals(FruitType.PEACH.getName())) {
                assertEquals("Item quantity is incorrect", 50, item.getQuantity());
            } else if (item.getItem().getName().equals(FruitType.LEMON.getName())) {
                assertEquals("Item quantity is incorrect", 70, item.getQuantity());
            }
        }
    }

    @Test
    public void testAddMultipleProductsMultipleTimesToCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.PEACH), 20));
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.PEACH), 30));
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.LEMON), 70));
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.LEMON), 50));
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.ORANGE), 35));
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.ORANGE), 45));

        Collection<CartItem> items = cart.getCartItems();
        assertNotNull(items);
        assertEquals("Cart count is incorrect", 3, items.size());
        for (CartItem item : items) {
            if (item.getItem().getName().equals(FruitType.PEACH.getName())) {
                assertEquals("Item quantity is incorrect", 50, item.getQuantity());
            } else if (item.getItem().getName().equals(FruitType.LEMON.getName())) {
                assertEquals("Item quantity is incorrect", 120, item.getQuantity());
            } else if (item.getItem().getName().equals(FruitType.ORANGE.getName())) {
                assertEquals("Item quantity is incorrect", 80, item.getQuantity());
            }
        }

    }

    @Test (expected = UnsupportedOperationException.class)
    public void testRemoveNullItem() {
        new ShoppingCart().removeItem(null);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testRemoveItem() {
        new ShoppingCart().removeItem(new CartItem(FruitFactory.getFruit(FruitType.APPLE), 10));
    }

    @Test
    public void testEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        Collection<CartItem> items = cart.getCartItems();
        assertNotNull(items);
        assertEquals("Cart count is incorrect", 0, items.size());
    }

    @Test
    public void testEmptyShoppingCartTotalCost() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals("Cost not correct", 0.0, cart.calculateTotalCost());
    }

    @Test
    public void testFullShoppingCartTotalCost() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.APPLE), 10));
        cart.addItem(new CartItem(FruitFactory.getFruit(FruitType.ORANGE), 10));
        assertEquals("Cost not correct", 45.0, cart.calculateTotalCost());
    }


}