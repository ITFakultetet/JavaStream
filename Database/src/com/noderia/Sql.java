package com.noderia;

import java.io.IOException;

public class Sql {
    private String sql = "";
    public String prompt = "/";

    public Sql(String sql) {
        this.sql = sql;
        parseSql(sql);
    }


    private void parseSql(String sql) {

        // Create Array of words and remove =
        String[] words = sql.split("[= ]");
        String charset = "", collation = "";

        // create database dbname
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
            } catch (IOException e) {
                e.printStackTrace();
            }

        } // end create database

        // describe database <dbname>
        if (sql.toLowerCase().startsWith("describe database")) {
            String dbName = words[2];
            Database db1 = new Database(dbName);
            try {
                db1.showDatabase(dbName);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } // end describe database

        // use <dbname>
        if (sql.toLowerCase().startsWith("use")) {
            String dbName = words[1];
            Database db = new Database(dbName);
            this.prompt = dbName + prompt;
            System.out.println("Database changed");

        } // end use


    }
}
