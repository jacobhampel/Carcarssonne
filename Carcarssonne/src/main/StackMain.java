package main;

import game.Game;
import game.Stack;
import game.Tile;
import gui.GameFrame;


public class StackMain {
	
	public static void main(String[] args)
	{
		Game game = new Game(10,10);
		new GameFrame(game);
		System.out.println(game.toString());
		Stack stack = game.getStack();
		System.out.println("Ist der Stapel leer? " +stack.isEmpty());
		Tile tile1 = stack.peekTile();
		System.out.println("Die oberste Karten im Stapel ist: " +tile1.getName());
		Tile tile2 = stack.fetchTile();
		System.out.println("Die genommene Karte ist: " + tile2.getName());
		tile1 = stack.peekTile();
		System.out.println(game.toString());
		System.out.println("Die nun oberste Karten im Stapel ist: " +tile1.getName());
		stack.returnTile(tile2);
		System.out.println("Die zurückgelegte Karte ist: " + tile2.getName());
		tile1 = stack.peekTile();
		System.out.println("Die nun oberste Karten im Stapel ist: " +tile1.getName());
		System.out.println(game.toString());
		System.out.println("Ist der Stapel leer? " +stack.isEmpty());
		
		
		
		
		
	
	}
}
