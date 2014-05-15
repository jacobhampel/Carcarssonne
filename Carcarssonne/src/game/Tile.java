package game;

import images.ImageHelper;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import data.DataHelper;

public class Tile {

	private BufferedImage image;
	private String name;
	private Follower follower = null;
	private Segment[][] segment = new Segment[5][5];
	private Segment clickedSegment;

	public Tile(int cardNumber) {
		image = ImageHelper.loadImage(cardNumber);
		name = toString(cardNumber);
		char[][] segmentArray = new char[5][5];
		segmentArray = DataHelper.loadCard(cardNumber);
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 5; i++) {
				segment[i][j] = new Segment(segmentArray[i][j]);
			}
		}

	}

	public String toString(int cardNumber) {

		this.name = Integer.toString(cardNumber);
		if (cardNumber < 10) {
			this.name = 0 + this.name;
		}
		return this.name;

	}

	public BufferedImage getImage() {
		return image;
	}

	public void turn() {
		image = ImageHelper.turnImage(image);

		Segment[][] segmentH = new Segment[5][5];

		segmentH = segment;
		int k;
		segment = new Segment[5][5];
		// ganz wichtig, da es sonst zu fehlern kommt.
		for (int j = 0; j < 5; j++) {
			k = 4;
			for (int i = 0; i < 5; i++) {
				segment[j][k] = segmentH[i][j];
				k--;
			}
		}

	}

	public String getName() {
		return name;
	}

	public static LinkedList<Tile> getAllTilesForStack() {
		LinkedList<Tile> tilesL;
		tilesL = new LinkedList<Tile>();
		Tile tile[] = new Tile[DataHelper.NUMBER_OF_CARDS + 1];

		for (int cardNumber = 1; cardNumber <= (DataHelper.NUMBER_OF_CARDS); cardNumber++) {
			tile[cardNumber] = new Tile(cardNumber);
			for (int i = 0; i < DataHelper.getCardCount(cardNumber); i++) {
				tilesL.add(tile[cardNumber]);
			}

		}

		return tilesL;
	}

	public void setFollower(Follower follower) {
		this.follower = follower;
	}

	public void removeFollower() {
		follower = null;
	}

	public Follower getFollower() {
		return follower;
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				output = output + segment[j][i].getTyp();
			}
			output = output + ("\n");
		}
		output = output + "Rechts: " + segmentE() + " Links: " + segmentW()
				+ " oben: " + segmentN() + " unten: " + segmentS();
		if (clickedSegment != null) {
			output = output + " Das geklickte Segment ist: "
					+ clickedSegment.getTyp();
		}

		return output;
	}

	public String segmentN() {
		String output = "";
		for (int i = 1; i < 4; i++) {

			output = output + segment[i][0].getTyp();

		}
		return output;
	}

	public String segmentE() {
		String output = "";
		for (int i = 1; i < 4; i++) {
			output = output + segment[4][i].getTyp();

		}
		return output;

	}

	public String segmentW() {
		String output = "";
		for (int i = 1; i < 4; i++) {
			output = output + segment[0][i].getTyp();

		}
		return output;

	}

	public String segmentS() {
		String output = "";
		for (int i = 1; i < 4; i++) {
			output = output + segment[i][4].getTyp();

		}
		return output;

	}

	public void setClickedSegment(int x, int y) {
		x = x / 22;
		y = y / 22;
		clickedSegment = segment[x][y];
	}

	public Segment getClickedSegment() {
		return clickedSegment;
	}

	public boolean fitsToNeighbour(Tile neighbour, int direction) {
		boolean b = true;
		if (neighbour != null) {
			switch (direction) {
			case 0: {
				if (this.segmentN().matches(neighbour.segmentS())) {
					b = true;
				} else {
					b = false;
				}
				break;
			}
			case 1:
				if (this.segmentW().matches(neighbour.segmentE())) {
					b = true;
				} else {
					b = false;
				}
				break;
			case 2:
				if (this.segmentS().matches(neighbour.segmentN())) {
					b = true;
				} else {
					b = false;
				}
				break;
			case 3:
				if (this.segmentE().matches(neighbour.segmentW())) {
					b = true;
				} else {
					b = false;
				}
				break;
			}
		}

		return b;

	}
}
