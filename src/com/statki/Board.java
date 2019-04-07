package com.statki;

public class Board {
    private int size;
    private Field board[][];

    Board(int size){
        this.size = size;
        board = new Field[this.size][this.size];
        for(int i=0; i<this.size; i++){
            for(int j=0; j<this.size; j++){
                this.board[i][j] = new Field();
            }
        }
    }

    public void display(){
        for(int i=0; i<this.size; i++) System.out.print(" " + (char)(65+i));
        System.out.println();
        for(int i=0; i<this.size; i++){
            System.out.print(i+1);
            for(int j=0; j<this.size; j++){
                if(board[j][i].isBusy()){
                    System.out.print("X");
                }else{
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean setShip(Ship ship, int x, int y, String orientation) {
        if(x<1) return false;
        if(x>size) return false;
        if(y<1) return false;
        if(y>size) return false;
        int shipSize = ship.getSize();

        if(x - 1 + shipSize>this.size) return false;
        if(y - 1 + shipSize>this.size) return false;



        switch (orientation.charAt(0)){
            case 'h':
                for(int i=0; i<shipSize; i++){
                    if(this.board[x-1+i][y-1].isBusy())
                        return false;
                }
                for(int i=0; i<shipSize; i++){
                    this.board[x-1+i][y-1].setShip();
                }
                return true;
            case 'v':
                for(int i=0; i<shipSize; i++){
                    if(this.board[x-1][y-1+i].isBusy())
                        return false;
                }
                for(int i=0; i<shipSize; i++){
                    this.board[x-1][y-1+i].setShip();
                }
                return true;
            default:
                return false;
        }
    }
}
