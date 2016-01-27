package com.anil.rbc.visitor;

import com.anil.rbc.cart.CartItem;
import org.apache.log4j.Logger;

/**
 * Created by anilterli on 1/26/16.
 */
public class PrintCartVisitor implements Visitor {
    private static final Logger LOG = Logger.getLogger(PrintCartVisitor.class);

    @Override
    public void visit(CartItem cartItem) {
        LOG.info("Name: " + cartItem.getItem().getName() + ", Quantity: " + cartItem.getQuantity());
    }

}

