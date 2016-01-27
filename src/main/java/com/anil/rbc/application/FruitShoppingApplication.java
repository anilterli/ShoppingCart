package com.anil.rbc.application;

import com.anil.rbc.cart.CartItem;
import com.anil.rbc.cart.ShoppingCart;
import com.anil.rbc.domain.FruitFactory;
import com.anil.rbc.domain.FruitType;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

/**
 * Created by anilterli on 1/26/16.
 */
public class FruitShoppingApplication {

    private static final Logger LOG = Logger.getLogger(FruitShoppingApplication.class);
    private static final String MENU_OPTIONS =
                    new StringBuilder("\n")
                            .append("********* Menu **********").append("\n")
                            .append("(1) Add an item to cart ").append("\n")
                            .append("(2) Remove item from cart ").append("\n")
                            .append("(3) List items in cart ").append("\n")
                            .append("(4) Display total cost of items in cart ").append("\n")
                            .append("(5) Exit ").append("\n")
                            .append("***************************").append("\n")
                            .append("Enter the option number: ")
                            .toString();
    private static final String ADD_MENU_OPTIONS =
            new StringBuilder("\n")
                    .append("********* Add Menu **********").append("\n")
                    .append("Enter Item Name and Weight as (.e.g. Banana 10) ").append("\n")
                    .append("Or Enter 2 to return to main menu ").append("\n")
                    .append("***************************").append("\n")
                    .toString();
    private ShoppingCart cart;
    private UserInput userInput;

    public FruitShoppingApplication() {
        this.cart = new ShoppingCart();
        userInput = new UserInput(System.in, System.out);
    }

    private void run() {
        int option = 0;
        while (option != 5 ) {
            option = userInput.getUserInputAsInt(MENU_OPTIONS);

            if ( option == 1) {
                addItem();
            } else if ( option == 2) {
                removeItem();
            } else if ( option == 3) {
                listItems();
            } else if ( option == 4) {
                totalCartCost();
            } else if ( option != 5) {
                LOG.error("Incorrect Option selected. Please select the correct option");
            }
        }
    }

    private void addItem() {
        int option = 0;

        printInventoryList();

        while ( option != 2 ) {
            String line = userInput.getUserInputAsText(ADD_MENU_OPTIONS);
            String[] tokens;
            try {
                tokens = validateAddItemUserInput(line);
                if ( tokens.length == 1 && isAddUserInputSingleTokenValid(tokens[0])) {
                    break;
                } else {
                    cart.addItem(validateAddItemUserInputMultipleToken(tokens));
                }
            } catch (InvalidUserInputException e) {
                LOG.error(e.getMessage());
            }
         }
    }

    private void printInventoryList() {
        printToConsole("List of Items Available to Add");

        //For now just fruits. will need to change this to add other types of items
        for (FruitType type : FruitType.values()) {
            if ( type != FruitType.INVALID ) {
                printToConsole(type.toString());
            }
        }
        printToConsole("");
    }

    protected String[] validateAddItemUserInput(String inputText) throws InvalidUserInputException {
        String[] tokens = inputText.split("\\s+");
        if ( tokens.length == 0 || tokens.length > 2) {
            throw new InvalidUserInputException("Incorrect Data Entry. Please enter in the correct format");
        }
        return tokens;
    }

    protected boolean isAddUserInputSingleTokenValid(String token) throws InvalidUserInputException {
        if (NumberUtils.isDigits(token) && Integer.parseInt(token) == 2) {
            return true;
        } else {
            throw new InvalidUserInputException("Incorrect option. Please enter the correct values");
        }
    }

    protected CartItem validateAddItemUserInputMultipleToken(String[] tokens) throws InvalidUserInputException {
        if ( tokens == null || tokens.length != 2) {
            throw new InvalidUserInputException("Invalid input");
        }
        String fruitName = tokens[0];
        FruitType fruitType = FruitType.getFruitType(fruitName);
        if (FruitType.INVALID.equals(fruitType)) {
            throw new InvalidUserInputException("Incorrect Item Name. Please enter the correct name");
        }

        int quantity;
        try {
            quantity = Integer.parseInt(tokens[1]);
        } catch (NumberFormatException nfe) {
            throw new InvalidUserInputException("Incorrect Quantity. Please enter in the correct format");
        }

        return new CartItem(FruitFactory.getFruit(fruitType), quantity);
}

    private void removeItem() {
        LOG.info("Removing is not yet implemented..");
    }

    private void listItems() {
        cart.printCartItems();
    }

    private void totalCartCost() {
        LOG.info("Total Cost : " + cart.calculateTotalCost());
    }

    private void printToConsole(String message) {
        System.out.println(message);
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }

    public static void main(String[] args) {
        FruitShoppingApplication app = new FruitShoppingApplication();
        app.run();
    }
}
