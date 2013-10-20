package geometria;

import java.awt.Graphics;

public class Circulo implements Geometria {
	private String message;
	public void dibujar(Graphics figura, int x, int y) {
		figura.drawOval(x,y,50,50);
		figura.drawString(message, x + 22, y + 28);
	}
	
	public void setMessage(String message){
		this.message = message;
	}

}
