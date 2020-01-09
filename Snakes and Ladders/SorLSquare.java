package SnakesandLadders;

/**
 * A class representing a square on a SnakesAndLadder board 
 * @author Anish Tankala
 * @version 1.0
 */
public class SorLSquare extends SnLSquare {
    /**
    * The number of the square where a player lands when they land on the square
    */
    private int endSquare;
    
    /**
    * Constructor initializing number to number and endSquare to endSquare
    * @param number the number of the square on the board
    * @param endSquare the number of the endSquare: the square the player moves to when they land on the square
    */
    public SorLSquare(int number, int endSquare) {
        super(number);
        if (endSquare == super.getNumber())
            throw new IllegalArgumentException ("Value of endSquare cannot be same value as number");
        this.endSquare = endSquare;
    }
    
    /**
    * Returns the endSquare value of the board
    * @return int value representing value of endSquare associated with square
    */
    public int getEndSquare() {
        return this.endSquare;
    }
    
    /**
    * Returns the number of square where player would move to after landing on the square
    * @return int value representing value of endSquare
    */
    public int landOn() {
        return this.endSquare;
    }
    
    /**
    * Returns the value of endSquare of the board as a string
    * @return string representing value of endSquare associated with square
    */
    @Override
    public String toString() {
        String sqNum = "";
        sqNum += super.toString() + ":" + getEndSquare();
        return sqNum;
    }
    
    /**
    * Returns boolean value true if passed object is equal to compared object
    * @param o representing object that is being compared
    * @return boolean representing if passed object is equal to compared object 
    */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        SorLSquare c = (SorLSquare)o;
        return (super.equals(c) && endSquare == c.endSquare);
    }
}
