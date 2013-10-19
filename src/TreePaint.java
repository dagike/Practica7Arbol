import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import geometria.*;

public class TreePaint extends JPanel {
	private Color c;

	public void paintComponent(Graphics g) {
		g.setColor(c);
		int x = 350, y = 0;

		g.drawOval(x, y, 50, 50);
		g.drawString("A", x + 22, y + 28);
		g.drawLine((x + 25), (y + 50), (x + 150), (y + 75));// RIGHT
		g.drawLine((x + 25), (y + 50), (x - 100), (y + 75));// LEFT

		// RIGHT
		g.drawOval(x + 125, y + 75, 50, 50);
		g.drawString("R", x + 22 + 125, y + 28 + 75);

		// LEFT
		g.drawOval(x - 125, y + 75, 50, 50);
		g.drawString("L", x + 22 - 125, y + 28 + 75);

		x += 125;
		y += 75;

		for (int z = 0; z < 3; z++) {
			position(g, x, y, 0);
		}
	}

	public TreePaint(Color c) {
		super();
		this.c = c;
	}

	public void position(Graphics g, int x, int y, int n) {
		g.drawLine((x + 25), (y + 50), (x + 50), (y + 75));// RIGHT
		g.drawLine((x + 25), (y + 50), (x), (y + 75));// LEFT

		// RIGHT
		g.drawOval(x + 30, y + 75, 50, 50);
		g.drawString("R", x + 22 + 30, y + 28 + 75);

		// LEFT
		g.drawOval(x - 25, y + 75, 50, 50);
		g.drawString("L", x + 22 - 25, y + 28 + 75);
	}

	public void setColor(Color c) {
		this.c = c;
	}

	public void borrar() {
		repaint();
	}

	public void posOrder() {
		// TODO Auto-generated method stub

	}

	public void inOrder() {
		// TODO Auto-generated method stub

	}

	public void preOrder() {
		// TODO Auto-generated method stub

	}
}
