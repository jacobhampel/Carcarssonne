package main;

import game.Game;
import gui.GameFrame;

public class PlayerMain {
	
	public static void main(String[] args)
	{
		Game game = new Game(10,10);
		new GameFrame(game);
		
				
	
	}

}
