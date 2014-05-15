package game;

import java.util.Collections;
import java.util.LinkedList;

public class Stack {

	private LinkedList<Tile> tilesL;

	public Stack() {
		tilesL = new LinkedList<Tile>();
		tilesL = Tile.getAllTilesForStack();
		Collections.shuffle(tilesL);
		

	}

	public Tile fetchTile() {
		Tile tile;
		tile = tilesL.removeFirst();
		return tile;

	}

	public void returnTile(Tile t) {
		tilesL.addFirst(t);

	}

	public Tile peekTile() {
		Tile tile;
		tile = tilesL.getFirst();
		return tile;
	}

	public boolean isEmpty() {
		int size = tilesL.size();
		boolean empty = false;
		if (size == 0) {
			empty = true;
		}
		return empty;

	}
	private void getFirstTile()
	{
		//TODO: Starttile 20 an Anfang der Liste setzen!!!
	}

	public String toString() {

		String output = tilesL.get(0).getName();
		for (int i = 1; i < tilesL.size(); i++) {
			output = output + "," + tilesL.get(i).getName();
		}

		return output;

	}
}
