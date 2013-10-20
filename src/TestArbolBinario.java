import numero.NumeroComplejo;
import arbol.arbolBinario.ArbolBinario;
public class TestArbolBinario{
	public static void main(String args[]){
		ArbolBinario<String> arbol;
		//int menu;
		arbol=new ArbolBinario<>("F");
		arbol.insertar("b");
		arbol.insertar("G");
		arbol.insertar("A");
		arbol.insertar("D");
		arbol.insertar("C");
		arbol.insertar("e");
		arbol.insertar("i");
		arbol.insertar("H");
		arbol.insertar("J");
		arbol.eliminar("D");
		System.out.println("\n"+arbol.inOrder(arbol.getRaiz()));
		
		/*ArbolBinario<Integer> arbol;
		//int menu;
		arbol=new ArbolBinario<>(6);
		arbol.insertar(2);
		arbol.insertar(7);
		arbol.insertar(1);
		arbol.insertar(4);
		arbol.insertar(3);
		arbol.insertar(5);
		arbol.insertar(9);
		arbol.insertar(8);
		arbol.insertar(10);
		arbol.eliminar(2);
		System.out.println("\n"+arbol.inOrder(arbol.getRaiz()));*/
		
		/*ArbolBinario<Double> arbol;
		//int menu;
		arbol=new ArbolBinario<>(6.0);
		arbol.insertar(2.0);
		arbol.insertar(7.0);
		arbol.insertar(1.0);
		arbol.insertar(4.0);
		arbol.insertar(3.0);
		arbol.insertar(5.0);
		arbol.insertar(9.0);
		arbol.insertar(8.0);
		arbol.insertar(10.0);
		arbol.eliminar(7.0);
		System.out.println("\n"+arbol.inOrder(arbol.getRaiz()));*/
		
		/*ArbolBinario<NumeroComplejo> arbol;
		//int menu;
		NumeroComplejo ins = new NumeroComplejo();
		ins.setParteImaginaria(6.0);
		ins.setParteReal(2.0);
		arbol=new ArbolBinario<>(ins);
		ins = new NumeroComplejo();
		ins.setParteImaginaria(2.0);
		ins.setParteReal(2.0);
		arbol.insertar(ins);
		ins = new NumeroComplejo();
		ins.setParteImaginaria(7.0);
		ins.setParteReal(2.0);
		arbol.insertar(ins);
		ins = new NumeroComplejo();
		ins.setParteImaginaria(1.0);
		ins.setParteReal(2.0);
		arbol.insertar(ins);
		ins = new NumeroComplejo();
		ins.setParteImaginaria(4.0);
		ins.setParteReal(2.0);
		arbol.insertar(ins);
		ins = new NumeroComplejo();
		ins.setParteImaginaria(3.0);
		ins.setParteReal(2.0);
		arbol.insertar(ins);
		ins = new NumeroComplejo();
		ins.setParteImaginaria(5.0);
		ins.setParteReal(2.0);
		arbol.insertar(ins);
		ins = new NumeroComplejo();
		ins.setParteImaginaria(9.0);
		ins.setParteReal(2.0);
		arbol.insertar(ins);
		ins = new NumeroComplejo();
		ins.setParteImaginaria(8.0);
		ins.setParteReal(2.0);
		arbol.insertar(ins);
		ins = new NumeroComplejo();
		ins.setParteImaginaria(10.0);
		ins.setParteReal(2.0);
		arbol.insertar(ins);
		ins = new NumeroComplejo();
		ins.setParteImaginaria(10.0);
		ins.setParteReal(2.0);
		arbol.eliminar(ins);
		System.out.println("\n"+arbol.inOrder(arbol.getRaiz()));*/
	}
}
