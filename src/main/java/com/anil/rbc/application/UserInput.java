package com.anil.rbc.application;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by anilterli on 1/26/16.
 */
public class UserInput {
    private final Scanner scanner;
    private final PrintStream printStream;

    public UserInput(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.printStream = out;
    }

    public int getUserInputAsInt(String textToAsk) {
        printStream.print(textToAsk);
        return scanner.nextInt();
    }

    public String getUserInputAsText(String textToAsk) {
        printStream.print(textToAsk);
        scanner.useDelimiter(System.getProperty("line.separator"));
        return scanner.next();
    }

}
