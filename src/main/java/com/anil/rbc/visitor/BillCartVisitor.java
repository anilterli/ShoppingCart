package com.anil.rbc.visitor;

import com.anil.rbc.cart.CartItem;
import org.apache.log4j.Logger;

/**
 * Created by anilterli on 1/26/16.
 */
public class BillCartVisitor implements Visitor {
    private static final Logger LOG = Logger.getLogger(BillCartVisitor.class);

    private double totalCost;

    @Override
    public void visit(CartItem cartItem) {
        if ( cartItem != null ) {
            totalCost += cartItem.getQuantity() * cartItem.getItem().getPricePerPound();
        }
    }

    public double getTotalCost() {
        return totalCost;
    }

}

