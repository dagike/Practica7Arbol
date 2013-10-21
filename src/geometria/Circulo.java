package geometria;

import java.awt.Graphics;

public class Circulo extends Geometria {
	private String message;
	private int width,height;
	public void dibujar(Graphics figura, int x, int y) {
		this.x=x;
		this.y=y;
		figura.drawOval(x,y,width,height);
		figura.drawString(message, x + 22, y + 28);
	}
	public void setTamanio(int tam){
			width=tam;height=tam;
	}
	public void setMessage(String message){
		this.message = message;
	}

}
