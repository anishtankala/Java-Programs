package SnakesandLadders;
import java.util.Scanner;

/**
 * This program creates and plays a game of Snakes and Ladders 
 * for an amount of players entered by the user.
 * @author Anish Tankala
 * @version 1.0
 */
public class SnakesAndLadders {    
    public final static int NUM_PLAYERS = 2; //default number of players
    public static int NUM_SQUARES = 101;     //number of squares 
    private Dice dice = new Dice();          //dice for rolling
    private int players[];                   //array of players
    private SnLSquare board[];               //squares of the game board    
    /**
    * Default constructor initializing the 2 player positions to 1 and 
    * set all indices of board to SnLSquares, the appropriate squares 
    * are then set to ladder squares or snake squares. 
    */ 
    public SnakesAndLadders() {
        players = new int [NUM_PLAYERS];
        players[0] = 1;
        players[1] = 1;
        
        board = new SnLSquare[NUM_SQUARES];
        int k = 1;
        while(k < NUM_SQUARES) {
            board[k] = new SnLSquare(k);
            k++;
        }

        this.board[4] = new LadderSquare(4, 14);
        this.board[9] = new LadderSquare(9, 31);
        this.board[20] = new LadderSquare(20, 38);
        this.board[28] = new LadderSquare(28, 84);
        this.board[40] = new LadderSquare(40, 59);
        this.board[63] = new LadderSquare(63, 81);
        this.board[71] = new LadderSquare(71, 91);
        
        this.board[17] = new SnakeSquare(17, 7);
        this.board[54] = new SnakeSquare(54, 34);
        this.board[62] = new SnakeSquare(62, 18);
        this.board[64] = new SnakeSquare(64, 60);
        this.board[87] = new SnakeSquare(87, 24);
        this.board[93] = new SnakeSquare(93, 73);
        this.board[95] = new SnakeSquare(95, 75);
        this.board[99] = new SnakeSquare(99, 78);
    }
    
    /**
    * Constructor to set the number of user-entered players to position 1 and 
    * set all indices of board to SnLSquares, the appropriate squares are then 
    * set to ladder squares or snake squares.
    * @param nPlayers number of players in the game
    */
    public SnakesAndLadders(int nPlayers) {
        if (nPlayers < 1)
            throw new IllegalArgumentException ("Cannot be less than 2 players");
        players = new int [nPlayers];
        
        for(int j = 0; j < players.length; j++){
            this.players[j] = 1; 
        }
        
        board = new SnLSquare[NUM_SQUARES];
        int k = 1;
        while(k < NUM_SQUARES) {
            board[k] = new SnLSquare(k);
            k++;
        }
        
        this.board[4] = new LadderSquare(4, 14);
        this.board[9] = new LadderSquare(9, 31);
        this.board[20] = new LadderSquare(20, 38);
        this.board[28] = new LadderSquare(28, 84);
        this.board[40] = new LadderSquare(40, 59);
        this.board[63] = new LadderSquare(63, 81);
        this.board[71] = new LadderSquare(71, 91);
        
        this.board[17] = new SnakeSquare(17, 7);
        this.board[54] = new SnakeSquare(54, 34);
        this.board[62] = new SnakeSquare(62, 18);
        this.board[64] = new SnakeSquare(64, 60);
        this.board[87] = new SnakeSquare(87, 24);
        this.board[93] = new SnakeSquare(93, 73);
        this.board[95] = new SnakeSquare(95, 75);
        this.board[99] = new SnakeSquare(99, 78);
    }
    
    /**
    * Returns the boolean true if Dice's hasDoubles() is true, 
    * returns false otherwise; calculates the value of players
    * new position based on SorLSquare's landOn().
    * @param player player number
    * @return a boolean value representing the boolean value of hasDoubles()
    * @see Dice#hasDoubles() 
    * @see SorLSquare#landOn()
    */
    public boolean takeTurn(int player) {
        SnakeSquare snakeSample = new SnakeSquare(101, 1);
        LadderSquare ladderSample = new LadderSquare(1, 101);
        int temp;
        int newPosition;
        int currPosition;
        int roll = dice.roll();
        
        if(roll + players[player] < 100){
            currPosition = board[roll + players[player]].getNumber();
            if (snakeSample.getClass() == board[currPosition].getClass()) {
                System.out.println("Oh no!");
            }
            if (ladderSample.getClass() == board[currPosition].getClass()) {
                System.out.println("Yay!");
            }
        }
        
        System.out.println("Player " + player + " rolled " + roll);
        
        if (players[player] + roll > 100){
            temp = (roll + players[player]) - 100;
            players[player] = 100 - temp;
        }
        else {
            newPosition = board[roll + players[player]].landOn();
            players[player] = newPosition;
        }
        
        return dice.hasDoubles() == true;
    }
    
