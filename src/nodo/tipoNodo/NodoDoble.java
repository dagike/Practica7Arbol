package nodo.tipoNodo;
import nodo.Nodo;
public class NodoDoble<T> extends Nodo<T>{
	private Nodo<T> previewNodo;
	public NodoDoble(T info){super(info);}
	public void setPreviewNodo(Nodo<T> previewNodo){
		this.previewNodo=previewNodo;
	}
	public Nodo<T> getPreviewNodo(){
		return previewNodo;
	}
}
