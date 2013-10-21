package arbol.arbolBinario;

import arbol.Arbol;
import nodo.Nodo;
import nodo.tipoNodo.NodoDoble;

import java.lang.NullPointerException;

public class ArbolBinario<T> extends Arbol<T> {
	private Nodo<T> nodoDoble;

	public ArbolBinario(T raiz) {
		super(raiz);
		nodoDoble = new NodoDoble<>(raiz);
		nodoDoble.setNumero(1);
		nodoDoble.setNivel(0);
	}
	public Nodo<T> getRaiz() {
		return nodoDoble;
	}

	public boolean insertar(T info) {
		if ((buscar(info)) != null)
			return false;
		else {
			int numero = 1, nivel = 0;
			Nodo<T> temp = nodoDoble, antes = null;
			try {
				while (!info.equals(temp.getInfo())) {
					if (temp.compareTo(info) < 0) {
						numero = (numero * 2) - 1;
						antes = temp;
						temp = ((NodoDoble<T>) temp).getPreviewNodo();
					} else {
						numero = numero * 2;
						antes = temp;
						temp = temp.getNextNodo();
					}
					nivel++;
				}
			}catch(NullPointerException e) {
			}
			temp = new NodoDoble<T>(info);
			temp.setNivel(nivel);
			if (antes.compareTo(info) < 0) {
				((NodoDoble<T>) antes).setPreviewNodo(temp);
				temp.setNumero(numero);
			} else {
				antes.setNextNodo(temp);
				temp.setNumero(numero);
			}
			return true;
		}
	}

	public boolean eliminar(T info) {
		if (info.equals(nodoDoble.getInfo())) {
			System.out.println("Pertenece a la Raiz no puede ser eliminado");
			return false;
		} else {
			Nodo<T> temp = nodoDoble;
			Nodo<T> temp2 = nodoDoble;
			try {
				while (!info.equals(temp.getInfo())) {
					temp2 = temp;
					if (temp.compareTo(info) < 0)
						temp = ((NodoDoble<T>) temp).getPreviewNodo();
					else
						temp = temp.getNextNodo();
				}
			} catch (NullPointerException e) {
				return false;
			}
			if (((NodoDoble<T>) temp2).getPreviewNodo() == temp) {
				if (((NodoDoble<T>) temp).getPreviewNodo() == null
						&& temp.getNextNodo() == null) {// es una hoja
					((NodoDoble<T>) temp2).setPreviewNodo(null);
					return true;
				}

				if (((NodoDoble<T>) temp).getPreviewNodo() == null
						|| temp.getNextNodo() == null) {// tiene solo un hijo
					if (((NodoDoble<T>) temp).getNextNodo() == null){
						((NodoDoble<T>) temp2)
								.setPreviewNodo(((NodoDoble<T>) temp)
										.getPreviewNodo());
						((NodoDoble<T>) temp).getPreviewNodo().setNivel(temp.getNivel());
						((NodoDoble<T>) temp).getPreviewNodo().setNumero(temp.getNumero());
					}
					else{
						((NodoDoble<T>) temp2).setPreviewNodo(temp.getNextNodo());
						temp.getNextNodo().setNivel(temp.getNivel());
						temp.getNextNodo().setNumero(temp.getNumero());
					}
					modificarHijos(((NodoDoble<T>) temp2).getPreviewNodo());
					return true;
				} else {
					Nodo<T> temp3 = temp;
					while (((NodoDoble<T>) temp3).getPreviewNodo() != null
							&& temp3.getNextNodo() != null) {
						if (((NodoDoble<T>) temp3).getPreviewNodo() == null)
							temp3 = temp3.getNextNodo();
						else
							temp3 = ((NodoDoble<T>) temp3).getPreviewNodo();
					}
					eliminar(temp3.getInfo());
					((NodoDoble<T>) temp2).setPreviewNodo(temp3);
					temp3.setNextNodo(temp.getNextNodo());
					((NodoDoble<T>) temp3).setPreviewNodo(((NodoDoble<T>) temp)
							.getPreviewNodo());
					temp3.setNivel(temp.getNivel());
					temp3.setNumero(temp.getNumero());
					modificarHijos(temp3);
					return true;
				}
			}

			else {
				if (((NodoDoble<T>) temp).getPreviewNodo() == null
						&& temp.getNextNodo() == null) {// Es una hoja
					temp2.setNextNodo(null);
					return true;
				}

				if (((NodoDoble<T>) temp).getPreviewNodo() == null
						|| temp.getNextNodo() == null) {
					if (((NodoDoble<T>) temp).getNextNodo() == null){
						temp2.setNextNodo(((NodoDoble<T>) temp)
								.getPreviewNodo());
						((NodoDoble<T>) temp).getPreviewNodo().setNivel(temp.getNivel());
						((NodoDoble<T>) temp).getPreviewNodo().setNumero(temp.getNumero());
					}
					else{
						temp2.setNextNodo(temp.getNextNodo());
						temp.getNextNodo().setNivel(temp.getNivel());
						temp.getNextNodo().setNumero(temp.getNumero());
					}
					modificarHijos(temp2.getNextNodo());
					return true;
				} else {
					Nodo<T> temp3 = temp;
					while (((NodoDoble<T>) temp3).getPreviewNodo() != null
							&& temp3.getNextNodo() != null) {
						if (((NodoDoble<T>) temp3).getNextNodo() != null)
							temp3 = temp3.getNextNodo();
						else
							temp3 = ((NodoDoble<T>) temp3).getPreviewNodo();
					}
					eliminar(temp3.getInfo());
					((NodoDoble<T>) temp2).setNextNodo(temp3);
					temp3.setNextNodo(temp.getNextNodo());
					((NodoDoble<T>) temp3).setPreviewNodo(((NodoDoble<T>) temp)
							.getPreviewNodo());
					temp3.setNivel(temp.getNivel());
					temp3.setNumero(temp.getNumero());
					modificarHijos(temp3);
					return true;
				}
			}
		}
	}

