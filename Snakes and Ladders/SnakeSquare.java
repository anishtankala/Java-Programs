package SnakesandLadders;

/**
 * A class representing a Snake Square on a SnakesAndLadder board 
 * @author Anish Tankala
 * @version 1.0
 */
public class SnakeSquare extends SorLSquare {
    /**
    * Constructor initializing number to number and endSquare to endSquare
    * @param number the number of the square on the board
    * @param endSquare the number of the endSquare: the square the player moves to when they land on the square
    */
    public SnakeSquare(int number, int endSquare) {
        super(number, endSquare);
        if (endSquare > number)
            throw new IllegalArgumentException ("Value of endSquare cannot be same value as number");
    }
    
    /**
    * Returns the number of square where player would move to after landing on the square
    * @return int value representing value of endSquare
    */
    public int landOn() {
        return super.getEndSquare();
    }
    
    /**
    * Returns the number of square where player would move to after landing on the square
    * @return int value representing value of endSquare
    */
    @Override
    public String toString() {
        String sqNum = "";
        sqNum += super.getNumber()+ "-" + super.landOn();
        return sqNum;
    }
    
    /**
    * Returns boolean value true if passed object is equal to compared object
    * @param o representing object that is being compared
    * @return boolean representing if passed object is equal to compared object 
    */
   
    public boolean equals(Object o) {                  //I decided to make a equals method for
        if (o == this) return true;                    //SnakeSquare and LadderSquare as it is
        if (o == null) return false;                   //always important to include this method
        if (getClass() != o.getClass()) return false;  //I made it the same as the one for SorLSquare
        return super.equals(o);                        //as they are essentially the same
    }                                                 
}                                                     
                                                        