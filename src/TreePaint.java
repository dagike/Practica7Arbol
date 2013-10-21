import javax.swing.*;

import nodo.Nodo;
import nodo.tipoNodo.NodoDoble;
import numero.NumeroComplejo;
import arbol.arbolBinario.ArbolBinario;

import java.awt.*;
import java.awt.event.*;

import geometria.*;

public class TreePaint extends JPanel {
	private Color c;
	private int x, y;
	private String message = "";
	private boolean update;
	private Nodo<String> raizString;
	private Nodo<Integer> raizInteger;
	private Nodo<Double> raizDouble;
	private Nodo<NumeroComplejo> raizNumeroComplejo;
	private int state;
	
	public void paintComponent(Graphics g/*String message, int nivel, int numero*/) {
		System.out.println(String.valueOf(update));
		if(update == true){
			super.paintComponent(g);
			Circulo circulo = new Circulo();
			Linea linea = new Linea();
			g.setColor(c);
			switch(state){
				case 1: 
					if (((NodoDoble<String>) raizString).getPreviewNodo() != null){
						raizString = ((NodoDoble<String>) raizString).getPreviewNodo();
						paintComponent(g);
					}
					position(String.valueOf(raizString.getInfo()), raizString.getNivel(), raizString.getNumero() );
					circulo.setMessage(message);
					circulo.dibujar(g, x, y);
					linea.dibujar(g, x, y);
					if (raizString.getNextNodo() != null){
						paintComponent(g);
						raizString = raizString.getNextNodo();
					}
					break;
				case 2:{
					if (((NodoDoble<Integer>) raizInteger).getPreviewNodo() != null){
						raizInteger = ((NodoDoble<Integer>) raizInteger).getPreviewNodo();
						paintComponent(g);
					}
					position(String.valueOf(raizInteger.getInfo()), raizInteger.getNivel(), raizInteger.getNumero() );
					circulo.setMessage(message);
					circulo.dibujar(g, x, y);
					linea.dibujar(g, x, y);
					if (raizString.getNextNodo() != null){
						paintComponent(g);
						raizString = raizString.getNextNodo();
					}
					break;
				}
				default:break;
			}
			//super.paintComponent(g);
		}
		/*position(1, 1);
		circulo.setMessage("B");
		circulo.dibujar(g, x, y);
		linea.dibujar(g, x, y);
		
		position(1, 2);
		circulo.setMessage("C");
		circulo.dibujar(g, x, y);
		linea.dibujar(g, x, y);*/
		
		/*g.setColor(c);
		g.drawOval(x, y, 50, 50);
		g.drawString("A", x + 22, y + 28);
		g.drawLine((x + 25), (y + 50), (x + 150), (y + 75));// RIGHT
		g.drawLine((x + 25), (y + 50), (x - 100), (y + 75));// LEFT*/

		/*// RIGHT
		g.drawOval(x + 125, y + 75, 50, 50);
		g.drawString("R", x + 22 + 125, y + 28 + 75);

		// LEFT
		g.drawOval(x - 125, y + 75, 50, 50);
		g.drawString("L", x + 22 - 125, y + 28 + 75);*/
	}

	public TreePaint(Color c,int nivel, int numero) {
		super();
		setBackground(Color.WHITE);
		this.c = c;
		update = false;
		state = 0;
	}

	public void position(String message, int nivel, int numero) {
		int numeroTotal = 1;
		for (int lvl = 0; lvl < nivel; lvl++) {
			numeroTotal *= 2;
		}
		this.message = message;
		this.y = nivel * 75;
		this.x = (700/(numeroTotal+1))*numero-1 - 25;
	}
	
	public void setRaizString(Nodo<String> raiz){
		this.raizString = raiz;
	}
	
	public void setRaizInteger(Nodo<Integer> raiz){
		this.raizInteger = raiz;
	}
	
	public void setRaizDouble(Nodo<Double> raiz){
		this.raizDouble = raiz;
	}
	
	public void setRaizNumeroComplejo(Nodo<NumeroComplejo> raiz){
		this.raizNumeroComplejo = raiz;
	}
	
	public void setUpdate(boolean update){
		this.update = update;
	}

	public void setColor(Color c) {
		this.c = c;
	}
	
	public void setState(int state){
		this.state = state;
	}

	public void borrar() {
		repaint();
	}

	public void posOrder() {
		// TODO Auto-generated method stub

	}

	public void inOrder() {
		// TODO Auto-generated method stub

	}

	public void preOrder() {
		// TODO Auto-generated method stub

	}
}
