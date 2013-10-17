package arbol;
import nodo.Nodo;
public abstract class Arbol<T>{
	public T NODORAIZ;
	public Arbol(T raiz){NODORAIZ =raiz;}
	public abstract boolean insertar(T info);
	public abstract boolean eliminar(T info);
	public abstract Nodo<T> buscar(T info);
	public abstract String preOrder(Nodo<T> raiz);
	public abstract String inOrder(Nodo<T> raiz);
	public abstract String posOrder(Nodo<T> raiz);
}
