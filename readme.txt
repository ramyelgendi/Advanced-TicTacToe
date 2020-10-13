   ----------------
   | Tic Tac Toe  |
   ----------------
   | Ramy ElGendi |
   |   900170269  |
   ----------------


The Tic Tac Toe has been designed using the MVC, and computer will decide the best move to win/stop user from winning/random move.


Board Class:
=============
This is the model class. It contains methods used to create and access the Game board, and check which player can win. The game board is private and can be accessed only through functions in the class, or getGameBoard() method to use outside of the class.

        
Methods:
--------
* newBoard - Creates a new board and initializes it with indices from 1 to 9.
* Taken - Takes an index and checks whether this cell has been used or not.
* Set - Takes an index and the letters X/O and places them in the cell with this index.
* getGameBoard - Returns the game board.
* ComputerPlay - Finds the best move for the computer. First it checks if the computer can win then it checks how can the computer prevent the user from playing. If its neither of these cases it makes a random move using ComputerMoveRand() method.
* ComputerMoveRand - Makes the computer play a random index using a random function and makes sure that this index is not taken.
* CheckWinner - Checks whether the round ended up with a winner or not. If all of the cells are taken, then it counts the round as a Draw. This function has 3 returns: (X - User won) (O - Computer won) (D - Its a draw) (C - Continue player, no winner yet)


Controller Class:
=================
This class has instances from Board class and View class to glue and use them together. It has one method only called play.
This method first instantiates the board class in board and the view class in view. It creates a new board then prints the introduction to the screen and the new board created with indices. Then it will loop until a winner is decided (according to the CheckWinner function in board class). While looping, it asks the user to play using the letter X, then loops on the player's choice of index and makes sure that his input is between 1 and 9, and not taken. Then it places the letter X in the cell with the index and moves on to the computer's turn. When the game ends, it prints out the board and who won.


View Class:
===========
This class is responsible for anything printed to the user or any data retrieved from the user.

Methods:
--------
* Intro - Prints an introduction to get the user familiar with the program.
* GetInp - Takes the input from the user and makes sure that it is valid.
* Taken - Prints an error if the input is taken, and calls the GetInp function to make the user pick another index.
* PrintGameBoard - Prints the board with its cells.
* TurnIdent - Identifies whether it is the player's turn or user's turn and prints a message accordingly.
* PrintWinner - Prints a message to show whether the player or the computer won or its a draw. It prints an error message if the game ends with an error.

========
Imports:
========
* import java.util.Arrays - To create the board.
* import java.util.InputMismatchException - To handle input errors.
* import java.util.Scanner - To read/write from user.
* import java.util.Random - To generate random number for ComputerPlay.