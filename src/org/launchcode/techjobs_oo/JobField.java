package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class JobField {
    private String value;
    private int id;
    private static int nextId = 1;

    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String newValue) {
        this();
        if(newValue == "" || newValue == null) {
            this.value = "Data not available";
        } else {
            this.value = newValue;
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }
}
