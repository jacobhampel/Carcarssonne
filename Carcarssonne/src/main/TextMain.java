package main;

import game.Game;
import game.Tile;

public class TextMain {

	public static void main(String[] args) {

		Game game1 = new Game(4,3);

		Tile tile1 = new Tile(1);
		Tile tile2 = new Tile(2);
		Tile tile3 = new Tile(2);
		Tile tile4 = new Tile(6);
		Tile tile5 = new Tile(6);
		game1.getTable().placeTile(tile1, 0, 0);
		game1.getTable().placeTile(tile2, 0, 1);
		game1.getTable().placeTile(tile3, 1, 0);
		game1.getTable().placeTile(tile4, 2, 0);
		game1.getTable().placeTile(tile5, 2, 1);
		System.out.println("Test");
		System.out.println(game1.toString());
		System.out.println("huhu");
		
	}

}
