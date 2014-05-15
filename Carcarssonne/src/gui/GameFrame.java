package gui;

import game.Game;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GameFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5051933434183206532L;
	private PlayerListComponent playerListC;

	public GameFrame(Game game) {
		super.setSize(1024, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		playerListC = new PlayerListComponent(game);
		StackComponent stackC = new StackComponent(game.getStack());
		TableComponent tableC = new TableComponent(game, stackC,playerListC);
		

		JScrollPane paneT = new JScrollPane(tableC);

		// add(stackC, BorderLayout.LINE_END);
		JPanel panelOptions = new JPanel();
		panelOptions.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
		panelOptions.setLayout(new BorderLayout());
		panelOptions.add(stackC, BorderLayout.SOUTH);
		panelOptions.add(playerListC, BorderLayout.CENTER);

		add(panelOptions, BorderLayout.LINE_END);
		add(paneT, BorderLayout.CENTER);

		setVisible(true);
		setTitle("Carcarssonne");

	}

}
