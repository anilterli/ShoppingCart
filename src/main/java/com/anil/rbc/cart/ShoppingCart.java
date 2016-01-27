package com.anil.rbc.cart;

import com.anil.rbc.visitor.BillCartVisitor;
import com.anil.rbc.visitor.PrintCartVisitor;
import com.anil.rbc.domain.Item;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by anilterli on 1/26/16.
 */
public class ShoppingCart {
    private static final Logger LOG = Logger.getLogger(ShoppingCart.class);

    private Map<Item, CartItem> cartMap;

    public ShoppingCart() {
        cartMap = new HashMap<Item, CartItem>();
    }

    public void addItem(CartItem item) {
        if ( item == null ) {
            LOG.info("Adding a null item to cart");
            return;
        }
        CartItem existingItem = cartMap.get(item.getItem());
        if ( existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            cartMap.put(item.getItem(), item);
        }
    }

    public void removeItem(CartItem item) {
        throw new UnsupportedOperationException("Remove is not yet supported");
    }

    public Collection<CartItem> getCartItems() {
        return cartMap.values();
    }

    public void printCartItems() {
        PrintCartVisitor printVisitor = new PrintCartVisitor();
        Collection<CartItem> items = this.getCartItems();
        if (CollectionUtils.isEmpty(items)) {
            LOG.info("Shopping cart is empty");
            return;
        }
        LOG.info("Listing items in the cart:");
        for (CartItem item : items) {
            printVisitor.visit(item);
        }
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;
        Collection<CartItem> items = this.getCartItems();

        if (CollectionUtils.isEmpty(items)) {
            LOG.info("Shopping cart is empty");
            return totalCost;
        }

        BillCartVisitor billVisitor = new BillCartVisitor();
        for (CartItem item : items) {
            billVisitor.visit(item);
        }
        totalCost = billVisitor.getTotalCost();
        return totalCost;
    }

}
