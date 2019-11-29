package org.launchcode.techjobs_oo;

import java.util.Objects;

abstract class JobField {
    private int id;
    private static int nextId = 1;
    private String value;

    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
        if(this.value.equals("")){
            return "Data not available";
        } else {
            return value;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    //Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