	public Nodo<T> buscar(T info) {
		if (info.equals(NODORAIZ)) {
			return nodoDoble;
		} else {
			Nodo<T> temp = nodoDoble;
			try {
				while (!info.equals(temp.getInfo())) {
					if (temp.compareTo(info) < 0)
						temp = ((NodoDoble<T>) temp).getPreviewNodo();
					else
						temp = temp.getNextNodo();
				}
			} catch (NullPointerException e) {
			}
			return temp;
		}
	}
	
	public void modificarHijos(Nodo<T> temp) {
		if  (((NodoDoble<T>) temp).getPreviewNodo() != null){
			((NodoDoble<T>) temp).getPreviewNodo().setNivel(temp.getNivel() + 1);
			((NodoDoble<T>) temp).getPreviewNodo().setNumero((temp.getNumero() * 2) - 1);
			modificarHijos(((NodoDoble<T>)temp).getPreviewNodo());
		} 
		
		if (temp.getNextNodo() != null){
			temp.getNextNodo().setNivel(temp.getNivel() + 1);
			temp.getNextNodo().setNumero(temp.getNumero() * 2);
			modificarHijos(temp = temp.getNextNodo());
		}
	}

	public String preOrder(Nodo<T> raiz) {
		String s = "";
		s += raiz.getInfo() + "\n";
		if (((NodoDoble<T>) raiz).getPreviewNodo() != null) {
			s += preOrder(((NodoDoble<T>) raiz).getPreviewNodo());
		}
		if (raiz.getNextNodo() != null) {
			s += preOrder(raiz.getNextNodo());
		}
		return s;
	}

	public String inOrder(Nodo<T> raiz) {
		String s = "";
		if (((NodoDoble<T>) raiz).getPreviewNodo() != null)
			s += inOrder(((NodoDoble<T>) raiz).getPreviewNodo());
		s += raiz.getInfo() + "\n";
		if (raiz.getNextNodo() != null)
			s += inOrder(raiz.getNextNodo());
		return s;
	}

	public String posOrder(Nodo<T> raiz) {
		String s = "";
		if (((NodoDoble<T>) raiz).getPreviewNodo() != null)
			s += posOrder(((NodoDoble<T>) raiz).getPreviewNodo());
		if (raiz.getNextNodo() != null)
			s += posOrder(raiz.getNextNodo());
		s += raiz.getInfo() + "\n";
		return s;
	}
}
