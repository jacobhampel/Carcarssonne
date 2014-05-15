package gui;

import game.Player;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

public class PlayerComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7605375967003787052L;
	MouseAdapter listener = new MouseListener();
	Player player;

	public PlayerComponent(Player player) {

		setSize(300, 100);
		this.player=player;

		addMouseListener(new MouseListener());

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(player.getColor());
		g.drawString(player.getName() + "             " + player.getScore() + "            " + player.getRemainingFollower(), 10,15);
		g.draw3DRect(5, 0, 205, 20, true);
		
		
		
		
		
	}

	private class MouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e)
		{
			if (e.isMetaDown())
			{
				player.setScore(player.getScore()-10);
				repaint();
			}
			else
			{
				player.setScore(player.getScore()+10);
				repaint();
			}
		}

	}

}
