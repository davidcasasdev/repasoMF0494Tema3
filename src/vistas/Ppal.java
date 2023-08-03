package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import excepciones.BBDDException;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ppal extends JFrame {

	private JPanel contentPane;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ppal frame = new Ppal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ppal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][]", "[]"));
		
		JButton btnNewButton = new JButton("Mostrar Ciudades");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.muestraCiudades();
				} catch (BBDDException e1) {
					JOptionPane.showMessageDialog(contentPane, 
							"Error recogiendo los datos de la BBDD",
							"No se han obtenido datos", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(btnNewButton, "cell 0 0");
		
		JButton btnNewButton_1 = new JButton("Mostrar Dialogo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.MostrarDialogo();
				} catch (BBDDException e1) {
					JOptionPane.showMessageDialog(contentPane, 
							"Error recogiendo los datos de la BBDD",
							"No se han obtenido datos", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(btnNewButton_1, "cell 2 0");
	}

	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
		
	}

}
