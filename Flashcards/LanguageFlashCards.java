package Flashcards;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
/**
 * Class that creates flash cards for English and French words
 * based on a file inputed by user
 * @author Anish Tankala
 * @version @1.0
 */
public class LanguageFlashCards extends AbstractFlashCards{
    private static final String COMMA_DELIMITER = ",";          //used to break string at every comma  
    private String filename;                                    //string for filename    
    
    /**
    * Constructor to create flash cards using the words from given file
    * @param filename name of file containing words
    * @throws java.io.IOException
    */
    public LanguageFlashCards(String filename)throws IOException {
        this.filename = filename;
        
        try(BufferedReader reader = new BufferedReader(new FileReader(this.filename))){
            String line;
            while((line = reader.readLine()) != null) {
                String flashLang[] = line.split(COMMA_DELIMITER);
                super.addCard(flashLang[0], flashLang[1]);       //adds the words to flash cards
            }
           
            reader.close();    
        }catch(FileNotFoundException e1) {                         
            System.err.println("File not found!");               //throws warning when file is not found
        } 
    }
}
