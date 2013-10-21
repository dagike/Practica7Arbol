package geometria;

import java.awt.Graphics;

public class Linea implements Geometria {

	public void dibujar(Graphics figura, int x, int y) {
		figura.drawLine((x + 25), (y + 50), (x + 175), (y + 75));// RIGHT
		figura.drawLine((x + 25), (y + 50), (x - 125), (y + 75));// LEFT
	}

}
