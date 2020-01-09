package Flashcards;
import java.util.Scanner;
/**
 * Program containing main method for multiplication flash cards
 * @author Anish Tankala
 * @version @1.0
 */
public class MultiplicationFlashCardApplication {

    /**
     * @param args the command line arguments
     * @see AbstractFlashCards#getScore()
     * @see AbstractFlashCards#nextCard()
     * @see AbstractFlashCards#reset().
     * @see AbstractFlashCards#hasNext()
     */
    public static void main(String[] args) {
        MultiplicationFlashCards game;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Which times tables would you like to test? (Between 1 and 12 inclusive)");
        String input = scanner.nextLine();                  //Gets values for times tables
        String tables [] = input.split(" ");                //Makes a string array from each value
        int values[] = new int[tables.length];
        
        for(int j = 0; j< values.length; j++) {
            values[j] = Integer.parseInt(tables[j]);        //inputs values from string array into int array
        }
        
        game = new MultiplicationFlashCards(values);        //creates flashcards usings inputted values
        game.reset();                                       //intial shuffle of cards
        
        String state; 
        do {
            game.nextCard();
            if (game.hasNext() != true) {                    //ends loop when no more cards are left
                System.out.println("Good work, game over");
                break;
            }
            System.out.println("Score = " + game.getScore());
            System.out.println("Next?(Y or N)");
            state = scanner.nextLine();
        } while(state.equalsIgnoreCase("Y"));               //keeps loop running while user's input is y or Y
        
        System.out.println("You've got a score of " + game.getScore() + " so far");
    }
}
