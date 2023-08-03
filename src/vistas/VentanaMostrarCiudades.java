package vistas;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.City;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMostrarCiudades extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMostrarCiudades frame = new VentanaMostrarCiudades();
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
	public VentanaMostrarCiudades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Listado de Ciudades:");
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Ciudad", "Nombre", "C\u00F3digo Pa\u00EDs", "Distrito", "Poblaci\u00F3n"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Long.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton, "cell 0 2");
	}

	public void setControlador(Controlador controlador) {
		this.controlador= controlador;
		
	}

	public void setListaCiudades(ArrayList<City> lista) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		modelo.setRowCount(0);
		for (City c : lista) {
			Object f  [] = {
					c.getId(), c.getNombre(),c.getCodigoPais(),
					c.getDistrito(),c.getHabitantes()
			};
			modelo.addRow(f);
		}

	}

}
