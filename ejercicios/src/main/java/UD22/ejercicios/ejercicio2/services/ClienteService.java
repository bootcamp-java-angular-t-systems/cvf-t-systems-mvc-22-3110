package UD22.ejercicios.ejercicio2.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import UD22.ejercicios.conexion.Conexion;
import UD22.ejercicios.ejercicio2.models.Cliente;

public class ClienteService {
	private static ClienteService instance;
	private Conexion conexionEx2;

	private ClienteService() {
		conexionEx2 = new Conexion("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", "root",
				"contrasenya123");
	}

	public static ClienteService getInstance() {
		if (instance == null) {
			instance = new ClienteService();
		}
		return instance;
	}

	public List<Cliente> findAll() {
		ResultSet resultSet = conexionEx2.getValues("Ejercicio2", "clientes");
		List<Cliente> clientes = new ArrayList<>();

		try {
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellido(resultSet.getString("apellido"));
				cliente.setDireccion(resultSet.getString("direccion"));
				cliente.setDni(resultSet.getInt("dni"));
				cliente.setDireccion(resultSet.getString("fecha"));
				clientes.add(cliente);
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

		return clientes;
	}

	public Optional<Cliente> findById(int id) {
		ResultSet resultSet = conexionEx2.getById("Ejercicio2", "clientes", id);
		Cliente cliente = null;

		try {
			while (resultSet.next()) {
				cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellido(resultSet.getString("apellido"));
				cliente.setDireccion(resultSet.getString("direccion"));
				cliente.setDni(resultSet.getInt("dni"));
				cliente.setDireccion(resultSet.getString("fecha"));
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
		return Optional.ofNullable(cliente);
	}

	public void delete(int id) {
		Optional<Cliente> cliente = this.findById(id);
		if (cliente.isPresent()) {
			conexionEx2.delete("Ejercicio2", "clientes", cliente.get().getId());
	    }
	}
	
	public Optional<Cliente> update(Cliente cliente, String primaryKey) {
		Object result = conexionEx2.update("Ejercicio2", cliente, primaryKey);
		
		if (result != null && result instanceof Cliente) {
	        return Optional.of((Cliente) result);
	    } else {
	        return Optional.empty();
	    }
	}
	
	public void create(Cliente cliente) {
		conexionEx2.insertData("Ejercicio2", cliente);
	}

}