    /**
    * Finds out if entered player number is a winner by checking position.
    * @param player player number
    * @return a boolean value representing whether a players position is at 100
    */
    public boolean isPlayerWinner(int player) {
        return (players[player] == 100);
    }
    
    /**
    * Finds out which player out of the players that were generated is the winner,
    * by using SnakesAndLadder's isPlayerWinner.
    * @return an int value representing the player that has won
    * @see SnakesAndLadders#isPlayerWinner(int) 
    */
    public int getWinner() {
        int winner = -1;
        for(int i = 0; i < players.length; i++){
            if (isPlayerWinner(players[i]) == true)
                winner = i;
        }
        return winner;
    }
    
    /**
    * Returns the position of a given player.
    * @param player player number
    * @return an int value representing the position of a player
    */
    public int getPlayerPosition(int player) {
        return players[player];
    }
    
    /**
    * Returns a visual representation of the Snakes and Ladders game board.
    * @return a string that shows the game board
    */
    @Override
    public String toString(){
        String gameBoard = "| 1 | 2 | 3 | 4+14 | 5 | 6 | 7 | 8 | 9+31 | 10 \n"
            + "| 11 | 12 | 13 | 14 | 15 | 16 | 17-7 | 18 | 19 | 20+38 \n"
            + "| 21 | 22 | 23 | 24 | 25 | 26 | 27 | 28+84 | 29 | 30 \n"
            + "| 31 | 32 | 33 | 34 | 35 | 36 | 37 | 38 | 39 | 40+59 \n"
            + "| 41 | 42 | 43 | 44 | 45 | 46 | 47 | 48 | 49 | 50 \n"
            + "| 51 | 52 | 53 | 54-34 | 55 | 56 | 57 | 58 | 59 | 60\n"
            + "| 61 | 62-18 | 63+81 | 64-60 | 65 | 66 | 67 | 68 | 69 | 70 \n"
            + "| 71+91 | 72 | 73 | 74 | 75 | 76 | 77 | 78 | 79 | 80 \n"
            + "| 81 | 82 | 83 | 84 | 85 | 86 | 87 | 88 | 89 | 90 \n"
            + "| 91 | 92 | 93-73 | 94 | 95-75 | 96 | 97 | 98 | 99-78 | 100"
            + "";
        return gameBoard;
    }
    
    /**
    * Returns the number of each player and their respective position
    * on the game board; uses SnakesAndLadder's getPlayerPosition.
    * @return a string representing the player numbers and their positions
    * @see SnakesAndLadders#getPlayerPosition(int) 
    */
    public String toStringCurrentPositions() {
        int i = 0;
        String position = "";
        while(i < players.length) {
            position += i + ":" + getPlayerPosition(i) + " ";
            i++;
        }
        return position;
    }
    
   /**
     * Creates a Snakes and Ladders game with an amount of players based 
     * on user-input; Outputs game board using SnakesAndLadder's toString,
     * and outputs position of all players after each turn using
     * SnakesAndLadder's toStringCurrentPositions, Checks for winner using
     * SnakesAndLadder's isPlayerWinner.
     * @param args the command line arguments
     * @see SnakesAndLadders#toString()
     * @see SnakesAndLadders#toStringCurrentPositions()
     * @see SnakesAndLadders#isPlayerWinner(int)
     */
    public static void main(String[] args) {
        System.out.println("Enter number of players!");
        Scanner scanner = new Scanner(System.in);
        int numPlayers = scanner.nextInt();                      //number of players given from scanner 
        
        SnakesAndLadders SNL = new SnakesAndLadders(numPlayers); //new game based on number of players
        System.out.println("Snakes and Ladders");
        System.out.println(SNL.toString());                      //prints out game board
        System.out.println();
        
        int check = 0;                                           //keeps loop running until winner is found
        while(check != -1) {
            while(SNL.takeTurn(check)) {
                System.out.println(SNL.toStringCurrentPositions());
            }
            System.out.println(SNL.toStringCurrentPositions());
            if(SNL.isPlayerWinner(check)) {
                System.out.println("Player " + check + " wins!");
                check = -1;
            }
            else{
                if(check == numPlayers - 1)
                    check = 0;
                else
                    check++;
            }
        }
    }
}
