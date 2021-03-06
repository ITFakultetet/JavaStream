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

            HelperMethods.recursiveDelete(new File("data/" + dbName));
            java.nio.file.Files.deleteIfExists(Paths.get("data/" + dbName + "/*.*"));

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

        if (tables.size() > 0) {
            System.out.println("+" + "-".repeat(65) + "+");
            System.out.printf("| %-3s | %-25s | %-15s | %-10s  |\n", "#", "Table Name", "Character set", "Collation");
            System.out.println("+" + "-".repeat(65) + "+");
            tables.forEach((k, v) -> System.out.printf("| %-3d | %-25s | %-15s | %-10s  |\n", k, v.getTableName(), v.getCharSet(), v.getCollation()));
            System.out.println("+" + "-".repeat(65) + "+");
        } else {
            System.out.println("No tables found");
        }

    }

    public void saveDatabase(Database outDB) throws IOException {

        try {

            // check if data directory exists
            if (!java.nio.file.Files.isDirectory(Paths.get("data"))) {
                // Create data directory
                java.nio.file.Files.createDirectory(Paths.get("data"));

            }

            // check if database directory exists in data directory
            if (!java.nio.file.Files.isDirectory(Paths.get("data/" + outDB.dbName))) {

                // Create directory for database files
                java.nio.file.Files.createDirectory(Paths.get("data/" + outDB.dbName));

            }

            // write .db file
            FileOutputStream dbFile = new FileOutputStream("data/" + outDB.dbName + "/" + outDB.dbName + ".db");
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
        try (FileInputStream dbFile = new FileInputStream("data/" + dbName + "/" + dbName + ".db")) {
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

    public void describeDatabase(String dbName, boolean full) throws IOException, ClassNotFoundException {

        ObjectInputStream is;
        try (FileInputStream dbFile = new FileInputStream("data/" + dbName + "/" + dbName + ".db")) {
            is = new ObjectInputStream(new BufferedInputStream(dbFile));
            Database db = (Database) is.readObject();

            System.out.println();
            System.out.println("+" + "-".repeat(27) + "+" + "-".repeat(32) + "+");
            System.out.printf("| %-25s | %-30s |\n", "Database Name ", db.dbName);
            System.out.println("+" + "-".repeat(27) + "+" + "-".repeat(32) + "+");
            System.out.printf("| %-25s | %-30s |\n", "Default Character Set", db.getCharSet());
            System.out.printf("| %-25s | %-30s |\n", "Default Collation ", db.getCollation());
            System.out.printf("| %-25s | %-30s |\n", "Created ", db.getCreated());
            System.out.printf("| %-25s | %-30s |\n", "Tables", db.tables.size());
            System.out.println("+" + "-".repeat(27) + "+" + "-".repeat(32) + "+");
            System.out.println();

            // print table structures, if database has tables and sql = describe full

            if (db.tables.size() > 0) {
                System.out.println("Tables");
                db.printTables();
            }

            if (full && db.tables.size() > 0) {
                System.out.println();
                System.out.println("Table Structures\n");

                db.tables.forEach((k, v) -> {
                    v.printTableStructure();
                    System.out.println();
                });

            }
            is.close();

        } catch (IOException e) {
            System.out.println("Database unknown " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e.getMessage());
        }
    }


}
