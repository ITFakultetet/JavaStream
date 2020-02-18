package com.noderia;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Database implements Serializable {
    private String dbName, charSet, collation;
    private Map users;
    private HashMap<Integer, Table> tables = new HashMap<>();

    public Database() {
    }

    public Database(String dbName) {
        this.dbName = dbName;
    }

    public Database(String dbName, String charSet) {
        this.dbName = dbName;
        this.charSet = charSet;
    }

    public Database(String dbName, String charSet, String collation) {
        this.dbName = dbName;
        this.charSet = charSet;
        this.collation = collation;
    }

    public Database(String dbName, String charSet, String collation, Map users) {
        this.dbName = dbName;
        this.charSet = charSet;
        this.collation = collation;
        this.users = users;
    }


    public void addTable(Table table) {
        this.tables.put(tables.size() + 1, table);
    }

    public void printTables() {
        tables.forEach((k, v) -> System.out.println(k + " " + v.getTableName() + " " + v.getCharSet() + " " + v.getCollation()));
    }

    public void saveDatabase(Database database) throws IOException {

        FileOutputStream dbFile = new FileOutputStream(database.dbName + ".dat");
        ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(dbFile));
        os.writeObject(database);
        os.flush();
        os.close();

    }

    public void showDatabase(Database database) throws IOException, ClassNotFoundException {

        FileInputStream dbFile = new FileInputStream(database.dbName + ".dat");
        ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(dbFile));
        Database db = (Database) is.readObject();
        System.out.println("Database Info");
        System.out.println("-".repeat(40));
        System.out.println("Name: "+db.dbName);
        System.out.println("-".repeat(40));

        System.out.println("Tables");
        System.out.println("-".repeat(40));
        db.printTables();
        System.out.println("-".repeat(40));
        System.out.println("Tabellstrukturer");
        System.out.println("-".repeat(40));
        db.tables.forEach((k,v) -> {
            System.out.println("Table Name: "+v.getTableName());
            System.out.println("-".repeat(40));
            v.printTableStructure();
        });

        is.close();

    }


}
