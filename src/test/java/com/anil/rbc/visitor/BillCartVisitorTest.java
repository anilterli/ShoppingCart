package com.anil.rbc.visitor;

import com.anil.rbc.cart.CartItem;
import com.anil.rbc.domain.FruitFactory;
import com.anil.rbc.domain.FruitType;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by anilterli on 1/26/16.
 */
public class BillCartVisitorTest {

    @Test
    public void testVisitCartItem() {
        CartItem item = new CartItem(FruitFactory.getFruit(FruitType.APPLE), 10);
        BillCartVisitor visitor = new BillCartVisitor();
        visitor.visit(item);
        assertEquals("Cost not correct", 20.0, visitor.getTotalCost());
    }

    @Test
    public void testVisitNullCartItem() {
        CartItem item = null;
        BillCartVisitor visitor = new BillCartVisitor();
        visitor.visit(item);
        assertEquals("Cost not correct", 0.0, visitor.getTotalCost());
    }

}