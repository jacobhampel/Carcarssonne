package main;

import game.Game;
import gui.GameFrame;

public class PlayerMain {
	
	public static void main(String[] args)
	{
		Game game = new Game(100,100);
		new GameFrame(game);
		
				
	
	}

}
