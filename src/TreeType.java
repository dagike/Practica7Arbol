import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import nodo.tipoNodo.NodoDoble;
import numero.NumeroComplejo;
import arbol.arbolBinario.ArbolBinario;

public class TreeType extends JPanel {
	private JRadioButton buttonInteger, buttonString, buttonDouble,
			buttonNumeroComplejo;
	private JButton buttonAdd, buttonDelete;
	private TreePaint dibujo;
	private JTextField textField;
	private JPanel left;
	private ArbolBinario<String> arbolString;
	private ArbolBinario<Integer> arbolInteger;
	private ArbolBinario<Double> arbolDouble;
	private ArbolBinario<NumeroComplejo> arbolNumeroComplejo;
	private int estado;
	private String buscar;

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
	}

	private class Accion implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buscar = textField.getText();
			if (e.getSource() == buttonString) {
				estado = 0;
				left.setVisible(false);
			} else if (e.getSource() == buttonInteger) {
				estado = 1;
				left.setVisible(false);
			} else if (e.getSource() == buttonDouble) {
				estado = 2;
				left.setVisible(true);
			} else if (e.getSource() == buttonNumeroComplejo) {
				estado = 3;
				left.setVisible(true);
			} else if(!textField.getText().equals("")){
				if (e.getSource() == buttonAdd) {
					if (estado == 0) {
						if (arbolString == null)
							arbolString = new ArbolBinario<>(buscar);
						else
							arbolString.insertar(buscar);
						dibujo.position(String.valueOf(arbolString.buscar(buscar).getInfo()), arbolString.buscar(buscar).getNivel(), arbolString.buscar(buscar).getNumero());
						dibujo.setUpdate(true);
					} else if (estado == 1) {
						if (arbolInteger == null)
							arbolInteger = new ArbolBinario<>(Integer.valueOf(textField.getText()));
						else
							arbolInteger.insertar(Integer.valueOf(textField.getText()));
					} else if (estado == 2) {
						if (arbolDouble == null)
							arbolDouble = new ArbolBinario<>(Double.valueOf(textField.getText()));
						else
							arbolDouble.insertar(Double.valueOf(textField.getText()));
					} 
						left.setVisible(true);
					} else if (e.getSource() == buttonDelete) {
						arbolString.eliminar(textField.getText());
						left.setVisible(true);
					}
			}
		}
	}
}
