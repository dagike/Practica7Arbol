package geometria;

import java.awt.Graphics;

public class Linea implements Geometria {

	public void dibujar(Graphics figura, int x, int y) {
		figura.drawLine((x + 25), (y + 50), (x + 100), (y + 75));// RIGHT
		figura.drawLine((x + 25), (y + 50), (x - 50), (y + 75));// LEFT
	}

}
