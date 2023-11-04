package UD22.ejercicios.ejercicio3.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import UD22.ejercicios.conexion.Conexion;
import UD22.ejercicios.ejercicio3.models.Proyecto;

public class ProyectoService {
	private static ProyectoService instance;
	private Conexion conexionEx3;

	private ProyectoService() {
		conexionEx3 = new Conexion("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", "root",
				"contrasenya123");
	}

	public static ProyectoService getInstance() {
		if (instance == null)
			instance = new ProyectoService();
		return instance;
	}

	public List<Proyecto> findAll() {
	    ResultSet resultSet = conexionEx3.getValues("Ejercicio3", "proyectos");
	    List<Proyecto> proyectos = new ArrayList<>();

	    try {
	        while (resultSet.next()) {
	            Proyecto proyecto = new Proyecto();
	            proyecto.setId(resultSet.getString("id"));
	            proyecto.setNombre(resultSet.getString("nombre"));
	            proyecto.setHoras(resultSet.getInt("horas"));
	            proyectos.add(proyecto);
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

	    return proyectos;
	}


	public Optional<Proyecto> findById(String id) {
	    ResultSet resultSet = conexionEx3.getById("Ejercicio3", "proyectos", id, "id");
	    Proyecto proyecto = null;

	    try {
	        while (resultSet.next()) {
	            proyecto = new Proyecto();
	            proyecto.setId(resultSet.getString("id"));
	            proyecto.setNombre(resultSet.getString("nombre"));
	            proyecto.setHoras(resultSet.getInt("horas"));
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
	    return Optional.ofNullable(proyecto);
	}


	public void delete(String id) {
		Optional<Proyecto> proyecto = this.findById(id);
		if (proyecto.isPresent()) {
			conexionEx3.delete("Ejercicio3", "proyectos", id, "id");
	    }
	}
	
	public Optional<Proyecto> update(Proyecto proyecto, String primaryKey) {
		Object result = conexionEx3.update("Ejercicio3", proyecto, primaryKey, true);
		
		if (result != null && result instanceof Proyecto) {
	        return Optional.of((Proyecto) result);
	    } else {
	        return Optional.empty();
	    }
	}
	
	public void create(Proyecto proyecto) {
		conexionEx3.insertData("Ejercicio3", proyecto);
	}

}
