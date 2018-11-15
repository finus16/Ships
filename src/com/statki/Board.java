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
                if(board[i][j].isBusy()){
                    System.out.print("X");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
