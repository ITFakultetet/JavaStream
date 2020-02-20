package com.noderia;

import java.io.IOException;

import org.apache.calcite.sql.dialect.MysqlSqlDialect;
public class Sql {
    private String sql = "";
    public String prompt = "/";

    public Sql(String prompt, String sql) {
        this.sql = sql;
        this.prompt = prompt;
        parseSql(sql);
    }


    private void parseSql(String sql) {


        // Prepare SQL - Create Array of words and remove =
        String[] words = sql.split("[= ]");
        String charset = "", collation = "";
        Database currentDB = new Database();

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
            } catch (IOException e) {
                e.printStackTrace();
            }

        } // end create database

        // describe database <dbname>
        if (sql.toLowerCase().startsWith("describe database") || (sql.toLowerCase().startsWith("describe") && this.prompt.length() > 2)) {
            String dbName;
            // if sql = describe <dbname>
            if (words.length == 2) {
                dbName = words[1];
                // if sql = describe database <dbname>
            } else {
                dbName = words[2];
                currentDB.setDbName(dbName);
            }


            try {
                currentDB.showDatabase(dbName);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } // end describe database

        // use <dbname>
        if (sql.toLowerCase().startsWith("use")) {
            String dbName = words[1];
            currentDB.setDbName(dbName);
            this.prompt = currentDB.getDbName() + "/";
            System.out.println("Database changed");

        } // end use


    }
}
