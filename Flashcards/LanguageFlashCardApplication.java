package Flashcards;
import java.io.IOException;
import java.util.Scanner;
/**
 * Program containing main method for language flash cards
 * @author Anish Tankala
 * @version @1.0
 */
public class LanguageFlashCardApplication {
    
    /**
     * Creates a game of language flash cards, based on words from
     * a user inputted file.
     * @param args the command line arguments
     * @see AbstractFlashCards#nextCard()
     * @see AbstractFlashCards#reset()
     * @see AbstractFlashCards#getScore()
     * @see AbstractFlashCards#hasNext()
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the filename containing your flashcards? Exact letters!");
        String file = scanner.nextLine();                       //Gets name of file with cards
        LanguageFlashCards game = new LanguageFlashCards(file); //creates language flash cards from words in file
        game.reset();                                           //intial shuffle of cards
        
        String state; 
        do {
            game.nextCard();
            if (game.hasNext() != true) {                        //ends loop when no more cards are left
                System.out.println("Good work, game over");
                break;
            }
            System.out.println("Score = " + game.getScore());
            System.out.println("Next?(Y or N)");
            state = scanner.nextLine();
        } while(state.equalsIgnoreCase("Y"));                   //keeps loop running while user input is Y or y
        
        System.out.println("You've got a score of " + game.getScore() + " so far");
    }
}
