package com.anil.rbc.cart;

import com.anil.rbc.visitor.Visitable;
import com.anil.rbc.visitor.Visitor;
import com.anil.rbc.domain.Item;

/**
 * Created by anilterli on 1/26/16.
 */
public class CartItem implements Visitable {
    private Item item;
    private int quantity;

    public CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
