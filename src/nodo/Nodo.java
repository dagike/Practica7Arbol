package nodo;

import numero.NumeroComplejo;

public class Nodo<T>{
	protected T info;
	protected Nodo<T> nextNodo;
	
	public int compareTo(T cmp){
		if(cmp.getClass() == String.class){
			if(String.valueOf(info).compareToIgnoreCase(String.valueOf(cmp)) < 0)
				return 1;
			else
				return -1;
		}else if(cmp.getClass() == Integer.class){
			if(Integer.valueOf(String.valueOf(info)) < Integer.valueOf(String.valueOf(cmp)) )
				return 1;
			else
				return -1;
		}else if(cmp.getClass() == Double.class){ 
			if(Double.valueOf(String.valueOf(info)) < Double.valueOf(String.valueOf(cmp)) )
				return 1;
			else
				return -1;
		}else if(cmp.getClass() == NumeroComplejo.class){
			if( ((NumeroComplejo)info).getParteReal() < ((NumeroComplejo)cmp).getParteReal()){
				return 1;
			}else if( ((NumeroComplejo)info).getParteReal() == ((NumeroComplejo)cmp).getParteReal() && ((NumeroComplejo)info).getParteImaginaria() < ((NumeroComplejo)cmp).getParteImaginaria()){
				return 1;
			}else
				return -1;
				
		}
		return 0;
	}
	public Nodo(T info){this.info = info;}
	public T getInfo(){return this.info;}
	public void setNextNodo(Nodo<T> nextNodo){this.nextNodo = nextNodo;}
	public Nodo<T> getNextNodo(){return this.nextNodo;}
}
