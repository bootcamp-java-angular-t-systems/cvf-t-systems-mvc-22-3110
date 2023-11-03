package UD22.ejercicios.ejercicio2.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	private int id;
	private static int counter = 0;
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	private String fecha;

	public Cliente(String nombre, String apellido, String direccion, int dni) {
		counter++;
		this.id = counter;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.dni = dni;
		this.fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	public Cliente() {	}

	public int getId() {
		return id;
	}

	public void setId() {
		counter++;
		this.id = counter;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void setFecha() {
		this.fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", dni=" + dni + "]";
	}

}
