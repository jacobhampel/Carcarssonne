package gui;

import game.Stack;
import game.Tile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;

public class StackComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4190274072416208712L;
	private Tile tile;
	private MouseAdapter listener = new MouseListener();
	private Stack stack;

	public StackComponent(Stack stack) {
		this.stack = stack;
		setPreferredSize(new Dimension(108, 108));
		setBorder(new LineBorder(Color.BLACK));
		if (stack.isEmpty() == false) {
			tile = stack.peekTile();
		}
		addMouseListener(listener);
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		tile = stack.peekTile();
		g.drawImage(tile.getImage(), 0, 0, null);
		
		

	}

	private class MouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent event) {
			tile.turn();
			repaint();
		}

	}

}
