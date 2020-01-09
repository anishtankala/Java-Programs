package Flashcards;
/**
 * Class that creates flash cards for multiplication
 * based on values from user input(between 1 to 12).
 * @author Anish Tankala
 * @version @1.0
 */
public class MultiplicationFlashCards extends AbstractFlashCards {
    /**
     * Creates multiplication flash cards when given one value
     * @param multipliers value for times table
     */
    public MultiplicationFlashCards(int multipliers) {
        for(int z = 1; z <= 12; z++) {
            String answer = Integer.toString(multipliers*z);
            String question = Integer.toString(multipliers) + "x" + z;
            super.addCard(question, answer);
        }
    }
    
    /**
     * Creates multiplication flash cards when given an array of values
     * @param multipliers array of values for times tables
     */
    public MultiplicationFlashCards(int multipliers[]) {
        for(int y = 0; y < multipliers.length; y++) {
            for(int z = 1; z <= 12; z++) {
                String answer = Integer.toString(multipliers[y]*z);
                String question = Integer.toString(multipliers[y]) + "x" + z;
                super.addCard(question, answer);
            }
        }
    }  
 }