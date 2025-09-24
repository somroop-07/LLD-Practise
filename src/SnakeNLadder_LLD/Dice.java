package SnakeNLadder_LLD;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
   private int noOfDices;
   private int minValue = 1;
   private int maxValue = 6;
   
   Dice(int noOfDices) {
	   this.noOfDices = noOfDices;
   }
   
   public int roll() {
	   int res = 0;
	   for(int i = 0; i < noOfDices; i++) {
		   res += ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
	   }
	   return res;
   }
}
