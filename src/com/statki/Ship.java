package com.statki;

public class Ship {
    String name;
    private int shipSize;

    public Ship(String name, int size){
        this.name = name;
        this.shipSize = size;
    }

    public String getName(){
        return this.name;
    }

    public int getSize(){
        return this.shipSize;
    }
}
