package com.noderia;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Database implements Serializable {
    private String dbName, charSet, collation;
    private Map users;
    private LocalDateTime created;
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


    public static void deleteDatabase(String dbName) {

        try {

            HelperMethods.recursiveDelete(new File(dbName));
            java.nio.file.Files.deleteIfExists(Paths.get(dbName + "/*.*"));

            java.nio.file.Files.deleteIfExists(Paths.get(dbName));
            System.out.println("Database deleted.");

        } catch (IOException e) {
            System.out.println("Database " + dbName + " could not be deleted.");
            e.printStackTrace();
        }


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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public HashMap<Integer, Table> getTables() {
        return tables;
    }

    public void setTables(HashMap<Integer, Table> tables) {
        this.tables = tables;
    }

    public void addTable(Database db, Table table) {

        try {
            db.tables.put(tables.size() + 1, table);
            System.out.println("Added table to: " + db.getDbName());
            db.saveDatabase(db);
            System.out.println("Table created and Database Updated");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printTables() {

        System.out.printf("%-3s %-20s %-15s %-10s", "#", "Table Name", "Character set", "Collation");
        System.out.println();
        tables.forEach((k, v) -> System.out.printf("%-3d %-20s %-15s %-10s\n", k, v.getTableName(), v.getCharSet(), v.getCollation()));
    }

    public void saveDatabase(Database outDB) throws IOException {

        try {

            if (!java.nio.file.Files.isDirectory(Paths.get(outDB.dbName))) {

                // Create directory for database files
                java.nio.file.Files.createDirectory(Paths.get(outDB.dbName));

            }

            FileOutputStream dbFile = new FileOutputStream(outDB.dbName + "/" + outDB.dbName + ".db");
            ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(dbFile));
            os.writeObject(outDB);
            os.flush();
            os.close();
            dbFile.flush();
            dbFile.close();

        } catch (IOException e) {
            System.out.println("Not able to save database file. Message: " + e.getMessage());
        }

    }

    public Database openDatabase(String dbName) {
        ObjectInputStream dbIs;
        Database openedDB = new Database();
        try (FileInputStream dbFile = new FileInputStream(dbName + "/" + dbName + ".db")) {
            dbIs = new ObjectInputStream(new BufferedInputStream(dbFile));
            openedDB = (Database) dbIs.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Database Unknown");
            ;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return openedDB;
    }

    public void describeDatabase(String dbName) throws IOException, ClassNotFoundException {

        ObjectInputStream is;
        try (FileInputStream dbFile = new FileInputStream(dbName + "/" + dbName + ".db")) {
            is = new ObjectInputStream(new BufferedInputStream(dbFile));
            Database db = (Database) is.readObject();
            System.out.println("Database Info");
            System.out.println("-".repeat(65));
            System.out.println("Name: " + db.dbName + " - Default Character Set: " + db.getCharSet() + " - Default Collation: " + db.getCollation());
            System.out.println("-".repeat(65));

            System.out.println("Tables");
            System.out.println("-".repeat(65));
            db.printTables();
            System.out.println("-".repeat(65));
            System.out.println();
            System.out.println("Tabellstrukturer");
            System.out.println("-".repeat(65));
            db.tables.forEach((k, v) -> {
                System.out.println("Table Name: " + v.getTableName());
                System.out.println("-".repeat(65));
                v.printTableStructure();
                System.out.println();
            });

            is.close();

        } catch (IOException e) {
            System.out.println("Database unknown" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found" + e.getMessage());
        }
    }


}
