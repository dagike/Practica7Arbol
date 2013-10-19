package geometria;

import java.awt.Graphics;

public class Linea implements Geometria {

	@Override
	public void dibujar(Graphics figura, int x, int y) {
		figura.drawLine(x,y,50,20);
	}

}
