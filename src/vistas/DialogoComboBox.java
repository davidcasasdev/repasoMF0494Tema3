package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.City;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoComboBox extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbMenos1M;
	private JRadioButton rdbMas1M;
	private JComboBox comboBox;
	private JSpinner spinner;
	
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoComboBox dialog = new DialogoComboBox();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoComboBox() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][][][grow]"));
		{
			JLabel lblNewLabel = new JLabel("Listado de ciudades");
			contentPanel.add(lblNewLabel, "cell 0 1,alignx trailing");
		}
		{
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizaCampos();
				}
			});
			contentPanel.add(comboBox, "cell 1 1 2 1,growx");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Población:");
			contentPanel.add(lblNewLabel_1, "cell 0 2");
		}
		{
			spinner = new JSpinner();
			contentPanel.add(spinner, "cell 1 2 2 1");
		}
		{
			rdbMenos1M = new JRadioButton("menos de 1 Millón");
			buttonGroup.add(rdbMenos1M);
			contentPanel.add(rdbMenos1M, "cell 1 3");
		}
		{
			rdbMas1M = new JRadioButton("Más de un millón");
			buttonGroup.add(rdbMas1M);
			contentPanel.add(rdbMas1M, "cell 2 3");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void setListaCiudades(ArrayList<City> lista) {
		
		comboBox.removeAll();
		for (City city : lista) {
			comboBox.addItem(city);
		}
		actualizaCampos();
	}

	private void actualizaCampos() {
		
		City ciudad = (City) comboBox.getSelectedItem();
		
		spinner.setValue(ciudad.getHabitantes());
		if (ciudad.getHabitantes()<1000000) {
			this.rdbMenos1M.setSelected(true);
		} else {
			this.rdbMas1M.setSelected(true);
		}
	}

	
}
