package game;

import java.lang.reflect.Array;

public class Table {

	private Tile tiles[][];
	private int tableSizeX;
	private int tableSizeY;
	private boolean firstTile;

	public Table(int tableSizeX, int tableSizeY) {
		tiles = new Tile[tableSizeX][tableSizeY];
		this.tableSizeX = tableSizeX;
		this.tableSizeY = tableSizeY;
	}

	public int getLengthX() {
		int length = Array.getLength(tiles);
		return length;
	}

	public int getLengthY() {
		int length = Array.getLength(tiles[0]);
		return length;
	}

	public Tile getTile(int x, int y) {
		if (tiles[x][y] != null)
			return tiles[x][y];
		else
			return null;

	}

	public void placeTile(Tile tile, int x, int y) {
		tiles[x][y] = tile;

	}

	public Tile removeTile(int x, int y) {
		tiles[x][y] = null;
		return tiles[x][y];
	}

	public boolean fits(Tile tile, int x, int y) {
		boolean b = false;
		Tile tileNeighbourN, tileNeighbourW, tileNeighbourS, tileNeighbourE;
		if (y > 0) {
			tileNeighbourN = tiles[x][y - 1];
		} else {
			tileNeighbourN = null;
		}
		if (x > 0)
			tileNeighbourW = tiles[x - 1][y];
		else
			tileNeighbourW = null;
		if (y < tableSizeY)
			tileNeighbourS = tiles[x][y + 1];
		else
			tileNeighbourS = null;
		if (x < tableSizeX)
			tileNeighbourE = tiles[x + 1][y];
		else
			tileNeighbourE = null;

		if (tile.fitsToNeighbour(tileNeighbourN, 0) == true) {
			b = true;
		} else {
			b = false;
		}
		if (tile.fitsToNeighbour(tileNeighbourW, 1) == true && b == true) {
			b = true;
		} else {
			b = false;

		}
		if (tile.fitsToNeighbour(tileNeighbourS, 2) == true && b == true) {
			b = true;
		} else
			b = false;

		if (tile.fitsToNeighbour(tileNeighbourE, 3) == true && b == true)
			b = true;
		else {
			b = false;

		}
		
		//Überprüfen ob Game bereits gestartet
		//Noch ohne Funktion, da sonst die erste Tile nicht gesetzt werden kann.
		if (tileNeighbourE == null && tileNeighbourN == null && tileNeighbourS == null && tileNeighbourW == null && firstTile == true)
			b = false;
		return b;


	}
	
	public void firstTile(boolean b)
	{
		this.firstTile = b;
	}

	public String toString() {
		String output = "";
		for (int j = 0; j < getLengthY(); j++) {
			for (int i = 0; i < getLengthX(); i++) {
				if (tiles[i][j] != null) {
					output = output + tiles[i][j].getName() + " ";
				} else
					output = output + "__" + " ";
			}

			output = output + ("\n");
		}

		return output;

	}
}
