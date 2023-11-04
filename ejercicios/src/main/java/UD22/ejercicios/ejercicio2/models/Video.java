package UD22.ejercicios.ejercicio2.models;

public class Video {
	private int id;
	private static int counter = 0;
	private String title;
	private String director;
	private int clientId;
	
	
	public Video(String title, String director, int clientId) {
		counter++;
		this.id = counter;
		this.title = title;
		this.director = director;
		this.clientId = clientId;
	}
	
	public Video() {	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setId() {
		counter++;
		this.id = counter;	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

}
