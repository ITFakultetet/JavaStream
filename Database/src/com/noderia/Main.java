package com.noderia;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        // Main Menu
        while (true) {

            System.out.print("> ");
            Scanner input = new Scanner(System.in);
            String inputText = input.nextLine();
            if (inputText.equals("quit")) {
                System.out.println("Goodbye...");
                System.exit(0);
            } else {
                Sql sql = new Sql(inputText);
            }


        }


//        Table person = new Table("person");
//        Field person_id = new Field("person_id", "Integer", true, true, true);
//        person.addField(person_id);
//        Field fornavn = new Field("fornavn", "String");
//        person.addField(fornavn);
//        Field etternavn = new Field("etternavn", "String");
//        person.addField(etternavn);
//        Field registrert = new Field("registrert", "Datetime");
//        person.addField(registrert);
//        Field saldo = new Field("saldo", "Integer");
//        person.addField(saldo);
//
//        person.setCharSet("UTF8");
//        person.setCollation("nb_NO");
//
//        db1.addTable(person);
//
//        // Add table firma
//        Table firma = new Table("firma");
//        Field firma_id = new Field("firma_id", "Integer", true, true, true);
//        firma.addField(firma_id);
//        Field firmanavn = new Field("firmanavn", "String");
//        firma.addField(firmanavn);
//        Field orgnummer = new Field("orgnummer", "String");
//        firma.addField(orgnummer);
//        Field registrert2 = new Field("registrert", "Datetime");
//        firma.addField(registrert2);
//        Field ansatte = new Field("ansatte", "Integer");
//        firma.addField(ansatte);
//
//        firma.setCharSet("UTF8");
//        firma.setCollation("nb_NO");
//
//        db1.addTable(firma);
//
//
//        db1.saveDatabase(db1);
//
//        db1.showDatabase(db1);
//

    }


}