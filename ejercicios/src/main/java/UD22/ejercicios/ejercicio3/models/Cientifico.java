package UD22.ejercicios.ejercicio3.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cientifico {
	private String dni;
	private String nomApels;


	public Cientifico(String dni, String nomApels) {
		this.dni = dni;
		this.nomApels = nomApels;
	}

	public Cientifico() {	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}

	@Override
	public String toString() {
		return "Cientifico [dni=" + dni + ", nomApels=" + nomApels + "]";
	}
}
