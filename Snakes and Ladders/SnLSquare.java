package SnakesandLadders;

/**
 * A class representing a square on a SnakesAndLadder board 
 * @author Anish Tankala
 * @version 1.0
 */
public class SnLSquare {
    /**
    * The number of the square
    */
    private int number;
    
    /**
    * Constructor initializing number to number
    * @param number the number of the square on the board
    */
    public SnLSquare(int number) {
        this.number = number;
    }
    
    /**
    * Returns the number of the board
    * @return int value representing value of number associated with square
    */
    public int getNumber() {
        return this.number;
    }
    
    /**
    * Returns the number of where player would land on board
    * @return int value representing value of number on board player lands
    */
    public int landOn() {
        return this.number;
    }
    
    /**
    * Returns the number of the board as a string
    * @return string representing value of number associated with square
    */
    @Override
    public String toString() {               //converts square value to a string
        String sqNum = "";
        sqNum = sqNum + getNumber();
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
        SnLSquare c = (SnLSquare)o;
        return (this.number == c.number);
    }
}
