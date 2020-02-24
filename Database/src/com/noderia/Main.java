package com.noderia;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String prompt = "";
    public static Database currentDB = new Database();

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("Welcome to MicroDB");
        System.out.println("Version 0.0.1");

        // Main Menu
        while (true) {
            // print prompt
            System.out.print(prompt + "> ");
            Scanner input = new Scanner(System.in);
            String inputText = input.nextLine();
            if (inputText.equals("quit")) {
                System.out.println("Goodbye...");
                System.exit(0);
            } else {
                Sql sql = new Sql(prompt, currentDB, inputText);
                prompt = sql.prompt;
                currentDB = sql.currentDB;
            }

        }

    }


}