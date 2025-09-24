package SnakeNLadder_LLD;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
   int size;
   Cell[][] cells;
   
    public Board(int size) {
	super();
	this.size = size;
	initializeBoard();
   }
    
    public void initializeBoard() {
    	cells = new Cell[size][size];
    	
    	for(int i = 0; i < size; i++) {
    		for(int j = 0; j < size; j++) {
    			cells[i][j] = new Cell();
    		}
    	}
    	
    } 
    
      public void addSnakes(int snakeCount) {
		int cnt = 0;
		while(cnt < snakeCount) {
			int end = ThreadLocalRandom.current().nextInt(0, size * size - 2);
			int start = ThreadLocalRandom.current().nextInt(end + 1, size * size - 1);
			Jump jump = new Jump(start, end);
			
			Cell cell = getCell(start);
			cell.setJump(jump);
			System.out.println("Snake starting from " + start + " and ending at " + end);
			cnt++;
		}
	}
      
      public void addLadders(int snakeCount) {
  		int cnt = 0;
  		while(cnt < snakeCount) {
  			int start = ThreadLocalRandom.current().nextInt(0, size * size - 2);
  			int end = ThreadLocalRandom.current().nextInt(start + 1, size * size - 1);
  			Jump jump = new Jump(start, end);
  			
  			Cell cell = getCell(start);
  			cell.setJump(jump);
  			cnt++;
  			System.out.println("Ladder starting from " + start + " and ending at " + end);
  		}
  	}
      
      public int validate(int position) {
    	  Cell cell = getCell(position);
    	  if(cell.getJump() != null) {
    		  if(cell.getJump().getEnd() > cell.getJump().getStart()) {
    			  System.out.println("Ladder!");
    		  }
    		  else {
    			  System.out.println("Snake!");
    		  }
    		  position = cell.getJump().getEnd();
    	  }
    	  return position;
      }
    
    public Cell getCell(int pos) {
		int row = pos / (size);
		int col = pos % (size);
		return cells[row][col];
	}
   
}
