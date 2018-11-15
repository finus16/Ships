package com.statki;

public class Field {
    private boolean isBusy; // is there a ship in this field?
    private boolean isHit; // was this field hit?

    Field(){
        this.isBusy = false;
        this.isHit = false;
    }

    public boolean isBusy(){
        return this.isBusy;
    }

    public boolean isHit(){
        return this.isHit;
    }

    public void setShip(){
        this.isBusy = true;
    }

    public void hit(){
        this.isHit = true;
    }


}
