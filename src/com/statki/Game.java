package com.statki;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Game {
    private Scanner scanner;
    private int size;
    private Board playerBoard, computerBoard;
    private List<Ship> ships;

    public Game(){
        this.init();
    }

    private void init(){
        this.scanner = new Scanner(System.in);
        this.setSize();
        this.playerBoard = new Board(this.size);
        this.computerBoard = new Board(this.size);
        this.ships = new ArrayList<Ship>();

        //adding 4 ships in different sizes
        ships.add(new Ship(2));
        ships.add(new Ship(3));
        ships.add(new Ship(4));
        ships.add(new Ship(5));

        this.setPlayerShips();
        this.setComputerShips();
    }

    private void setPlayerShips() {
        playerBoard.display();
        for(int i=0; i<ships.size(); i++) {
            setShip(ships.get(i));
        }
    }

    private void setShip(Ship ship) {
        char x;
        int y;

        do{
            System.out.println("Where to place " + ship.getSize() + "mast ship?");
            x = (char)scanner.nextByte();
            y = scanner.nextInt();
        }while(false);
    }

    private void setComputerShips() {

    }

    private void setSize(){
        do{
            System.out.println("Enter board size please (value between 5 - 10)");
            this.size = scanner.nextInt();
        }while(this.size>10 || this.size<5);

        System.out.println("Board size has been set to " + this.size + "x" + this.size);
    }

    public void play(){
    }
}
