package geometria;

import java.awt.Graphics;

public class Linea extends Geometria {
	public static final int RIGHT=0,LEFT=1;
	private int cual,tamX,desfaseX,tamY,desfaseY;
	public void setCual(int cual){
		this.cual=cual;
	}
	public void setX(int tam,int desfase){
		tamX=tam;desfaseX=desfase;
	}
	public void setY(int tam,int desfase){
		tamY=tam;desfaseY=desfase;
	}
	public void dibujar(Graphics figura, int x, int y) {
		if(cual==RIGHT)
			figura.drawLine(x+desfaseX, (y + desfaseY), (x + tamX)+desfaseX, (y + tamY)+desfaseY);// RIGHT
			//figura.drawLine(x+25, (y + 50), (x + 150), (y + 75));// RIGHT
		else if(cual==LEFT)
			figura.drawLine((x +desfaseX)-tamX, (y + tamY)+desfaseY, x+desfaseX, (y + desfaseY));// LEFT
	}

}
