package controlador;

import java.util.ArrayList;

import dao.CityDAO;
import excepciones.BBDDException;
import modelo.City;
import vistas.DialogoComboBox;
import vistas.Ppal;
import vistas.VentanaMostrarCiudades;

public class Controlador {

	// Listado de ventanas
	Ppal ventanaPpal;
	VentanaMostrarCiudades ventanaMostrarCiudad;
	DialogoComboBox dialogoComboBox;
	
	// Listado de los DAO
	CityDAO daoCiudades;
	
	public Controlador() {
		
		// instanciamos la ventana
		this.ventanaPpal = new Ppal();
		this.ventanaMostrarCiudad = new VentanaMostrarCiudades();
		this.dialogoComboBox = new DialogoComboBox();
		
		// Pasamos el controlador a la ventana
		this.ventanaPpal.setControlador(this);
		this.ventanaMostrarCiudad.setControlador(this);
		this.dialogoComboBox.setControlador(this);
		
		// insatanciamos el DAO
		this.daoCiudades = new CityDAO();
	}

	public void inciar() {
		this.ventanaPpal.setVisible(true);
		
	}

	public void muestraCiudades() throws BBDDException {
		ArrayList<City> lista = daoCiudades.getAllCities();
		this.ventanaMostrarCiudad.setListaCiudades(lista);
		this.ventanaMostrarCiudad.setVisible(true);
		
	}

	public void MostrarDialogo() throws BBDDException {
		ArrayList<City> lista = daoCiudades.getAllCities();
		this.dialogoComboBox.setListaCiudades(lista);
		this.dialogoComboBox.setVisible(true);
		
	}
}
