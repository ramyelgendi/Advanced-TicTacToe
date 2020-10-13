/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Game {   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller ctrl = new Controller();
        ctrl.play();
    }
       
}

class Board {
               private char[] Gameboard;

               void newBoard(){
                   Gameboard = new char[9];
                   for (int i = 0; i < 9; i++) {   // To convert the integer "i" into string value and intitialize the board
           Gameboard[i] = (char)(i+1+'0');
                   }
               }

               boolean Taken (int index){


                    if (Gameboard[index-1] == (char)(index+'0'))
                      return false;
                    else
                        return true;
               }
               void Set(int index,char letter){
                   Gameboard[index-1] = letter;
               }

               char[] getGameBoard() {
       return Gameboard;
               }

               void ComputerPlay() {
                   char val1,val2;
                   for(int t = 0; t<2;t++) {
                       if(t == 0) {
                           val1 = 'O';
                           val2 = 'O';
                       } else {
                           val1 = 'O';
                           val2 = 'X';
                       }
                  if(Gameboard[0] == val2 && Gameboard[1] == val2 && Gameboard[2] == '3') {
                       Gameboard[2] = val1; return; }
                   if(Gameboard[0] == val2 && Gameboard[2] == val2 && Gameboard[1] == '2') {
                       Gameboard[1] = val1; return; }
                   if(Gameboard[0] == val2 && Gameboard[8] == val2 && Gameboard[4] == '5') {
                       Gameboard[4] = val1; return; }
                   if(Gameboard[0] == val2 && Gameboard[4] == val2 && Gameboard[8] == '9') {
                       Gameboard[8] = val1; return; }
                   if(Gameboard[0] == val2 && Gameboard[3] == val2 && Gameboard[6] == '7') {
                       Gameboard[6] = val1; return; }
                   if(Gameboard[0] == val2 && Gameboard[6] == val2 && Gameboard[3] == '4') {
                       Gameboard[3] = val1; return; }

                   if(Gameboard[1] == val2 && Gameboard[2] == val2 && Gameboard[3] == '4') {
                       Gameboard[3] = val1; return; }
                   if(Gameboard[1] == val2 && Gameboard[7] == val2 && Gameboard[4] == '5') {
                       Gameboard[4] = val1; return; }
                   if(Gameboard[1] == val2 && Gameboard[4] == val2 && Gameboard[7] == '8') {
                       Gameboard[7] = val1; return; }

                   if(Gameboard[2] == val2 && Gameboard[5] == val2 && Gameboard[8] == '9') {
                       Gameboard[8] = val1; return; }
                   if(Gameboard[2] == val2 && Gameboard[8] == val2 && Gameboard[5] == '6') {
                       Gameboard[5] = val1; return; }
                   if(Gameboard[2] == val2 && Gameboard[4] == val2 && Gameboard[6] == '7') {
                       Gameboard[6] = val1; return; }
                   if(Gameboard[2] == val2 && Gameboard[6] == val2 && Gameboard[4] == '5') {
                       Gameboard[4] = val1; return; }

                   if(Gameboard[3] == val2 && Gameboard[6] == val2 && Gameboard[0] == '1') {
                       Gameboard[0] = val1; return; }
                   if(Gameboard[3] == val2 && Gameboard[4] == val2 && Gameboard[5] == '6') {
                       Gameboard[5] = val1; return; }

                   if(Gameboard[4] == val2 && Gameboard[5] == val2 && Gameboard[3] == '4') {
                       Gameboard[3] = val1; return; }
                   if(Gameboard[3] == val2 && Gameboard[5] == val2 && Gameboard[4] == '5') {
                       Gameboard[4] = val1; return; }
                   if(Gameboard[4] == val2 && Gameboard[7] == val2 && Gameboard[1] == '2') {
                       Gameboard[1] = val1; return; }
                   if(Gameboard[4] == val2 && Gameboard[6] == val2 && Gameboard[2] == '3') {
                       Gameboard[2] = val1; return; }

                       if(Gameboard[5] == val2 && Gameboard[8] == val2 && Gameboard[2] == '3') {
                       Gameboard[2] = val1; return; }

                   if(Gameboard[6] == val2 && Gameboard[7] == val2 && Gameboard[8] == '9') {
                       Gameboard[8] = val1; return; }
                   if(Gameboard[6] == val2 && Gameboard[8] == val2 && Gameboard[7] == '8') {
                       Gameboard[7] = val1; return; }
                   if(Gameboard[7] == val2 && Gameboard[8] == val2 && Gameboard[6] == '7') {
                       Gameboard[6] = val1; return; }
                   }

                   ComputerMoveRand();


               }
               void ComputerMoveRand() {
                   while(true) {
                   Random rand = new Random();
                   int  randomNum = rand.nextInt((8 - 0) + 1) + 0;
                       if(Gameboard[randomNum] == ((char)(randomNum+1+'0'))){
                           Gameboard[randomNum] = 'O';
                           break;
                       }
                   }
               }
                   char checkWinner() {

                       if(Gameboard[0] == Gameboard[1] && Gameboard[0] == Gameboard[2])
                           return Gameboard[0];


                       if(Gameboard[3] == Gameboard[4] && Gameboard[3] == Gameboard[5])
                           return Gameboard[3];


                       if(Gameboard[6] == Gameboard[7] && Gameboard[6] == Gameboard[8])
                           return Gameboard[6];

                       if(Gameboard[0] == Gameboard[3] && Gameboard[0] == Gameboard[6])
                           return Gameboard[0];

                       if(Gameboard[1] == Gameboard[4] && Gameboard[1] == Gameboard[7])
                           return Gameboard[1];

                       if(Gameboard[2] == Gameboard[5] && Gameboard[2] == Gameboard[8])
                           return Gameboard[2];

                       if(Gameboard[0] == Gameboard[4] && Gameboard[0] == Gameboard[8])
                           return Gameboard[0];

                       if(Gameboard[2] == Gameboard[4] && Gameboard[2] == Gameboard[6])
                           return Gameboard[2];

                       int a;
       for (a = 0; a < 9; a++) {
           if (Gameboard[a] == ((char)(a+1+'0'))) {
               break;
           }

       } if (a == 9) return 'D';

               return 'C';
   }
}

 class Controller {

    /**
     * @param args the command line arguments
     */
    public void play() {
        Board board = new Board();
        View view = new View();
        
        char letter = 'X';
        char winner = 'C';
        board.newBoard();
        
        view.Intro();
        char[] Gameboard = board.getGameBoard();
        view.PrintGameBoard(Gameboard);
        
        boolean flag;
        while(winner == 'C' ) {
            if(board.checkWinner() == 'D')
                break;
            
            view.TurnIdent(letter);
            if (letter == 'X') {
            int numInput = view.GetInp();
            flag = true;
            while(flag) {
                if(!board.Taken(numInput))
                    flag = false;
                else
                    numInput = view.Taken();
            }
                board.Set(numInput, letter);
            }else 
                board.ComputerPlay();
            
            if (letter == 'X')
                    letter = 'O';
            else
                    letter = 'X';            
            
            view.PrintGameBoard(Gameboard);
            
            winner = board.checkWinner();
            }
        view.PrintWinner(winner);
        
            
        }

    }
   class View {
    	static Scanner in;
    
    void Intro(){
        System.out.println("Welcome to Player VS Computer Tic Tac Toe.");
        System.out.println("------------------------------------------");
        System.out.println("Player will be X, Computer will be O.");
        System.out.println("You choose your location by entering its index.");
//        System.out.println("The X shall begin.");
}
    int GetInp() {
        boolean bug = true;
        int numInput = 0;
        while(bug) {
        in = new Scanner(System.in);
        try {
            numInput = in.nextInt();
            if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
            }
          } catch (InputMismatchException e) {
            System.out.println("Invalid input; re-enter slot number:");
            continue;
            }
        bug = false;
        }
        return numInput;
    }
    int Taken() {
        	System.out.println("Slot already taken; re-enter slot number:");
        return GetInp();
    }
    
    void PrintGameBoard(char[] Board) {
                System.out.println("=============");
		System.out.println("| " + Board[0] + " | " + Board[1] + " | " + Board[2] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + Board[3] + " | " + Board[4] + " | " + Board[5] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + Board[6] + " | " + Board[7] + " | " + Board[8] + " |");
		System.out.println("=============");
	}
            
        void TurnIdent(char letter) {
	if(letter == 'X') {
            System.out.println("-----------------");
            System.out.println("Player's Turn: ");
        }
        else if (letter == 'O') {
            System.out.println("-----------------"); 
            System.out.println("Computer's Turn: ");}
	}
        void PrintWinner(char winner){
            if(winner == 'X')
                System.out.println("X has won!");
            else if (winner == 'O')
                System.out.println("O has won!");
            else if (winner == 'D')
                System.out.println("Noone has won!");
            else
                System.out.println("ERROR AT FINDING RESULTS!");
}
}
