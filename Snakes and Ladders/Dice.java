/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakesandLadders;

/**
 *
 * @author Anish
 */
import java.util.Random;
import java.util.Date;

public class Dice{
    private int[] die;
    private Random random = new Random(new Date().hashCode());
    private int numDice;
    
    private int rollDice(){  //rolls dice
        return random.nextInt(6) + 1;
    }
    
    public Dice(){ //dice constructor
        this.die = new int[2];
        for(int c = 0; c < this.die.length; c++)
            this.die[c] = rollDice();
    }
    
     public Dice(int numDice){ //dice constructor
        this.numDice = numDice; 
        if (this.numDice < 1)
            throw new IllegalArgumentException ("Cannot have less than one dice, re-enter number of dice");
        this.die = new int[this.numDice];
        for(int c = 0; c < this.die.length; c++){
            this.die[c] = rollDice();
        }
    }
    
    public Dice(Dice x){
        x.die = this.die;
    }
   
    public int[] getDieValues(){ //returns die values that are copied into an array
        int [] dieCopy = new int[this.die.length];
        for (int i = 0; i < this.die.length; i++)
            dieCopy[i] = this.die[i];
        return dieCopy;
    }
   
    public boolean hasDoubles(){ //checks for doubles
        int k, j;
        for (k = 0; k < this.die.length; k++){
            for (j = k + 1; j < this.die.length; j++){
                if (this.die[k] == this.die[j])
                    return true;
            }
        }
        return false;  
    }
    
    public int roll(){ //rolls all dice and returns total
        int dieTotal = 0;
        for (int h = 0; h < this.die.length; h++){
            this.die[h] = rollDice();
            dieTotal += this.die[h];
        }
        return dieTotal;
    }
    
    @Override
    public String toString() { //converts dice values to a string
        String result = "";
        for(int i = 0; i < die.length; i++){
           result = result + String.valueOf(die[i]) + " ";
        }
        return result;
    }
}