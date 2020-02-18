package com.noderia;

public class Sql {
    private String sql = "";

    public Sql(String sql) {
        this.sql = sql;
        parseSql(sql);
    }

    private void parseSql(String sql) {

        if (sql.toLowerCase().startsWith("create database")) {
            String[] words = sql.split(" ");
            String dbName = words[2];

            Database db1 = new Database(dbName, "UTF8");


        }


    }


}
