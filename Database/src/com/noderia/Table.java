package com.noderia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;

public class Table implements Serializable {
    private String tableName, charSet, collation;
    private HashMap<Integer, Field> tableStructure = new HashMap<>();

    public Table() {
    }

    public Table(String tableName) {
        this.tableName = tableName;
    }

    public Table(String tableName, String charSet) {
        this.tableName = tableName;
        this.charSet = charSet;
    }

    public Table(String tableName, String charSet, String collation) {
        this.tableName = tableName;
        this.charSet = charSet;
        this.collation = collation;
    }

    // Add Fields to the tableStructure HashMap
    public void addField (Field field) {
        this.tableStructure.put(tableStructure.size()+1,field);
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
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

    public void printTableStructure() {
        tableStructure.forEach((k, v) -> System.out.println(k + " " + v.getName() + " " + v.getDataType() + " " + v.isNotNull() + " " + v.isPrimaryKey() + " " + v.isAutoIncrement()));
    }

    public void saveTableStructure() {

    }

    // create the physical table file
    public void writeTableToDisk(String dbName) {
        try {
            PrintWriter out = new PrintWriter(new File("data/" + dbName + "/" + tableName + ".tbl"));
        } catch (FileNotFoundException e) {
            System.out.println("Table could not we written to disk: ");
            e.printStackTrace();
        }
    }


}
