package SnakesandLadders;

/**
 * A class representing a Ladder Square on a SnakesAndLadder board 
 * @author Anish Tankala
 * @version 1.0
 */
public class LadderSquare extends SorLSquare{
    /**
    * Constructor initializing number to number and endSquare to endSquare
    * @param number the number of the square on the board
    * @param endSquare the number of the endSquare: the square the player moves to when they land on the square
    */
    public LadderSquare(int number, int endSquare) {
        super(number, endSquare);
        if (endSquare < number)
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
        sqNum += super.getNumber()+ "+" + super.landOn();
        return sqNum;
    }
    
    /**
    * Returns boolean value true if passed object is equal to compared object
    * @param o representing object that is being compared
    * @return boolean representing if passed object is equal to compared object 
    */
   
    public boolean equals(Object o) {
        if (o == this) return true;                   //See explanation for equals method on SnakeSquare
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        return super.equals(o);
    }
}
