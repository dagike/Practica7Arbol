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
					boolean band = true;int count,count2;
					switch(estado){
						case 0:dibujo.agregarString(String.valueOf(textField.getText()));break;
						case 1:
							band=true;count=0;
							for(int i = 0 ; i<String.valueOf(textField.getText()).length()&&band; i++){
								if(String.valueOf(textField.getText()).charAt(i) < '0' || String.valueOf(textField.getText()).charAt(i) > '9'){
									if(String.valueOf(textField.getText()).charAt(i) != '-')
										band=false;
									else
										count++;
								}
							}
							if(band&&count<2)
								dibujo.agregarInteger(Integer.valueOf(textField.getText()));
							else
								System.out.println("Solo Numeros");
						break;
						case 2:
							count=0;band=true;count2=0;
							for(int i = 0 ; i < String.valueOf(textField.getText()).length()&&band; i++){
								if((String.valueOf(textField.getText()).charAt(i) < '0' || String.valueOf(textField.getText()).charAt(i) > '9')){
									if(String.valueOf(textField.getText()).charAt(i) == '.')
										count++;
									else if(String.valueOf(textField.getText()).charAt(i) != '-')
										count2++;
									else
										band=false;
								}
							}
							if(band&&count<2&&count2<2)
								dibujo.agregarDouble(Double.valueOf(textField.getText()));
							else
								System.out.println("Solo Numeros");
						break;
						case 3:
							int count3=0,count4=0,hasta=0;
							count = 0; count2 = 0;band=true;boolean digito=true;
							if(String.valueOf(textField.getText()).endsWith("i")){
								for(int i = 0 ; i< String.valueOf(textField.getText()).length()-1; i++){
									if(String.valueOf(textField.getText()).charAt(i) < '0' || textField.getText().charAt(i) > '9' || String.valueOf(textField.getText()).charAt(i) != '.')
										if(String.valueOf(textField.getText()).charAt(i) == '.'){
											if(digito)
												count++;
											else
												count3++;
										}
										else if(String.valueOf(textField.getText()).charAt(i) == '+'||String.valueOf(textField.getText()).charAt(i) == '-'){
											if(digito){
												count2++;
												hasta=i;
												if(i>0)
													digito=false;
											}
											else
												count4++;
										}
										else if(String.valueOf(textField.getText()).charAt(i) < '0' || textField.getText().charAt(i) > '9' )
											band = false; 
								}
							}
							else
								band = false;
						
							if(band && count < 2 && count2 <3 && count3 <2 && count4 < 1){
								String parteReal = String.valueOf(textField.getText()).substring(0, hasta);
								String parteImaginaria = String.valueOf(textField.getText()).substring(hasta, String.valueOf(textField.getText()).lastIndexOf("i"));
								NumeroComplejo numeroComplejo = new NumeroComplejo(Double.valueOf(parteReal),Double.valueOf(parteImaginaria));
								dibujo.agregarNumeroComplejo(numeroComplejo);
							}
							else
								System.out.println("Error Formato: 1+5i");
						break;
					}
				}
				else if (e.getSource() == buttonDelete) {
					boolean band = true;int count,count2;
					switch(estado){
						case 0:dibujo.eliminarString(String.valueOf(textField.getText()));break;
						case 1:
							band=true;count=0;
							for(int i = 0 ; i<String.valueOf(textField.getText()).length()&&band; i++){
								if(String.valueOf(textField.getText()).charAt(i) < '0' || String.valueOf(textField.getText()).charAt(i) > '9'){
									if(String.valueOf(textField.getText()).charAt(i) != '-')
										band=false;
									else
										count++;
								}
							}
							if(band&&count<2)
								dibujo.eliminarInteger(Integer.valueOf(textField.getText()));
							else
								System.out.println("Solo Numeros");
						break;
						case 2:
							count=0;band=true;count2=0;
							for(int i = 0 ; i < String.valueOf(textField.getText()).length()&&band; i++){
								if((String.valueOf(textField.getText()).charAt(i) < '0' || String.valueOf(textField.getText()).charAt(i) > '9')){
									if(String.valueOf(textField.getText()).charAt(i) == '.')
										count++;
									else if(String.valueOf(textField.getText()).charAt(i) != '-')
										count2++;
									else
										band=false;
								}
							}
							if(band&&count<2&&count2<2)
								dibujo.eliminarDouble(Double.valueOf(textField.getText()));
							else
								System.out.println("Solo Numeros");
						break;
						case 3:
							int count3=0,count4=0,hasta=0;
							count = 0; count2 = 0;band=true;boolean digito=true;
							if(String.valueOf(textField.getText()).endsWith("i")){
								for(int i = 0 ; i< String.valueOf(textField.getText()).length()-1; i++){
									if(String.valueOf(textField.getText()).charAt(i) < '0' || textField.getText().charAt(i) > '9' || String.valueOf(textField.getText()).charAt(i) != '.')
										if(String.valueOf(textField.getText()).charAt(i) == '.'){
											if(digito)
												count++;
											else
												count3++;
										}
										else if(String.valueOf(textField.getText()).charAt(i) == '+'||String.valueOf(textField.getText()).charAt(i) == '-'){
											if(digito){
												count2++;
												hasta=i;
												if(i>0)
													digito=false;
											}
											else
												count4++;
										}
										else if(String.valueOf(textField.getText()).charAt(i) < '0' || textField.getText().charAt(i) > '9' )
											band = false; 
								}
							}
							else
								band = false;
						
							if(band && count < 2 && count2 <3 && count3 <2 && count4 < 1){
								String parteReal = String.valueOf(textField.getText()).substring(0, hasta);
								String parteImaginaria = String.valueOf(textField.getText()).substring(hasta, String.valueOf(textField.getText()).lastIndexOf("i"));
								NumeroComplejo numeroComplejo = new NumeroComplejo(Double.valueOf(parteReal),Double.valueOf(parteImaginaria));
								dibujo.eliminarNumeroComplejo(numeroComplejo);
							}
							else
								System.out.println("Error Formato: 1+5i");
						break;
					}
				}	
			}
		}
	}
}
