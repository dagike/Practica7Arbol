package geometria;

import java.awt.Graphics;

public class Linea extends Geometria {
	public static final int RIGHT=0,LEFT=1;
	private int cual;
	public void setCual(int cual){
		this.cual=cual;
	}
	public void dibujar(Graphics figura, int x, int y) {
		if(cual==RIGHT)
			figura.drawLine(x+25, (y + 50), (x + 150), (y + 75));// RIGHT
		else if(cual==LEFT)
			figura.drawLine((x - 150)+50, (y + 75), x+25, (y + 50));// LEFT
	}

}
