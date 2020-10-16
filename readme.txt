   ----------------
   | Tic Tac Toe  |
   ----------------
   | Ramy ElGendi |
   |   900170269  |
   ----------------


This is an advanced Tic Tac Toe where you match k similar cells in an nxm board.
First, program will ask for picking the mode: auto for computer (o) vs player (x) OR manual for player vs player.
Then you will be asked to enter board dimensions (m and n), you can enter 0 when asking for the first dimension to use default value (3) for x and y.
If you pick a value for x, then you cannot use default value for y (this is what I concluded from the constructors asked in the question).
After picking m and n values, you will be asked for k (0 for default or any other value between 2 and Maximum of (m,n) because this is what makes sense.

After finishing input settings, the board with indices will appear to the players to know which cell is represented by which index. Then, players can play the game.
*For auto mode, Im using the method of first trying to win, then trying to block the player from winning by placing x or o accordingly in every cell and if the results of checkwinner is true, then this cell will be used.
After the game ends, you will be asked to pick a range between rounds to display the game rounds between this range so for example if 2 and 6, it will display from round 2 to round 6.

        
Main is used for class instantiation and input validation. This is what deals with the user inputs and gets them.
TicTacGame is the class of the game itself that has all of the functions and the board.