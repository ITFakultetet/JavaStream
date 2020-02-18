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

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getCharSet() {
        return charSet;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public String getCollation() {
        return collation;
    }

    public void setCollation(String collation) {
        this.collation = collation;
    }

    public Map getUsers() {
        return users;
    }

    public void setUsers(Map users) {
        this.users = users;
    }

    public void addTable(Table table) {
        this.tables.put(tables.size() + 1, table);
    }

    public void printTables() {
        tables.forEach((k, v) -> System.out.println(k + " " + v.getTableName() + " " + v.getCharSet() + " " + v.getCollation()));
    }

    public void saveDatabase(Database database) throws IOException {

        try {

            if (new File(database.dbName + ".dat").isFile()) {
                FileOutputStream dbFile = new FileOutputStream(database.dbName + ".dat");
                AppendableObjectOutputStream os = new AppendableObjectOutputStream(new BufferedOutputStream(dbFile));
                os.writeObject(database);
                os.flush();
                os.close();
            } else {
                FileOutputStream dbFile = new FileOutputStream(database.dbName + ".dat");
                ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(dbFile));
                os.writeObject(database);
                os.flush();
                os.close();
            }

        } catch (IOException e) {
            System.out.println("Not able to save database file. Message: " + e.getMessage());
        }
    }

    public void showDatabase(String dbName) throws IOException, ClassNotFoundException {

        ObjectInputStream is;
        try (FileInputStream dbFile = new FileInputStream(dbName + ".dat")) {
            is = new ObjectInputStream(new BufferedInputStream(dbFile));
            Database db = (Database) is.readObject();
            System.out.println("Database Info");
            System.out.println("-".repeat(40));
            System.out.println("Name: " + db.dbName + " - Default Character Set: " + db.getCharSet() + " - Default Collation: " + db.getCollation());
            System.out.println("-".repeat(40));

            System.out.println("Tables");
            System.out.println("-".repeat(40));
            db.printTables();
            System.out.println("-".repeat(40));
            System.out.println("Tabellstrukturer");
            System.out.println("-".repeat(40));
            db.tables.forEach((k, v) -> {
                System.out.println("Table Name: " + v.getTableName());
                System.out.println("-".repeat(40));
                v.printTableStructure();
                System.out.println();
            });

            is.close();

        } catch (IOException e) {
            System.out.println("Database unknown");
        }

    }


}
