package UD22.ejercicios.ejercicio3.models;

public class Asignado_A {
	
	private String cientifico;
	private String proyecto;
	
	
	
	public Asignado_A(String cientifico, String proyecto) {
		this.cientifico = cientifico;
		this.proyecto = proyecto;
	}
	
	
	public Asignado_A() {
	}



	public String getCientifico() {
		return cientifico;
	}
	public void setCientifico(String cientifico) {
		this.cientifico = cientifico;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	
	

}
