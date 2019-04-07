package com.statki;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class Game {
    private Scanner scanner;
    private Random random;
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
        this.random = new Random();


        //adding 4 ships in different sizes
        ships.add(new Ship("Boat",2));
        ships.add(new Ship("Submarine",  3));
        ships.add(new Ship("Destroyer", 4));
        ships.add(new Ship("Aircraft Carrier", 5));

        this.setPlayerShips();
        this.setComputerShips();
    }

    private void setPlayerShips() {
        for (Ship ship: ships) {
            setShip(ship);
        }
    }

    private void setShip(Ship ship) {

        String cords, orientation;
        int x,y; //coordinates where to set a ship

        boolean isSet = false;

        do{
            playerBoard.display();
            System.out.println("Where do you want to place " + ship.getName() + "?");
            cords = scanner.nextLine(); //user response
            if(cords.length()!=2 && cords.length()!=3){ //make sure that the anwear is 2 or 3 byte long e.g. A7 or C13
                System.out.println("I don't understand... Please try again :-) " + cords.length());
            }else{
                x = (int) cords.toUpperCase().charAt(0)-64;
                y = Integer.parseInt(cords.substring(1));
                System.out.println("Set horizontally (h) or verticaly (v)?");
                orientation = scanner.nextLine();
                isSet = playerBoard.setShip(ship, x, y, orientation);
            }
        }while(!isSet);


    }

    private void setComputerShips() {
        int x, y;
        boolean isSet = false;
        for(int i=0; i<ships.size(); i++){
            x = random.nextInt(this.size+1);
            y = random.nextInt(this.size+1);
            if(random.nextInt(1)>0){
                isSet = computerBoard.setShip(ships.get(i), x, y, "v");
            }else{
                isSet = computerBoard.setShip(ships.get(i), x, y, "h");
            }
            if(!isSet) i--;
        }
    }

    private void setSize() {
        do {
            System.out.println("Enter board size please (value between 5 - 10)");
            this.size = scanner.nextInt();
        } while (this.size > 10 || this.size < 5);

        System.out.println("Board size has been set to " + this.size + "x" + this.size);
    }

    public void play(){
    }
}
