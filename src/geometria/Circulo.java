package geometria;

import java.awt.Graphics;

public class Circulo implements Geometria {

	@Override
	public void dibujar(Graphics figura, int x, int y) {
		figura.fillOval(x,y,x*4,y*2);
	}

}
