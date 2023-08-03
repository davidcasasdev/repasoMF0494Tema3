package modelo;

import java.util.Objects;

public class City {

	private int id;
	private String nombre;
	private String codigoPais;
	private String distrito;
	private long habitantes;
	
	public City() {
		super();
		this.id = 0;
		this.nombre = "";
		this.codigoPais = "";
		this.distrito ="";
		this.habitantes = 0;
	}
	
	public City(int id, String nombre, String codigoPais, String distrito, long habitantes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigoPais = codigoPais;
		this.distrito = distrito;
		this.habitantes = habitantes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public long getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(long habitantes) {
		this.habitantes = habitantes;
	}

	

	@Override
	public String toString() {
		return id + " - " + nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
