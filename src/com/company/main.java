package com.company;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        int m,n,k=0;
        TicTacGame Game;
        String gameMode;

        System.out.println("Welcome to Tic Tac Toe.");
        System.out.println("------------------------------------------");

        System.out.println("Pick A Mode: (auto/manual)");
        Scanner input= new Scanner(System.in); //System.in is a standard input stream.
        gameMode = input.nextLine();
        while (!gameMode.equals("auto") && !gameMode.equals("manual")) {
            System.out.println("Wrong Entry! Pick A Mode: (auto/manual)");
            input= new Scanner(System.in); //System.in is a standard input stream.
            gameMode = input.nextLine();
        }

        System.out.println("Pick The Board Dimensions: ");

        System.out.println("x-axis: Between 3 and 10, 0 for default for x and y)");
        input= new Scanner(System.in); //System.in is a standard input stream.
        m = input.nextInt();
        while (!(m>=3 && m <= 10) && m != 0 ) {
            System.out.println("Wrong value for x-axis! (Between 3 and 10, 0 for default for x and y)");
            input= new Scanner(System.in); //System.in is a standard input stream.
            m = input.nextInt();
        }

        if(m==0)
            n=0;
        else {
            System.out.println("y-axis: (Between 3 and 10)");
            input = new Scanner(System.in); //System.in is a standard input stream.
            n = input.nextInt();
            while (!(n >= 3 && n <= 10)) {
                System.out.println("Wrong value for y-axis! (Between 3 and 10, 0 for default");
                input = new Scanner(System.in); //System.in is a standard input stream.
                n = input.nextInt();
            }
        }

        if(m!=0) {
            System.out.println("Similar winning cells: (Between 2 and Max of y-axis and x-axis, 0 for default)");
            input = new Scanner(System.in); //System.in is a standard input stream.
            k = input.nextInt();
            if(k!=0) {
                while (!(k >= 2 && k <= Math.max(m, n))) {
                    System.out.println("Wrong value for similar winning cells! (Between 2 and Max of y-axis and x-axis, 0 for default)");
                    input = new Scanner(System.in); //System.in is a standard input stream.
                    k = input.nextInt();
                    if (k == 0)
                        break;
                }
            }
        }

        if(m==0){ // A default constructor that sets n, m, k to 3, 3, 3.
            System.out.println("Board created with "+3+"x"+3+" and similar cells is "+3);
            Game = new TicTacGame();
        } else if(k==0){ //A constructor that takes n, m, and sets the k to 3 by default.
            System.out.println("Board created with "+m+"x"+n+" and similar cells is "+3);
            Game = new TicTacGame(n,m);
        } else { // A constructor that takes n, m, k.
            System.out.println("Board created with "+m+"x"+n+" and similar cells is "+k);
            Game = new TicTacGame(n,m,k);
        }


        if(gameMode.equals("manual"))
            Game.manualMode();
        else
            Game.autoMode();

        int roundsPlayed = Game.getRoundsPlayed();

        System.out.println("Select round you want to replay from (0 to "+roundsPlayed+"): ");
        input= new Scanner(System.in); //System.in is a standard input stream.
        int roundFrom = input.nextInt();
        while (!(roundFrom>=0 && roundFrom <= roundsPlayed) ) {
            System.out.println("Wrong round value! From (0 to "+roundsPlayed+"): ");
            input= new Scanner(System.in); //System.in is a standard input stream.
            roundFrom = input.nextInt();
        }

        System.out.println("Select round you want to replay to ("+roundFrom+" to "+roundsPlayed+"): ");
        input= new Scanner(System.in); //System.in is a standard input stream.
        int roundTo = input.nextInt();
        while (!(roundTo>=roundFrom && roundTo <= roundsPlayed) ) {
            System.out.println("Wrong round value! From ("+roundFrom+" to "+roundsPlayed+"): ");
            input= new Scanner(System.in); //System.in is a standard input stream.
            roundTo = input.nextInt();
        }

        Game.playRounds(roundFrom,roundTo);
    }
}
