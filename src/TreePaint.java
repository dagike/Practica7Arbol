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
					System.out.println(maxLevelString(arbolString.getRaiz(),arbolString.getRaiz().getNivel()));
					x=300;
					y=0;
					recorridoString(arbolString.getRaiz(),g,x,y);
				}
			break;
			case 1:
				if(arbolInteger!=null){
					//Funcion recursiva para calcular el nivel máximo de ese arbol
					System.out.println(maxLevelInteger(arbolInteger.getRaiz(),arbolInteger.getRaiz().getNivel()));
					x=300;
					y=0;
					recorridoInteger(arbolInteger.getRaiz(),g,x,y);
				}
			break;
			case 2:
				if(arbolDouble!=null){
					//Funcion recursiva para calcular el nivel máximo de ese arbol
					System.out.println(maxLevelDouble(arbolDouble.getRaiz(),arbolDouble.getRaiz().getNivel()));
					x=300;
					y=0;
					recorridoDouble(arbolDouble.getRaiz(),g,x,y);
				}
			case 3:
				if(arbolNumeroComplejo!=null){
					//Funcion recursiva para calcular el nivel máximo de ese arbol
					System.out.println(maxLevelNumeroComplejo(arbolNumeroComplejo.getRaiz(),arbolNumeroComplejo.getRaiz().getNivel()));
					x=300;
					y=0;
					recorridoNumeroComplejo(arbolNumeroComplejo.getRaiz(),g,x,y);
				}
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
	
	public void recorridoString(Nodo<String> raiz,Graphics g,int x,int y){
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
			recorridoString(raiz.getNextNodo(),g,x1,y1);
		}
		if (((NodoDoble)raiz).getPreviewNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.LEFT);
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1-=125;
			y1+=75;
			recorridoString(((NodoDoble<String>)raiz).getPreviewNodo(),g,x1,y1);
		}
	}
	
	public void recorridoInteger(Nodo<Integer> raiz,Graphics g,int x,int y){
		int x1,y1;
		Circulo circulo = new Circulo();
		circulo.setTamanio(50);
		circulo.setFontSize(12);
		circulo.setMessage(String.valueOf(raiz.getInfo()));
		circulo.dibujar(g,x,y);
		if (raiz.getNextNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.RIGHT);
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1+=125;
			y1+=75;
			recorridoInteger(raiz.getNextNodo(),g,x1,y1);
		}
		if (((NodoDoble)raiz).getPreviewNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.LEFT);
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1-=125;
			y1+=75;
			recorridoInteger(((NodoDoble<Integer>)raiz).getPreviewNodo(),g,x1,y1);
		}
	}
	
	public void recorridoDouble(Nodo<Double> raiz,Graphics g,int x,int y){
		int x1,y1;
		Circulo circulo = new Circulo();
		circulo.setTamanio(50);
		circulo.setFontSize(12);
		circulo.setMessage(String.valueOf(raiz.getInfo()));
		circulo.dibujar(g,x,y);
		if (raiz.getNextNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.RIGHT);
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1+=125;
			y1+=75;
			recorridoDouble(raiz.getNextNodo(),g,x1,y1);
		}
		if (((NodoDoble)raiz).getPreviewNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.LEFT);
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1-=125;
			y1+=75;
			recorridoDouble(((NodoDoble<Double>)raiz).getPreviewNodo(),g,x1,y1);
		}
	}
	
	public void recorridoNumeroComplejo(Nodo<NumeroComplejo> raiz,Graphics g,int x,int y){
		int x1,y1;
		Circulo circulo = new Circulo();
		circulo.setTamanio(50);
		circulo.setFontSize(12);
		circulo.setMessage(String.valueOf(raiz.getInfo()));
		circulo.dibujar(g,x,y);
		if (raiz.getNextNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.RIGHT);
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1+=125;
			y1+=75;
			recorridoNumeroComplejo(raiz.getNextNodo(),g,x1,y1);
		}
		if (((NodoDoble)raiz).getPreviewNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.LEFT);
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1-=125;
			y1+=75;
			recorridoNumeroComplejo(((NodoDoble<NumeroComplejo>)raiz).getPreviewNodo(),g,x1,y1);
		}
	}
	
	public int maxLevelString(Nodo<String> raiz, int nivel){
		int maxlevel = 0;
		if(maxlevel < nivel)
			maxlevel = nivel;
		if (((NodoDoble<String>) raiz).getPreviewNodo() != null)
			maxlevel = maxLevelString(((NodoDoble<String>) raiz).getPreviewNodo(),((NodoDoble<String>) raiz).getPreviewNodo().getNivel());
		
		if (raiz.getNextNodo() != null)
			maxlevel = maxLevelString(raiz.getNextNodo(),raiz.getNextNodo().getNivel());
		return maxlevel;
	}
	
		public int maxLevelInteger(Nodo<Integer> raiz, int nivel){
		int maxlevel = 0;
		if(maxlevel < nivel)
			maxlevel = nivel;
		if (((NodoDoble<Integer>) raiz).getPreviewNodo() != null)
			maxlevel = maxLevelInteger(((NodoDoble<Integer>) raiz).getPreviewNodo(),((NodoDoble<Integer>) raiz).getPreviewNodo().getNivel());
		
		if (raiz.getNextNodo() != null)
			maxlevel = maxLevelInteger(raiz.getNextNodo(),raiz.getNextNodo().getNivel());
		return maxlevel;
	}
	
		public int maxLevelDouble(Nodo<Double> raiz, int nivel){
		int maxlevel = 0;
		if(maxlevel < nivel)
			maxlevel = nivel;
		if (((NodoDoble<Double>) raiz).getPreviewNodo() != null)
			maxlevel = maxLevelDouble(((NodoDoble<Double>) raiz).getPreviewNodo(),((NodoDoble<Double>) raiz).getPreviewNodo().getNivel());
		
		if (raiz.getNextNodo() != null)
			maxlevel = maxLevelDouble(raiz.getNextNodo(),raiz.getNextNodo().getNivel());
		return maxlevel;
	}
	
		public int maxLevelNumeroComplejo(Nodo<NumeroComplejo> raiz, int nivel){
		int maxlevel = 0;
		if(maxlevel < nivel)
			maxlevel = nivel;
		if (((NodoDoble<NumeroComplejo>) raiz).getPreviewNodo() != null)
			maxlevel = maxLevelNumeroComplejo(((NodoDoble<NumeroComplejo>) raiz).getPreviewNodo(),((NodoDoble<NumeroComplejo>) raiz).getPreviewNodo().getNivel());
		
		if (raiz.getNextNodo() != null)
			maxlevel = maxLevelNumeroComplejo(raiz.getNextNodo(),raiz.getNextNodo().getNivel());
		return maxlevel;
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
