package gui;

import game.Game;
import game.Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PlayerListComponent extends JComponent

{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1796184232196799351L;
	private Game game;
	private ActionListenerAdd listenerAdd = new ActionListenerAdd();
	private ActionListenerNext listenerNext = new ActionListenerNext();
	private JPanel panelPlayer = new JPanel();
	private JButton bFollower = new JButton();
	private JButton bPlayer = new JButton("Add Players");
	
	private boolean addFollowerBoolean = false;

	public PlayerListComponent(Game game) {
		this.game = game;
		panelPlayer.setLayout(new GridLayout(0, 1));

		JPanel panelOptions = new JPanel();
		panelOptions.setBorder(new EmptyBorder(0, 0, 10, 0));
		bPlayer.addActionListener(listenerAdd);
		bFollower.setText("Start Game");
		bFollower.addActionListener(listenerNext);

		Player player = new Player("Test", Color.GREEN);
		PlayerComponent playerC2 = new PlayerComponent(player);
		panelPlayer.add(playerC2);
		game.addPlayer(player);

		Player player2 = new Player("Test2", Color.BLUE);
		PlayerComponent playerC3 = new PlayerComponent(player2);
		panelPlayer.add(playerC3);
		game.addPlayer(player2);

		panelOptions.add(bPlayer, BorderLayout.LINE_START);
		panelOptions.add(bFollower, BorderLayout.LINE_END);

		setLayout(new BorderLayout());
		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 10, 0),
				new LineBorder(Color.BLACK)));
		add(panelOptions, BorderLayout.NORTH);
		add(panelPlayer, BorderLayout.CENTER);

	}


	public boolean getAddFollowerBoolean() {
		return addFollowerBoolean;
	}

	public void setAddFollowerBoolean(boolean b) {
		addFollowerBoolean = b;
	}

	private class ActionListenerAdd implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (game.getStart() == false) {
				String name = JOptionPane.showInputDialog("Player's name");

				if (name == null) {

					JOptionPane.showMessageDialog(null, "What's your name?");
				} else {

					Color color = JColorChooser.showDialog(null,
							"Choose your color", null);
					Player player = new Player(name, color);
					game.addPlayer(player);
					PlayerComponent playerC = new PlayerComponent(player);
					panelPlayer.add(playerC);

				}

			} else {
				if (game.getPlayerList().size() != 0) {

					game.nextPlayer();

					Component component = panelPlayer.getComponent(1);
					panelPlayer.remove(1);

					component.setBackground(Color.WHITE);
					panelPlayer.add(component);

				} else
					JOptionPane.showMessageDialog(null, "Add players!");

			}
			revalidate();
		}

	}

	private class ActionListenerNext implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			if (game.getStart() != true) {
				bFollower.setText("Add Follower");
				game.setStart(true);
				bPlayer.setText("Next Player");
				panelPlayer.add(new JLabel("Current Player:"), 0);
			} else
				addFollowerBoolean = true;

		}
	}

}