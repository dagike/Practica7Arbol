import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import nodo.Nodo;
import nodo.tipoNodo.NodoDoble;
import numero.NumeroComplejo;
import arbol.arbolBinario.ArbolBinario;

public class TreeType extends JPanel {
	private JRadioButton buttonInteger, buttonString, buttonDouble,buttonNumeroComplejo;
	private JButton buttonAdd, buttonDelete;
	private TreePaint dibujo;
	private JTextField textField;
	private JPanel left;
	private int estado;

	public TreeType(TreePaint dibujo) {
		this.dibujo = dibujo;
		JPanel derecha = new JPanel();
		left = new JPanel();

		textField = new JTextField(10);
		textField.addActionListener(new Accion());
		buttonAdd = new JButton("Agregar");
		buttonAdd.addActionListener(new Accion());
		buttonDelete = new JButton("Eliminar");
		buttonDelete.addActionListener(new Accion());
		buttonString = new JRadioButton("String");
		buttonString.setSelected(true);
		buttonString.addActionListener(new Accion());
		buttonInteger = new JRadioButton("Integer");
		buttonInteger.addActionListener(new Accion());
		buttonDouble = new JRadioButton("Double");
		buttonDouble.addActionListener(new Accion());
		buttonNumeroComplejo = new JRadioButton("NumeroComplejo");
		buttonNumeroComplejo.addActionListener(new Accion());

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(buttonString);
		grupo.add(buttonInteger);
		grupo.add(buttonDouble);
		grupo.add(buttonNumeroComplejo);

		derecha.setLayout(new FlowLayout());
		derecha.add(buttonString);
		derecha.add(buttonInteger);
		derecha.add(buttonDouble);
		derecha.add(buttonNumeroComplejo);
		derecha.add(textField);
		derecha.add(buttonAdd);
		derecha.add(buttonDelete);

		left.setLayout(new FlowLayout());
		left.setVisible(false);

		GridBagConstraints posicion = new GridBagConstraints();
		setLayout(new GridBagLayout());

		posicion.gridx = 0;
		posicion.gridy = 0;
		posicion.gridwidth = 2;
		posicion.weightx = 1.0;
		posicion.anchor = GridBagConstraints.WEST;
		add(derecha, posicion);

		posicion.gridx = 2;
		posicion.gridy = 0;
		posicion.weightx = 0.0;
		posicion.gridwidth = 1;
		posicion.insets = new Insets(0, 30, 0, 0);
		add(left, posicion);
		left.setVisible(true);
	}

	private class Accion implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonString) {
				estado=0;
				dibujo.setState(0);
			} else if (e.getSource() == buttonInteger) {
				estado=1;
				dibujo.setState(1);
			} else if (e.getSource() == buttonDouble) {
				estado=2;
				dibujo.setState(2);
			} else if (e.getSource() == buttonNumeroComplejo) {
				estado=3;
				dibujo.setState(3);
			} else if(!textField.getText().equals("")){
				if (e.getSource() == buttonAdd) {
					
					//validacion segun el tipo de dato
					switch(estado){
						case 0:
							dibujo.agregarString(String.valueOf(textField.getText()));
						break;
						case 1:
							for(int i = 0 ; i < String.valueOf(textField.getText()).length() ; i++)
								if(String.valueOf(textField.getText()).charAt(i) < '0' || textField.getText().charAt(i) > '9') 
						break;
						case 2:
							boolean band = true;
							for(int i = 0 ; i < String.valueOf(textField.getText()).length() ; i++)
								if((String.valueOf(textField.getText()).charAt(i) < '0' || textField.getText().charAt(i) > '9'||band)&& String.valueOf(textField.getText()).charAt(i) != '.')
									if(String.valueOf(textField.getText()).charAt(i) == '.')
										band = false;
						break;
						case 3:
							
						
							
					}
				}
				else if (e.getSource() == buttonDelete) {
					switch(estado){
						case 0:dibujo.eliminarString(String.valueOf(textField.getText()));break;
					}
				}	
				/*
				Integer.valueOf(textField.getText())	
					if (estado == 0) {
						if (arbolString == null)
							arbolString = new ArbolBinario<>();
						else
							arbolString.insertar(String.valueOf(textField.getText()));
							System.out.println(treeComplete(arbolString.getRaiz()));
							dibujo.setUpdate(true);
							dibujo.repaint();
							//dibujo.setUpdate(false);
						
					} else if (estado == 1) {
						if (arbolInteger == null)
							arbolInteger = new ArbolBinario<>();
						else
							arbolInteger.insertar(Integer.valueOf(textField.getText()));
						dibujo.position(String.valueOf(arbolInteger.buscar(Integer.valueOf(textField.getText())).getInfo()), arbolInteger.buscar(Integer.valueOf(textField.getText())).getNivel(), arbolInteger.buscar(Integer.valueOf(textField.getText())).getNumero());
						
						dibujo.repaint();
					}else if (estado == 2) {
						if (arbolDouble == null)
							arbolDouble = new ArbolBinario<>(Double.valueOf(textField.getText()));
						else
							arbolDouble.insertar(Double.valueOf(textField.getText()));
						dibujo.position(String.valueOf(arbolDouble.buscar(Double.valueOf(textField.getText())).getInfo()), arbolDouble.buscar(Double.valueOf(textField.getText())).getNivel(), arbolDouble.buscar(Double.valueOf(textField.getText())).getNumero());
						dibujo.setUpdate(true);
						dibujo.repaint();
					} 
						left.setVisible(true);
					} else if (e.getSource() == buttonDelete) {
						arbolString.eliminar(textField.getText());
					}*/
			}
		}
	}
}
