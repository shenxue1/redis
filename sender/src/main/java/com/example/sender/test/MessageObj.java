package com.example.sender.test;

public class MessageObj {

    private boolean ACK;
    private int id;
    private String name;
    private String value;

    public boolean isACK() {
        return ACK;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setACK(boolean ACK) {
        this.ACK = ACK;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
