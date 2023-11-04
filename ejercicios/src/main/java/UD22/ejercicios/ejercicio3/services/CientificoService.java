package UD22.ejercicios.ejercicio3.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import UD22.ejercicios.conexion.Conexion;
import UD22.ejercicios.ejercicio3.models.Cientifico;

public class CientificoService {
	private static CientificoService instance;
	private Conexion conexionEx3;

	private CientificoService() {
		conexionEx3 = new Conexion("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", "root",
				"contrasenya123");
	}

	public static CientificoService getInstance() {
		if (instance == null)
			instance = new CientificoService();
		return instance;
	}

	public List<Cientifico> findAll() {
	    ResultSet resultSet = conexionEx3.getValues("Ejercicio3", "cientificos");
	    List<Cientifico> cientificos = new ArrayList<>();

	    try {
	        while (resultSet.next()) {
	            Cientifico cientifico = new Cientifico();
	            cientifico.setDni(resultSet.getString("dni"));
	            cientifico.setNomApels(resultSet.getString("nomApels"));
	            cientificos.add(cientifico);
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

	    return cientificos;
	}


	public Optional<Cientifico> findById(String dni) {
	    ResultSet resultSet = conexionEx3.getById("Ejercicio3", "cientificos", dni, "dni");
	    Cientifico cientifico = null;

	    try {
	        while (resultSet.next()) {
	            cientifico = new Cientifico();
	            cientifico.setDni(resultSet.getString("dni"));
	            cientifico.setNomApels(resultSet.getString("nomApels"));
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
	    
	    return Optional.ofNullable(cientifico);
	}


	public void delete(String dni) {
	    Optional<Cientifico> cientifico = this.findById(dni);
	    if (cientifico.isPresent()) {
	        conexionEx3.delete("Ejercicio3", "cientificos", dni, "dni");
	    }
	}

	
	public Optional<Cientifico> update(Cientifico cientifico, String primaryKey) {
	    Object result = conexionEx3.update("Ejercicio3", cientifico, primaryKey, true);
	    
	    if (result != null && result instanceof Cientifico) {
	        return Optional.of((Cientifico) result);
	    } else {
	        return Optional.empty();
	    }
	}

	
	public void create(Cientifico cientifico) {
	    conexionEx3.insertData("Ejercicio3", cientifico);
	}


}
