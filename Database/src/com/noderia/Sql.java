package com.noderia;

import java.io.IOException;

public class Sql {
    private String sql = "";
    public String prompt = "/";
    public Database currentDB;


    public Sql(String prompt, Database currentDB, String sql) {
        this.sql = sql;
        this.prompt = prompt;
        this.currentDB = currentDB;
        parseSql(currentDB, sql);
    }


    private void parseSql(Database currentDB, String sql) {


        // Prepare SQL - Create Array of words and remove =
        String[] words = sql.split("[= ]");
        String charset = "", collation = "";

        // create database <dbname>
        if (sql.toLowerCase().startsWith("create database")) {

            String dbName = words[2];
            for (int i = 0; i < words.length; i++) {
                // Find Character set
                if (words[i].equals("charset")) {
                    charset = words[i + 1];
                }
                // Find Collation
                if (words[i].equals("collation")) {
                    collation = words[i + 1];
                }

            }

            Database db1 = new Database(dbName);
            if (charset != "") db1.setCharSet(charset);
            if (collation != "") db1.setCollation(collation);
            try {
                db1.saveDatabase(db1);
                System.out.println("Database " + db1.getDbName() + " saved.");
                currentDB = db1;
            } catch (IOException e) {
                e.printStackTrace();
            }

        } // end create database

        // describe database <dbname>
        if (sql.toLowerCase().startsWith("describe database") || (sql.toLowerCase().startsWith("describe") && this.prompt.length() > 2)) {
            String dbName;
            Database showDB = new Database();

            // if sql = describe <dbname>
            if (words.length == 2) {
                dbName = words[1];
                // if sql = describe database <dbname>
            } else {
                dbName = words[2];
                showDB.setDbName(dbName);
            }

            try {
                showDB.showDatabase(dbName);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        } // end describe database

        // SQL: USE <dbname>
        if (sql.toLowerCase().startsWith("use")) {
            String dbName = words[1];
            currentDB = currentDB.openDatabase(dbName);
            this.currentDB = currentDB;
            prompt = currentDB.getDbName() + "/";
            // this.currentDBName = currentDB.getDbName();
            System.out.println("Database changed to " + currentDB.getDbName());

        } // end use

        // SQL: CREATE TABLE
        if (sql.toLowerCase().startsWith("create table")) {
            // Determine table name
            String tableName = words[2];

            // Create new table in memory

            Table t1 = new Table();
            t1.setTableName(tableName);

            // Extract fields from sql
            String fieldString = sql.substring(sql.indexOf("(") + 1, sql.indexOf(")"));
            //    System.out.println(fieldString);
            // Split fieldString into fields array
            String[] fields = fieldString.split(",");

            // loop trough fields array
            for (String field : fields) {
                // Split array into new array of each word in field statement
                String[] fieldElement = field.split(" ");

                // Create fields and set attributes
                Field f1 = new Field();
                f1.setName(fieldElement[0]);
                f1.setDataType(fieldElement[1]);

                if (field.contains("primary key")) {
                    f1.setPrimaryKey(true);
                }

                if (field.contains("auto_increment")) {
                    f1.setAutoIncrement(true);
                }

                if (field.contains("not null")) {
                    f1.setNotNull(true);
                }

                // Add field to table
                t1.addField(f1);

            } // end create and add fields to table

            // Add newly created table to currentDB
            System.out.println("currentDB = " + currentDB.getDbName());
            currentDB.addTable(currentDB, t1);


        } // end create table

    }
}
