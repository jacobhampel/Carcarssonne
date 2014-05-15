package gui;

import game.Follower;
import game.Game;
import game.Stack;
import game.Table;
import game.Tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class TileComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9111442849315163582L;
	private Game game;
	private int x, y;
	private int paintX, paintY;
	private MouseAdapter listener = new MouseListener();;
	private StackComponent stackC;
	private PlayerListComponent playerListC;
	private boolean actionPaint = false;
	private boolean isPossible = false;

	public TileComponent(Game game, StackComponent stackC,
			PlayerListComponent playerListC, int x, int y) {

		super.setSize(108, 108);
		setBorder(new LineBorder(Color.black));
		this.playerListC = playerListC;
		this.stackC = stackC;
		this.game = game;
		this.x = x;
		this.y = y;
		addMouseListener(listener);

	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Color c = g.getColor();

		if (actionPaint == true) {
			if (isPossible == true) {
				g.setColor(Color.GREEN);
				g.drawRect(1, 1, 106, 106);
				g.drawRect(2, 2, 104, 104);
				g.setColor(c);

			} else {

				g.setColor(Color.RED);
				g.drawRect(1, 1, 106, 106);
				g.drawRect(2, 2, 104, 104);
				g.setColor(c);
			}

		}

		if (game.getTable().getTile(x, y) != null) {

			if (playerListC.getAddFollowerBoolean() == true) {
				// if (game.getCurrentPlayer().getRemainingFollower() !=
				// (0-1))
				// {
				g.setColor(game.getCurrentPlayer().getColor());
				g.drawImage(game.getTable().getTile(x, y).getImage(), 0, 0,
						null);
				g.fillOval(game.getTable().getTile(x, y).getFollower().getX(),
						game.getTable().getTile(x, y).getFollower().getY(), 20,
						20);

				playerListC.setAddFollowerBoolean(false);

			} else {
				g.drawImage(game.getTable().getTile(x, y).getImage(), 0, 0,
						null);

			}
			// Zeichnet ein Raster für die Follower
			/*
			 * for (int i = 0; i < 5; i++) { for (int j = 0; j < 5; j++) {
			 * g.drawRect(i * 22, j * 22, 22, 22); } }
			 */

		}

	}

	private class MouseListener extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {
			if (3 == e.getButton()) {
				System.out.println(game.getTable().getTile(x, y).toString());
			} else {

				if (game.getStart() == true) {
					// Allgemeiner Start. Sobald das Spiel gestartet ist, ist
					// der
					// Aktionlistener freigeschaltet
					paintX = e.getX() / 22 * 22;
					paintY = e.getY() / 22 * 22;
					Table table = game.getTable();
					Tile tile = game.getTable().getTile(x, y);
					Stack stack = game.getStack();

					if (table.getTile(x, y) == null) {

						// Wenn Feld leer ist wird eine Karte gesetzt
						if (isPossible == true) {
							tile = stack.fetchTile();
							table.placeTile(tile, x, y);
						} else
							JOptionPane.showMessageDialog(null,
									"Tiles does not fit");
						playerListC.setAddFollowerBoolean(false);
						table.firstTile(true);

					} else {
						// Feld ist breits durch karte gesetzt
						if (playerListC.getAddFollowerBoolean() == false) {
							// Kein setzen des Followers -> dadurch soll die
							// Karte
							// entfernt werden.
							tile = table.getTile(x, y);
							if (table.getTile(x, y).getFollower() != null) {
								// Wenn die Karte mit einem Follower besetzt
								// war:
								// Follower wird von Tile entfernt und wieder
								// dem
								// Player zugeordnet
								tile.getFollower().getPlayer().getFollower();
								tile.removeFollower();
							}
							stack.returnTile(tile);
							table.removeTile(x, y);
							// game.getCurrentPlayer().returnFollower(new
							// Follower(game.getCurrentPlayer(), paintX,
							// paintY));

						} else {
							// Setzen des Followers.
							if (game.getCurrentPlayer().getRemainingFollower() != 0) {// Wenn
																						// noch
																						// Follower
																						// vorhanden
																						// sind{
								if (table.getTile(x, y).getFollower() == null) {
									Follower follower = new Follower(
											game.getCurrentPlayer(),
											table.getTile(x, y), paintX, paintY);
									game.getCurrentPlayer().returnFollower(
											follower);
									table.getTile(x, y).setFollower(follower);
									// game.getCurrentPlayer().returnFollower(game.getCurrentPlayer().getFollower());
								} else {
									// Wenn bereits Follower auf dem Feld liegt
									// Entfernen und neusetzen
									table.getTile(x, y).getFollower()
											.getPlayer().getFollower();
									table.getTile(x, y).removeFollower();
									Follower follower = new Follower(
											game.getCurrentPlayer(),
											table.getTile(x, y), paintX, paintY);
									game.getCurrentPlayer().returnFollower(
											follower);
									table.getTile(x, y).setFollower(follower);
								}

							} else {
								JOptionPane.showMessageDialog(null,
										"No Followers availible!!");
								playerListC.setAddFollowerBoolean(false);
							}
						}

					}

					stackC.repaint();
					repaint();
					playerListC.repaint();
				}

				else {
					JOptionPane.showMessageDialog(null, "Start Game");
				}

			}

		}

		public void mouseEntered(MouseEvent e) {
			if (game.getTable().getTile(x, y) == null) {
				actionPaint = true;
				if (game.getTable().fits(game.getStack().peekTile(), x, y) == true) {
					isPossible = true;
				} else
					isPossible = false;
				repaint();

			}

		}

		public void mouseExited(MouseEvent e) {
			actionPaint = false;
			if (game.getTable().getTile(x, y) == null) {
				repaint();

			}
		}
	}
}
