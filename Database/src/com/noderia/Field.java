package com.noderia;

import java.io.Serializable;

public class Field implements Serializable {

    private String name;
    private String dataType;
    private boolean primaryKey;
    private boolean notNull;
    private boolean autoIncrement;

    public Field() {
    }

    public Field(String name, String dataType) {
        this.name = name;
        this.dataType = dataType;
    }

    public Field(String name, String dataType, boolean primaryKey, boolean notNull, boolean autoIncrement) {
        this.name = name;
        this.dataType = dataType;
        this.primaryKey = primaryKey;
        this.notNull = notNull;
        this.autoIncrement = autoIncrement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
        this.notNull = true;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }
}
