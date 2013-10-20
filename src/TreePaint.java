import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import geometria.*;

public class TreePaint extends JPanel {
	private Color c;
	private int x, y;
	private String message = "";
	private boolean update;
	
	public void paintComponent(Graphics g/*String message, int nivel, int numero*/) {
		if(update == true){
			g.setColor(c);
			Circulo circulo = new Circulo();
			Linea linea = new Linea();
			
			//position(nivel, numero);
			circulo.setMessage(message);
			circulo.dibujar(g, x, y);
			linea.dibujar(g, x, y);
			update = false;
		}
		/*position(1, 1);
		circulo.setMessage("B");
		circulo.dibujar(g, x, y);
		linea.dibujar(g, x, y);
		
		position(1, 2);
		circulo.setMessage("C");
		circulo.dibujar(g, x, y);
		linea.dibujar(g, x, y);*/
		
		/*g.setColor(c);
		g.drawOval(x, y, 50, 50);
		g.drawString("A", x + 22, y + 28);
		g.drawLine((x + 25), (y + 50), (x + 150), (y + 75));// RIGHT
		g.drawLine((x + 25), (y + 50), (x - 100), (y + 75));// LEFT*/

		/*// RIGHT
		g.drawOval(x + 125, y + 75, 50, 50);
		g.drawString("R", x + 22 + 125, y + 28 + 75);

		// LEFT
		g.drawOval(x - 125, y + 75, 50, 50);
		g.drawString("L", x + 22 - 125, y + 28 + 75);*/
	}

	public TreePaint(Color c,int nivel, int numero) {
		super();
		this.c = c;
		update = false;
	}

	public void position(String message, int nivel, int numero) {
		int numeroTotal = 1;
		for (int lvl = 0; lvl < nivel; lvl++) {
			numeroTotal *= 2;
		}
		this.message = message;
		this.y = nivel * 75;
		this.x = (700/(numeroTotal+1))*numero - 25;
	}
	
	public void setUpdate(boolean update){
		this.update = update;
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
