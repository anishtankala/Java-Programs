package Flashcards;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.*;
/**
 * Abstract class for creating flash cards 
 * @author Anish Tankala
 * @version @1.0
 */
public abstract class AbstractFlashCards {
    private HashMap<String, String> flashCards;                     //hashmap of flash cards
    private ArrayList<String> unansweredCards;                      //arraylist of unanswered questions
    private int score;                                              //int to keep score
    private Scanner scanner;                                        //scanner for scanning user input
    private Random random;                                          //random for randomising when shuffling cards
    
    /**
    * Default constructor declaring all variables
    */
    public AbstractFlashCards() {
        this.score = 0;
        this.flashCards = new HashMap<String, String>();
        this.unansweredCards = new ArrayList<String>();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }
    
    /**
    * Adds new cards using question and answers from parameters
    * @param ques the question of the card
    * @param ans the answer of the question for this card
    */
    protected void addCard(String ques, String ans) {
        flashCards.put(ques, ans);
        unansweredCards.add(ques);
    }
    /**
    * Returns score of player
    * @return integer value representing score of player
    */
    public int getScore() {
        return this.score;
    }
    
    /**
    * Resets unansweredCards array list into a randomly reordered set of questions
    */
    public void reset() {
        String copykeys[] = flashCards.keySet().toArray(new String[flashCards.size()]);
        unansweredCards.clear();
        for(int c = 0; c < copykeys.length; c++ ){                       //for loop used to shuffle questions
            int change = c + random.nextInt(copykeys.length - c);
            String helper = copykeys[c];
            copykeys[c] = copykeys[change];
            copykeys[change] = helper;
        }
        unansweredCards = new ArrayList<>(Arrays.asList(copykeys));
    }
    
    /**
     * Get the next card in the flash cards and checks whether answer is correct or not
     * @return a boolean that returns true unless there are no more cards left
     */
    public boolean nextCard() { 
        System.out.println(unansweredCards);
        
        if (hasNext()) {
            System.out.println(unansweredCards.get(0));
        
            String answer = scanner.nextLine();
            if(Objects.equals(answer, flashCards.get(unansweredCards.get(0)))) {
                System.out.println("Correct answer!");
                score++;
                unansweredCards.remove(0);
                return true;
            }
            else {
                System.out.println("Sorry, please try again");
                String temp = unansweredCards.get(0);
                unansweredCards.remove(0);
                unansweredCards.add(random.nextInt(unansweredCards.size()), temp);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if all questions have been answered or not
     * @return a boolean value that is true if there are cards left to answer and false if there are not
     */
    public boolean hasNext() {
        return(unansweredCards.isEmpty() != true);
    }
}