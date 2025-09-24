package SnakeNLadder_LLD;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
   
	int sizeOfBoard;
	Board board;
	Dice dice = new Dice(1);
	Deque<Player> listPlayers = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
	
	public void start() {
		initializePlayers();
	    System.out.println("Enter size of board");
        sizeOfBoard = sc.nextInt();
        board = new Board(sizeOfBoard);
        
        System.out.println("Enter number of snakes");
		int snakeCount = sc.nextInt();
		
		board.addSnakes(snakeCount);
		
		System.out.println("Enter number of ladders");
		int ladderCount = sc.nextInt();
		
		board.addLadders(ladderCount);
		
		playGame();
		
	}
	public void playGame() {
		
		boolean winner = false;
		while(!winner) {
		Player playerTurn = listPlayers.removeFirst();
		System.out.println("Turn to roll dice for " + playerTurn.getPlayerId());
		listPlayers.add(playerTurn);
		
		int diceCount = dice.roll();
		System.out.println("Dice value:  " + diceCount);
		
		int newPlayerPosition = playerTurn.getCurrentPosition() + diceCount;
		if(newPlayerPosition < (sizeOfBoard * sizeOfBoard) - 1) { 
		newPlayerPosition = board.validate(newPlayerPosition);
		playerTurn.setCurrentPosition(newPlayerPosition);
		System.out.println("Player " + playerTurn.getPlayerId() + " moves to1 " + playerTurn.getCurrentPosition());
		}
		else if (newPlayerPosition > (sizeOfBoard * sizeOfBoard) - 1) {
			System.out.println("Overshoot, Player " + playerTurn.getPlayerId() + " stays at " + playerTurn.getCurrentPosition());
		}			
		else {
			System.out.println("Player " + playerTurn.getPlayerId() + " won");
			winner = true;
		}
		}
	}
	public void initializePlayers() {
		Player player1 = new Player("1", 0);
		Player player2 = new Player("2", 0);
		
		listPlayers.add(player1);
		listPlayers.add(player2);
	}
	
	
}
