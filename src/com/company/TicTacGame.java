package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacGame {
    // Global Variables
    enum state{WIN_X,WIN_O,INPROGRESS,DRAW}
    enum cell{X,O,EMPTY}
    static ArrayList<ArrayList<ArrayList<cell>>> board;
    static int m,n,k;
    int totalRounds,roundsPlayed;
    static state boardState;

    // Setters & Getters
    public static int getM() {
        return m;
    }

    public static void setM(int m) {
        TicTacGame.m = m;
    }

    public static int getN() {
        return n;
    }

    public static void setN(int n) {
        TicTacGame.n = n;
    }

    public static int getK() {
        return k;
    }

    public static void setK(int k) {
        TicTacGame.k = k;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public void setTotalRounds(int totalRounds) {
        this.totalRounds = totalRounds;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    public static state getBoardState() {
        return boardState;
    }

    public static void setBoardState(state boardState) {
        TicTacGame.boardState = boardState;
    }

    // Constructors
    public TicTacGame(int n,int m, int k) {
        TicTacGame.n = n;
        TicTacGame.m = m;
        TicTacGame.k = k;

        totalRounds = m*k+1;

        board = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            board.add(new ArrayList<>(n));
            for (int j = 0; j < n; j++) {
                board.get(i).add(new ArrayList<>(totalRounds));
            }
        }
        initializeBoard();
    }
    public TicTacGame(int n,int m) {
        TicTacGame.n = n;
        TicTacGame.m = m;
        TicTacGame.k = 3;

        totalRounds = m*k+1;

        board = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            board.add(new ArrayList<>(n));
            for (int j = 0; j < n; j++) {
                board.get(i).add(new ArrayList<>(totalRounds));
            }
        }
        initializeBoard();
    }
    public TicTacGame() {
        TicTacGame.n = 3;
        TicTacGame.m = 3;
        TicTacGame.k = 3;

        totalRounds = m*k+1;

        board = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            board.add(new ArrayList<>(n));
            for (int j = 0; j < n; j++) {
                board.get(i).add(new ArrayList<>(totalRounds));
            }
        }
        initializeBoard();
    }

    // Printing the board without indices
    void printBoard(int round){
        for(int t=0;t<m;t++)
            System.out.print("------");
        System.out.print("\n");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if(board.get(i).get(j).get(round) != cell.EMPTY)
                    System.out.print(String.format(" %-2s", board.get(i).get(j).get(round)) + " | ");
                else
                    System.out.print("    | ");
            System.out.print("\n");
            for(int t=0;t<m;t++)
                System.out.print("------");
            System.out.print("\n");

        }
    }

    // A method to get which player is next to make a turn
    cell nextPlayer(cell Player){
        if(Player==cell.X)
            return (cell.O);
        else return(cell.X);
    }

    // A method to initialize the board with empty cells
    void initializeBoard(){
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                board.get(i).get(j).add(0, cell.EMPTY);
            }
    }

    // Printing the board without indices
    void printBoardIndices(){
        int count = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format(" %-2s", count) + " | ");
                count++;
            }
            System.out.print("\n");
            for(int t=0;t<m;t++)
                System.out.print("------");
            System.out.print("\n");

        }
    }
    boolean play(int index,int round,cell Player){ // Plays X or O, and copies the indices to next round in arraylist
        int[] location = FindIndices(index);
        if(location[0] == -1 && location[1] == -1) {
            System.out.println("Cell does not exist!");
            return true;
        } else if(board.get(location[0]).get(location[1]).get(round - 1) == cell.X || board.get(location[0]).get(location[1]).get(round - 1) == cell.O){
            System.out.println("Cell is already used!");
            return true;
        } else {
            board.get(location[0]).get(location[1]).add(round, Player);
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if(!(i == location[0] && j==location[1])){
                        board.get(i).get(j).add(round, board.get(i).get(j).get(round - 1));
                    }

            return false;
        }
    }
    int[] FindIndices(int index){
        int count = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                try {
                    if(count == index)
                        return new int[]{i, j};
                    else
                        count++;
                }catch(Exception e){
                    return new int[] {-1,-1};
                }
        }
        return new int[] {-1,-1};
    }

    int ValidateIndex(){
        Scanner sc = new Scanner(System.in);
        int index;
        do {
            System.out.print("Enter Valid Cell Number (1-"+n*m+"): ");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a valid cell!");
                sc.next(); // this is important!
            }
            index = sc.nextInt();
        } while (index == 0);

        return index;
    }

    boolean checkWinner(int round,int index,cell Player){
        if(checkVertically(index,round,Player))
            return true;
        if(checkHorizontally(index,round,Player))
            return true;
        if(checkDiagNegative(round,Player))
            return true;
        return checkDiagPositive(round, Player);
    }
    boolean checkVertically(int index,int round, cell Player){
        int[] location = FindIndices(index);
        int counter = 0;
        for(int i = 0; i < m; i++){
            if(board.get(i).get(location[1]).get(round) ==Player)
                counter++;
            else
                counter=0;

            if(counter == k){
                return true;
            }
        }
        return false;
    }
    boolean checkHorizontally(int index,int round, cell Player){
        int[] location = FindIndices(index);
        int counter = 0;

        for(int i = 0; i < n; i++){
            if(board.get(location[0]).get(i).get(round)==Player)
                counter++;
            else
                counter=0;
            if(counter == k){
                return true;
            }
        }
        return false;
    }
    boolean checkDiagPositive(int round,cell Player){
        int counter = 0;
        for (int z=0;z<m;z++) {
            for (int i = 0; i < m; i++) {
                try {
                    if(board.get(i).get(m-i-1+z).get(round)==Player)
                        counter++;
                    else
                        counter = 0;
                }catch (Exception ignored){}


                if (counter == k) {
                    return true;
                }
            } counter=0;
            for (int j = 0; j < n;  j++) {
                try {
                    if(board.get(j).get(m-j-1-z).get(round)==Player)
                        counter++;
                    else
                        counter = 0;
                }catch (Exception ignored){}


                if (counter == k) {
                    return true;
                }
            } counter=0;
        }
        return false;
    }
    boolean checkDiagNegative(int round,cell Player){
        int counter = 0;
        for (int z=0;z<m;z++) {
            for (int i = 0, j = 0; i < m && j < n; i++, j++) {
                try {
                    if (board.get(i).get(j+z).get(round)==Player)
                        counter++;
                    else
                        counter = 0;
                }catch (Exception ignored){}


                if (counter == k) {
                    return true;
                }
            } counter=0;
            for (int i = 0, j = 0; i < m && j < n; i++, j++) {
                try {
                    if (board.get(i+z).get(j).get(round)==Player)
                        counter++;
                    else
                        counter = 0;
                }catch (Exception ignored){}


                if (counter == k) {
                    return true;
                }
            } counter=0;
        }
        return false;
    }
    void manualMode(){
        cell Player = cell.O; // Initial O, which means X will begin
        setBoardState(state.INPROGRESS);
        printBoardIndices();
        System.out.println(" ");
        int round,index;
        for(round=1;round<totalRounds;round++){
            roundsPlayed = round;
            Player = nextPlayer(Player);

            System.out.println("==================================");
            System.out.println("Round "+round+", Player "+Player+"'s turn");
            index = ValidateIndex();

            while (play(index, round, Player))
                index = ValidateIndex();


            printBoard(round);
            if(checkWinner(round,index,Player)) {
                if(Player==cell.X)
                    setBoardState(state.WIN_X);
                else
                    setBoardState(state.WIN_O);
                break;
            }
        }
        if(boardState==state.INPROGRESS)
            setBoardState(state.DRAW);

        switch (boardState){
            case DRAW -> System.out.println("\n** Match ended as a draw. **");
            case WIN_O -> System.out.println("\n** Player O has won! **");
            case WIN_X -> System.out.println("\n** Player X has won! **");
            default -> System.out.println("\n** Game failed. **");

        }
    }
    int getComputerIndex(int round){
        Random rand = new Random();
        int count = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                count++;
                if (board.get(i).get(j).get(round-1) == cell.EMPTY) {
                    board.get(i).get(j).set(round-1, cell.O);
                    if (checkWinner(round-1, count, cell.O)) {
                        board.get(i).get(j).set(round-1, cell.EMPTY);
                        return count;
                    }else
                        board.get(i).get(j).set(round-1, cell.EMPTY);
                }
            }
        }
        count =0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                count++;
                if (board.get(i).get(j).get(round-1) == cell.EMPTY) {
                    board.get(i).get(j).set(round-1, cell.X);
                    if (checkWinner(round-1, count, cell.X)) {
                        board.get(i).get(j).set(round-1, cell.EMPTY);
                        return count;
                    }else
                        board.get(i).get(j).set(round-1, cell.EMPTY);
                }
            }
        }

        return rand.nextInt(totalRounds);
    }
    void autoMode(){
        cell Player = cell.O; // Initial O, which means X will begin
        setBoardState(state.INPROGRESS);
        printBoardIndices();
        System.out.println(" ");
        int round,index;
        for(round=1;round<totalRounds;round++){
            roundsPlayed = round;
            Player = nextPlayer(Player);

            index = 0;
            System.out.println("==================================");
            System.out.println("Round "+round+", Player "+Player+"'s turn");
            if(Player==cell.X) {
                index = ValidateIndex();
                while (play(index, round, Player))
                    index = ValidateIndex();
            }
            else {
                index = getComputerIndex(round);
                while (play(index, round, Player))
                    index = getComputerIndex(round);
            }


            printBoard(round);
            if(checkWinner(round,index,Player)) {
                if(Player==cell.X)
                    setBoardState(state.WIN_X);
                else
                    setBoardState(state.WIN_O);
                break;
            }
        }
        if(boardState==state.INPROGRESS)
            setBoardState(state.DRAW);

        switch (boardState){
            case DRAW -> System.out.println("\n** Match ended as a draw. **");
            case WIN_O -> System.out.println("\n** Player O has won! **");
            case WIN_X -> System.out.println("\n** Player X has won! **");
            default -> System.out.println("\n** Game failed. **");

        }
    }
    void playRounds(int roundFrom,int roundTo){
        System.out.println("\nPlaying Rounds....");
        for(int t=roundFrom;t<roundTo+1;t++) {
            System.out.println("Round "+t);
            printBoard(t);
        }
    }
}
