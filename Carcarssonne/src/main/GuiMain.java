package main;

import game.Game;
import game.Tile;
import gui.GameFrame;

public class GuiMain {

	public static void main(String[] args) {
		
		
		new GuiMain();
	

	}
	public GuiMain()
	{
		Game game = new Game(10,10);
		Tile tile1 = new Tile(1);
		Tile tile2 = new Tile(2);
		Tile tile3 = new Tile(2);
		tile3.turn();
		Tile tile4 = new Tile(6);
		tile4.turn();
		Tile tile5 = new Tile(7);
		tile5.turn();
		game.getTable().placeTile(tile1, 0, 0);
		game.getTable().placeTile(tile2, 0, 1);
		game.getTable().placeTile(tile3, 1, 0);
		game.getTable().placeTile(tile4, 2, 0);
		game.getTable().placeTile(tile5, 2, 1);
		new GameFrame(game);
		
		
		
		
		
		
	}

}
