package com.anil.rbc.application;

import com.anil.rbc.cart.CartItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by anilterli on 1/26/16.
 */
public class FruitShoppingApplicationTest {
    private FruitShoppingApplication app;

    @Before
    public void setUp() throws Exception {
        app = new FruitShoppingApplication();
    }

    @Test(expected = InvalidUserInputException.class)
    public void testValidateAddItemUserInputInvalid() throws Exception {
        app.validateAddItemUserInput("abs wer wewr");
    }

    @Test
    public void testValidateAddItemUserInputValid() throws Exception {
        String[] tokens = app.validateAddItemUserInput("banana 23");
        assertEquals("Token size is incorrect", 2, tokens.length);
    }

    @Test(expected = InvalidUserInputException.class)
    public void testIsAddUserInputSingleTokenInValid() throws Exception {
        app.isAddUserInputSingleTokenValid("abc");
    }

    @Test
    public void testIsAddUserInputSingleTokenValid() throws Exception {
        assertTrue(app.isAddUserInputSingleTokenValid("2"));
    }

    @Test(expected = InvalidUserInputException.class)
    public void testValidateAddItemUserInputMultipleTokenInvalid() throws Exception {
        app.validateAddItemUserInputMultipleToken(null);
    }

    @Test(expected = InvalidUserInputException.class)
    public void testValidateAddItemUserInputMultipleTokenInvalidArguments() throws Exception {
        app.validateAddItemUserInputMultipleToken(new String[]{"12"});
    }

    @Test(expected = InvalidUserInputException.class)
    public void testValidateAddItemUserInputMultipleTokenInvalidItem() throws Exception {
        app.validateAddItemUserInputMultipleToken(new String[]{"12", "123"});
    }

    @Test(expected = InvalidUserInputException.class)
    public void testValidateAddItemUserInputMultipleTokenInvalidQuantity() throws Exception {
        app.validateAddItemUserInputMultipleToken(new String[]{"Banana", "abc"});
    }

    @Test
    public void testValidateAddItemUserInputMultipleToken() throws Exception {
        CartItem item = app.validateAddItemUserInputMultipleToken(new String[]{"Banana", "123"});
        assertNotNull(item);
        assertTrue("Banana".equals(item.getItem().getName()));
    }

}