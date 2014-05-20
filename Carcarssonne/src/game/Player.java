package game;

import java.awt.Color;
import java.util.LinkedList;

public class Player {

	private String name;
	private int score;
	private Color color;
	private static int followerStart = 5;
	private LinkedList<Follower> follower = new LinkedList<Follower>();

	public Player(String name, Color color) {
		this.name = name;
		this.color = color;
		/*
		 * for (int i = 0; i < 5; i++) { follower.add(new Follower(this,0,0)); }
		 */
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public Color getColor() {
		return color;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Follower getFollower() {
		Follower f = follower.removeFirst();
		return f;
	}

	public void returnFollower(Follower f) {
		follower.add(f);
	}

	public int getRemainingFollower() {

		return followerStart - (follower.size());
	}

}
