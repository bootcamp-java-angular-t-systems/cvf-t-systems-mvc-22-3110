package UD22.ejercicios.ejercicio3.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import UD22.ejercicios.conexion.Conexion;
import UD22.ejercicios.ejercicio2.models.Video;

public class ProyectoService {
	private static ProyectoService instance;
	private Conexion conexionEx2;

	private ProyectoService() {
		conexionEx2 = new Conexion("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", "root",
				"contrasenya123");
	}

	public static ProyectoService getInstance() {
		if (instance == null) {
			instance = new ProyectoService();
		}
		return instance;
	}

	public List<Video> findAll() {
		ResultSet resultSet = conexionEx2.getValues("Ejercicio2", "videos");
		List<Video> videos = new ArrayList<>();

		try {
			while (resultSet.next()) {
				Video video = new Video();
				video.setId(resultSet.getInt("id"));
				video.setTitle(resultSet.getString("title"));
				video.setDirector(resultSet.getString("director"));
				video.setClientId(resultSet.getInt("clientId"));
				videos.add(video);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		} finally {
			try {
				resultSet.close();
			} catch (SQLException ex) {
				System.out.println("Error al cerrar el ResultSet: " + ex.getMessage());
			}
		}

		return videos;
	}

	public Optional<Video> findById(int id) {
		ResultSet resultSet = conexionEx2.getById("Ejercicio2", "videos", id);
		Video video = null;

		try {
			while (resultSet.next()) {
				video = new Video();
				video.setId(resultSet.getInt("id"));
				video.setTitle(resultSet.getString("title"));
				video.setDirector(resultSet.getString("director"));
				video.setClientId(resultSet.getInt("clientId"));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		} finally {
			try {
				resultSet.close();
			} catch (SQLException ex) {
				System.out.println("Error al cerrar el ResultSet: " + ex.getMessage());
			}
		}
		return Optional.ofNullable(video);
	}

	public void delete(int id) {
		Optional<Video> video = this.findById(id);
		if (video.isPresent()) {
			conexionEx2.delete("Ejercicio2", "videos", video.get().getId());
	    }
	}
	
	public Optional<Video> update(Video video, String primaryKey) {
		Object result = conexionEx2.update("Ejercicio2", video, primaryKey);
		
		if (result != null && result instanceof Video) {
	        return Optional.of((Video) result);
	    } else {
	        return Optional.empty();
	    }
	}
	
	public void create(Video video) {
		conexionEx2.insertData("Ejercicio2", video);
	}

}
