package geometria;

import java.awt.*;

public class Circulo extends Geometria {
	private String message;
	private int width,height,fontSize;
	public void dibujar(Graphics figura, int x, int y) {
		this.x=x;
		this.y=y;
		figura.fillOval(x,y,width,height);
		figura.setFont(new Font("TimesRoman", Font.PLAIN, fontSize)); 
		figura.setColor(new Color(0,0,0));
		figura.drawString(message, x + 5,y+((int)(height/2+fontSize/2)) );
	}
	public void setAncho(int tam){
			width=tam;
	}
	public void setAlto(int tam){
			height=tam;
	}
	public void setFontSize(int tam){
			fontSize=tam;
	}
	public void setMessage(String message){
		this.message = message;
	}

}
