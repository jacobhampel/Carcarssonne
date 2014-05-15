package gui;

import game.Game;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;

public class TableComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6512884263710905970L;
	private StackComponent stackC;
	private PlayerListComponent playerListC;
	public TableComponent(Game game, StackComponent stackC,PlayerListComponent playerListC) {
		this.playerListC = playerListC;
		this.stackC = stackC;
		setPreferredSize(new Dimension((game.getTable().getLengthX()) * 108,
				game.getTable().getLengthY() * 108));
		setLayout(new GridLayout(0, game.getTable().getLengthY()));
		TileComponent[][] tileC = new TileComponent[game.getTable()
				.getLengthX()][game.getTable().getLengthY()];

		for (int j = 0; j < game.getTable().getLengthY(); j++) {
			for (int i = 0; i < game.getTable().getLengthX(); i++) {

				tileC[i][j] = new TileComponent(game, this.stackC, this.playerListC, i, j);
				add(tileC[i][j]);

			}
		}

	}

}
