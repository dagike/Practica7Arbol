package interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GraphicTree extends JFrame {

	private JPanel contentPane;
	private ButtonGroup tipoDeDato = new ButtonGroup();
	private ButtonGroup opcionesArbol = new ButtonGroup();
	private JTextField espacioDatos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// try {
				GraphicTree frame = new GraphicTree();
				frame.setVisible(true);
				// } catch (Exception e) {
				// e.printStackTrace();
				// }
			}
		});
	}

	public GraphicTree() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(800, 400, 20, 20));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout contentPaneGBC = new GridBagLayout();
		contentPaneGBC.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		contentPaneGBC.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		contentPaneGBC.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPaneGBC.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(contentPaneGBC);

		JPanel tipos = new JPanel();
		GridBagConstraints tiposGBC = new GridBagConstraints();
		tiposGBC.gridwidth = 5;
		tiposGBC.insets = new Insets(0, 0, 5, 5);
		tiposGBC.fill = GridBagConstraints.BOTH;
		tiposGBC.gridx = 0;
		tiposGBC.gridy = 0;
		contentPane.add(tipos, tiposGBC);
		tipos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JRadioButton buttonString = new JRadioButton("String");
		buttonString.setSelected(true);
		tipoDeDato.add(buttonString);
		tipos.add(buttonString);

		JRadioButton buttonInteger = new JRadioButton("Integer");
		tipoDeDato.add(buttonInteger);
		tipos.add(buttonInteger);

		JRadioButton buttonDouble = new JRadioButton("Double");
		tipoDeDato.add(buttonDouble);
		tipos.add(buttonDouble);

		JRadioButton buttonNumerocomplejo = new JRadioButton("NumeroComplejo");
		tipoDeDato.add(buttonNumerocomplejo);
		tipos.add(buttonNumerocomplejo);

		JPanel arbolOperaciones = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		contentPane.add(arbolOperaciones, gbc_panel_3);
		arbolOperaciones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JRadioButton rdbtnAgregar = new JRadioButton("Agregar");
		opcionesArbol.add(rdbtnAgregar);
		arbolOperaciones.add(rdbtnAgregar);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Eliminar");
		opcionesArbol.add(rdbtnNewRadioButton);
		arbolOperaciones.add(rdbtnNewRadioButton);

		JRadioButton rdbtnBuscar = new JRadioButton("Buscar");
		opcionesArbol.add(rdbtnBuscar);
		arbolOperaciones.add(rdbtnBuscar);

		espacioDatos = new JTextField();
		GridBagConstraints espacioDatosGBC = new GridBagConstraints();
		espacioDatosGBC.gridwidth = 2;
		espacioDatosGBC.insets = new Insets(0, 0, 5, 5);
		espacioDatosGBC.fill = GridBagConstraints.HORIZONTAL;
		espacioDatosGBC.gridx = 1;
		espacioDatosGBC.gridy = 1;
		contentPane.add(espacioDatos, espacioDatosGBC);
		espacioDatos.setColumns(10);

		JPanel recorridos = new JPanel();
		GridBagConstraints recorridosGBC = new GridBagConstraints();
		recorridosGBC.gridwidth = 2;
		recorridosGBC.insets = new Insets(0, 0, 5, 5);
		recorridosGBC.fill = GridBagConstraints.BOTH;
		recorridosGBC.gridx = 3;
		recorridosGBC.gridy = 1;
		contentPane.add(recorridos, recorridosGBC);
		recorridos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnInorder = new JButton("Inorder");
		recorridos.add(btnInorder);

		JButton btnPosorder = new JButton("Posorder");
		recorridos.add(btnPosorder);

		JButton btnPreorder = new JButton("Preorder");
		recorridos.add(btnPreorder);

		JPanel dibujoArbol = new JPanel();
		dibujoArbol.setBackground(Color.WHITE);
		GridBagConstraints dibujoArbolGBC = new GridBagConstraints();
		dibujoArbolGBC.insets = new Insets(0, 0, 0, 5);
		dibujoArbolGBC.gridheight = 2;
		dibujoArbolGBC.gridwidth = 5;
		dibujoArbolGBC.fill = GridBagConstraints.BOTH;
		dibujoArbolGBC.gridx = 0;
		dibujoArbolGBC.gridy = 2;
		contentPane.add(dibujoArbol, dibujoArbolGBC);
		dibujoArbol.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

}
