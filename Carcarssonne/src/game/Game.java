package game;

import java.util.LinkedList;

public class Game {

	private Table table;
	private Stack stack;
	private LinkedList<Player> playerList;
	private Player currentPlayer;
	private boolean start = false;

	public Game(int tableSizeX, int tableSizeY) {
		table = new Table(tableSizeX, tableSizeY);
		stack = new Stack();
		playerList = new LinkedList<Player>();

	}

	public Table getTable() {
		return table;
	}

	public Stack getStack() {
		return stack;
	}

	public LinkedList<Player> getPlayerList() {
		return playerList;
	}

	public void addPlayer(Player p) {
		playerList.addLast(p);
	}

	public void nextPlayer() {
		playerList.addLast(playerList.removeFirst());
	}

	public Player getCurrentPlayer() {
		currentPlayer = playerList.getFirst();
		return currentPlayer;
	}

	public String toString() {
		String string = new String();
		string = table.toString() + "" + stack.toString();

		return string;

	}
	
	public boolean getStart()
	{
		return start;
	}
	
	public void setStart(boolean b)
	{
		this.start = b;
	}

}
