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
					x=500;
					y=0;
					recorridoString(arbolString.getRaiz(),g,x,y,0);
				}
			break;
			case 1:
				if(arbolInteger!=null){
					x=500;
					y=0;
					recorridoInteger(arbolInteger.getRaiz(),g,x,y,0);
				}
			break;
			case 2:
				if(arbolDouble!=null){
					x=500;
					y=0;
					recorridoDouble(arbolDouble.getRaiz(),g,x,y,0);
				}
			break;
			case 3:
				if(arbolNumeroComplejo!=null){
					x=500;
					y=0;
					recorridoNumeroComplejo(arbolNumeroComplejo.getRaiz(),g,x,y,0);
				}
			break;
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
		this.y = nivel * 75;
		this.x = (700/(numeroTotal+1))*numero-1 - 25;
	}
	public void setState(int state){this.state = state;repaint();}
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
	public void agregarInteger(int agrega){
		if (arbolInteger == null)
			arbolInteger = new ArbolBinario<>(agrega);
		else{
			if(!arbolInteger.insertar(agrega))
				error=true;
		}
		repaint();
	}
	public void agregarDouble(double agrega){
		if (arbolDouble == null)
			arbolDouble = new ArbolBinario<>(agrega);
		else{
			if(!arbolDouble.insertar(agrega))
				error=true;
		}
		repaint();
	}
	public void agregarNumeroComplejo(NumeroComplejo agrega){
		if (arbolNumeroComplejo == null)
			arbolNumeroComplejo = new ArbolBinario<>(agrega);
		else{
			if(!arbolNumeroComplejo.insertar(agrega))
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
	public void eliminarInteger(int elimin){
		if (arbolInteger == null)
			error=true;
		else{
			if(!arbolInteger.eliminar(elimin))
				error=true;
		}
		repaint();
	}
	public void eliminarDouble(double elimin){
		if (arbolDouble == null)
			error=true;
		else{
			if(!arbolDouble.eliminar(elimin))
				error=true;
		}
		repaint();
	}
	public void eliminarNumeroComplejo(NumeroComplejo elimin){
		if (arbolNumeroComplejo == null)
			error=true;
		else{
			if(!arbolNumeroComplejo.eliminar(elimin))
				error=true;
		}
		repaint();
	}
	
	public void recorridoString(Nodo<String> raiz,Graphics g,int x,int y,int vez){
		int x1,y1,vez1;
		Circulo circulo = new Circulo();
		circulo.setAlto(50);
		circulo.setAncho(100);
		circulo.setFontSize(12);
		circulo.setMessage(raiz.getInfo());
		g.setColor(new Color(90,172,53));
		circulo.dibujar(g,x,y);
		if (raiz.getNextNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.RIGHT);
			linea.setX(175-((int)(175*.30*vez)),50);
			linea.setY(25,50);
			g.setColor(new Color(188,143,143));
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1+=(175-((int)(175*.30*vez)));
			y1+=75;
			vez1=vez;
			vez1++;
			recorridoString(raiz.getNextNodo(),g,x1,y1,vez1);
		}
		if (((NodoDoble)raiz).getPreviewNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.LEFT);
			linea.setX(175-((int)(175*(.30*vez))),50);
			linea.setY(25,50);
			g.setColor(new Color(188,143,143));
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1-=(175-((int)(175*.30*vez)));
			y1+=75;
			vez1=vez;
			vez1++;
			recorridoString(((NodoDoble<String>)raiz).getPreviewNodo(),g,x1,y1,vez1);
		}
	}
	public void recorridoInteger(Nodo<Integer> raiz,Graphics g,int x,int y,int vez){
		int x1,y1,vez1;
		Circulo circulo = new Circulo();
		circulo.setAlto(50);
		circulo.setAncho(100);
		circulo.setFontSize(12);
		circulo.setMessage(String.valueOf(raiz.getInfo()));
		g.setColor(new Color(90,172,53));
		circulo.dibujar(g,x,y);
		if (raiz.getNextNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.RIGHT);
			linea.setX(175-((int)(175*.30*vez)),50);
			linea.setY(25,50);
			g.setColor(new Color(188,143,143));
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1+=(175-((int)(175*.30*vez)));
			y1+=75;
			vez1=vez;
			vez1++;
			recorridoInteger(raiz.getNextNodo(),g,x1,y1,vez1);
		}
		if (((NodoDoble)raiz).getPreviewNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.LEFT);
			linea.setX(175-((int)(175*.30*vez)),50);
			linea.setY(25,50);
			g.setColor(new Color(188,143,143));
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1-=(175-((int)(175*.30*vez)));
			y1+=75;
			vez1=vez;
			vez1++;
			recorridoInteger(((NodoDoble<Integer>)raiz).getPreviewNodo(),g,x1,y1,vez1);
		}
	}
	public void recorridoDouble(Nodo<Double> raiz,Graphics g,int x,int y,int vez){
		int x1,y1,vez1;
		Circulo circulo = new Circulo();
		circulo.setAlto(50);
		circulo.setAncho(100);
		circulo.setFontSize(12);
		circulo.setMessage(String.valueOf(raiz.getInfo()));
		g.setColor(new Color(90,172,53));
		circulo.dibujar(g,x,y);
		if (raiz.getNextNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.RIGHT);
			linea.setX(175-((int)(175*.30*vez)),50);
			linea.setY(25,50);
			g.setColor(new Color(188,143,143));
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1+=(175-((int)(175*.30*vez)));
			y1+=75;
			vez1=vez;
			vez1++;
			recorridoDouble(raiz.getNextNodo(),g,x1,y1,vez1);
		}
		if (((NodoDoble)raiz).getPreviewNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.LEFT);
			linea.setX(175-((int)(175*.30*vez)),50);
			linea.setY(25,50);
			g.setColor(new Color(188,143,143));
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1-=(175-((int)(175*.30*vez)));
			y1+=75;
			vez1=vez;
			vez1++;
			recorridoDouble(((NodoDoble<Double>)raiz).getPreviewNodo(),g,x1,y1,vez1);
		}
	}
	public void recorridoNumeroComplejo(Nodo<NumeroComplejo> raiz,Graphics g,int x,int y,int vez){
		int x1,y1,vez1;
		Circulo circulo = new Circulo();
		circulo.setAlto(50);
		circulo.setAncho(100);
		circulo.setFontSize(12);
		circulo.setMessage(String.valueOf(raiz.getInfo()));
		g.setColor(new Color(90,172,53));
		circulo.dibujar(g,x,y);
		if (raiz.getNextNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.RIGHT);
			linea.setX(175-((int)(175*.30*vez)),50);
			linea.setY(25,50);
			g.setColor(new Color(188,143,143));
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1+=(175-((int)(175*.30*vez)));
			y1+=75;
			vez1=vez;
			vez1++;
			recorridoNumeroComplejo(raiz.getNextNodo(),g,x1,y1,vez1);
		}
		if (((NodoDoble)raiz).getPreviewNodo() != null){
			Linea linea = new Linea();
			linea.setCual(linea.LEFT);
			linea.setX(175-((int)(175*.30*vez)),50);
			linea.setY(25,50);
			g.setColor(new Color(188,143,143));
			linea.dibujar(g,x,y);
			x1=x;
			y1=y;
			x1-=(175-((int)(175*.30*vez)));
			y1+=75;
			vez1=vez;
			vez1++;
			recorridoNumeroComplejo(((NodoDoble<NumeroComplejo>)raiz).getPreviewNodo(),g,x1,y1,vez1);
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
}
