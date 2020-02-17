package com.noderia;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Database db1 = new Database("minDatabase", "UTF8");

        Table person = new Table("person");
        Field person_id = new Field("person_id", "Integer", true, true, true);
        person.addField(person_id);
        Field fornavn = new Field("fornavn", "String");
        person.addField(fornavn);
        Field etternavn = new Field("etternavn", "String");
        person.addField(etternavn);
        Field registrert = new Field("registrert","Datetime");
        person.addField(registrert);
        Field saldo = new Field("saldo","Integer");
        person.addField(saldo);

        person.setCharSet("UTF8");
        person.setCollation("nb_NO");

        db1.addTable(person);


        db1.saveDatabase(db1);

        db1.showDatabase(db1);



    }


}