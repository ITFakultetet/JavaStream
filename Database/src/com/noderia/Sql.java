package com.noderia;

public class Sql {
    private String sql = "";

    public Sql(String sql) {
        this.sql = sql;
        parseSql(sql);
    }

    private void parseSql(String sql) {

        String[] words = sql.split(" ");
        String charset = "";

        if (sql.toLowerCase().startsWith("create database")) {

            String dbName = words[2];
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals("charset")) {
                    charset = word[i + 2];
                } else {
                    charset = "";
                }
            }


            Database db1 = new Database(dbName, charset);


        }


    }


}
