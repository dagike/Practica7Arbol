package geometria;

import java.awt.*;

public class Circulo extends Geometria {
	private String message;
	private int width,height,fontSize;
	public void dibujar(Graphics figura, int x, int y) {
		this.x=x;
		this.y=y;
		figura.drawOval(x,y,width,height);
		figura.setFont(new Font("TimesRoman", Font.PLAIN, fontSize)); 
		figura.drawString(message, x + 5, y + 28);
	}
	public void setTamanio(int tam){
			width=tam;height=tam;
	}
	public void setFontSize(int tam){
			fontSize=tam;
	}
	public void setMessage(String message){
		this.message = message;
	}

}
