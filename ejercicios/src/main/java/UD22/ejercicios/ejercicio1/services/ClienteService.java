package UD22.ejercicios.ejercicio1.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import UD22.ejercicios.conexion.Conexion;
import UD22.ejercicios.ejercicio1.models.Cliente;

public class ClienteService {
	private static ClienteService instance;
	private Conexion conexionEx1;

	private ClienteService() {
		conexionEx1 = new Conexion("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", "root",
				"contrasenya123");
	}

	public static ClienteService getInstance() {
		if (instance == null) {
			instance = new ClienteService();
		}
		return instance;
	}

	public List<Cliente> findAll() {
		ResultSet resultSet = conexionEx1.getValues("Ejercicio1", "clientes");
		List<Cliente> clientes = new ArrayList<>();

		try {
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellido(resultSet.getString("apellido"));
				cliente.setDireccion(resultSet.getString("direccion"));
				cliente.setDni(resultSet.getInt("dni"));
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
		ResultSet resultSet = conexionEx1.getById("Ejercicio1", "clientes", id);
		Cliente cliente = null;

		try {
			while (resultSet.next()) {
				cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellido(resultSet.getString("apellido"));
				cliente.setDireccion(resultSet.getString("direccion"));
				cliente.setDni(resultSet.getInt("dni"));
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
			conexionEx1.delete("Ejercicio1", "clientes", cliente.get().getId());
	    }
	}
	
	public Optional<Cliente> update(Cliente cliente, String primaryKey) {
		Object result = conexionEx1.update("Ejercicio1", cliente, primaryKey);
		
		if (result != null && result instanceof Cliente) {
	        return Optional.of((Cliente) result);
	    } else {
	        return Optional.empty();
	    }
	}
	
	public void create(Cliente cliente) {
		conexionEx1.insertData("Ejercicio1", cliente);
	}

}
