import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import numero.NumeroComplejo;
import arbol.arbolBinario.ArbolBinario;

public class TreeFrame extends JFrame {
	private TreePaint dibujo;
	private TreeType opc;
	private JScrollPane scroll;

	public TreeFrame() {
		super("Arbol Binario");
	}
	public void mostrarFrame() {
		setDefaultLookAndFeelDecorated(true);
		
		dibujo = new TreePaint();
		opc = new TreeType(dibujo);
		dibujo.setPreferredSize(new Dimension(1000,1000));
		dibujo.revalidate();
		scroll= new JScrollPane(dibujo);

		JButton posOrder = new JButton("Posorder"), inOrder = new JButton("Inorder"), preOrder = new JButton("Preorder");
		JPanel pDerecha = new JPanel();
		pDerecha.setLayout(new GridLayout(3, 1));
		pDerecha.add(posOrder);
		pDerecha.add(inOrder);
		pDerecha.add(preOrder);

		posOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dibujo.posOrder();
			}
		});
		
		inOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dibujo.inOrder();
			}
		});

		preOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dibujo.preOrder();
			}
		});
		add(BorderLayout.NORTH, opc);
		add(BorderLayout.EAST, pDerecha);
		add(BorderLayout.CENTER, scroll);
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[]) {
		new TreeFrame().mostrarFrame();
		System.out.println("\n");
	}
}
