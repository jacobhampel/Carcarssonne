package game;

public class Follower {
	private Player player;
	private int x;
	private int y;
	private Tile tile;
	
	public Follower(Player player, Tile tile, int x, int y)
	{
		this.player = player;
		this.x = x;
		this.y =y;
		this.tile = tile;
		tile.setClickedSegment(x, y);

		
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Tile getTile()
	{
		return tile;
	}
	

}
