package com.anil.rbc.visitor;

import com.anil.rbc.cart.CartItem;

/**
 * Created by anilterli on 1/26/16.
 */
public interface Visitor {

    void visit(CartItem item);
}
