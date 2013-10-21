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
	private ArbolBinario<String> arbolString;
	private ArbolBinario<Integer> arbolInteger;
	private ArbolBinario<Double> arbolDouble;
	private ArbolBinario<NumeroComplejo> arbolNumeroComplejo;
	private int state;
	private boolean error;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch(state){
			case 0: 
				if(arbolString!=null){
					//Funcion recursiva para calcular el nivel máximo de ese arbol

					x=300;
					y=0;
					recorrido(arbolString.getRaiz(),g,x,y);
				}
			break;
			/*case 2:
				
				Circulo circulo = new Circulo();
				Linea linea = new Linea();
				if (((NodoDoble<Integer>) raizInteger).getPreviewNodo() != null){
					raizInteger = ((NodoDoble<Integer>) raizInteger).getPreviewNodo();
				}
				position(String.valueOf(raizInteger.getInfo()), raizInteger.getNivel(), raizInteger.getNumero() );
				circulo.setMessage(message);
				circulo.dibujar(g, x, y);
				linea.dibujar(g, x, y);
				if (raizString.getNextNodo() != null){
					paintComponent(g);
					raizString = raizString.getNextNodo();
				}
			break;*/
		}	
	}
	public TreePaint(){
		super();
		setBackground(Color.WHITE);
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
	public void setState(int state){this.state = state;}
	public void posOrder(){}
	public void inOrder(){}
	public void preOrder(){}
	public void agregarString(String agrega){
		if (arbolString == null)
			arbolString = new ArbolBinario<>(agrega);
		else{
			if(!arbolString.insertar(agrega))
				error=true;
		}
		repaint();
	}
	public void eliminarString(String elimin){
		if (arbolString == null)
			error=true;
		else{
			if(!arbolString.eliminar(elimin))
				error=true;
		}
		repaint();
	}
	
	public void recorrido(Nodo<String> raiz,Graphics g,int x,int y){
		int x1,y1;
		Circulo circulo = new Circulo();
		circulo.setTamanio(50);
		circulo.setFontSize(12);
		circulo.setMessage(raiz.getInfo());
		circulo.dibujar(g,x,y);
		if (raiz.getNextNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.RIGHT);
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1+=125;
			y1+=75;
			recorrido(raiz.getNextNodo(),g,x1,y1);
		}
		if (((NodoDoble)raiz).getPreviewNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.LEFT);
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1-=125;
			y1+=75;
			recorrido(((NodoDoble<String>)raiz).getPreviewNodo(),g,x1,y1);
		}
	}
	
	/*public String treeComplete(Nodo<String> raiz){
			String s = "";
			if (((NodoDoble<String>) raiz).getPreviewNodo() != null)
				s += treeComplete(((NodoDoble<String>) raiz).getPreviewNodo());
			s += raiz.getInfo() + " " + raiz.getNivel() + " " + raiz.getNumero();
			if (raiz.getNextNodo() != null)
				s += treeComplete();
			return s;
	}*/
	
}
