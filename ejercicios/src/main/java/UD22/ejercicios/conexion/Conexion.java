package UD22.ejercicios.conexion;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.ResultSetMetaData;


import java.lang.reflect.Field;
import java.sql.Connection;

public class Conexion {

	private Connection conexion;

	public Conexion(String url, String userDB, String passwordDB) {
		createConnection(url, userDB, passwordDB);
	}

	public void createConnection(String url, String userDB, String passwordDB) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, userDB, passwordDB);
			System.out.println("Server Connected");

		} catch (SQLException | ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "No se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
	}

	public void closeConnection() {
		try {
			conexion.close();
			System.out.println("Se ha finalizado la conexión con el servidor");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Esto no funciona...");
		}
	}

	public void createDB(String name) {
		try {
			String Query = "CREATE DATABASE IF NOT EXISTS " + name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Se ha creado la base de datos " + name + " de forma exitosa");
		} catch (SQLException ex) {
			System.out.println("Esto no funciona...");
		}
	}

	public void createTable(String db, Object object, List<String> pks, String fk) {
		try {
			Field[] atributos = obtenerCampos(object);
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();

			stdb.executeUpdate(Querydb);
			String attribute = "";
			String Query = "CREATE TABLE IF NOT EXISTS " + obtenerNombreTabla(object) + " (";
			for (Field field : atributos) {
				attribute = field.getName();
				if (attribute == "counter")
					continue;
				Query += attribute + " " + getSqlType(field);
				if (!field.equals(atributos[atributos.length - 1]))
					Query += ", ";
				else {
					Query += getPrimaryKeyString(pks);
					Query += fk;
				}
			}
			;
			Query += ");";
			System.out.println(Query);
			stdb.executeUpdate(Query);
			System.out.println("Tabla creada con exito!");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error creando tabla");
		}
	}

	public void delete(String db, String tableName, int id) {
		try {
	        String useDbQuery = "USE " + db;
	        Statement useDbStatement = conexion.createStatement();
	        useDbStatement.executeUpdate(useDbQuery);

	        String deleteQuery = "DELETE FROM " + tableName + " WHERE id = " + id;
	        Statement deleteStatement = conexion.createStatement();
	        int rowsAffected = deleteStatement.executeUpdate(deleteQuery);

	        if (rowsAffected > 0) {
	            System.out.println("Cliente eliminado con éxito.");
	        } else {
	            System.out.println("El cliente con ID " + id + " no existe en la base de datos.");
	        }
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	        System.out.println("Error en la eliminación de datos");
	    }
	}

	public String getPrimaryKeyString(List<String> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return "";
		}

		StringBuilder primaryKeyString = new StringBuilder(", PRIMARY KEY (");

		for (String column : primaryKeys) {
			primaryKeyString.append(column).append(", ");
		}
		primaryKeyString.setLength(primaryKeyString.length() - 2);
		primaryKeyString.append(")");

		return primaryKeyString.toString();
	}

	public void createTable(String db, Object object, String pk) {
		List<String> pks = new ArrayList<String>();
		pks.add(pk);
		createTable(db, object, pks, "");
	}

	public void createTable(String db, Object object, String pk, String fk) {
		List<String> pks = new ArrayList<String>();
		pks.add(pk);
		createTable(db, object, pks, fk);
	}

	public void insertData(String db, Object object) {
		try {
			Field[] atributos = obtenerCampos(object);
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "INSERT INTO " + obtenerNombreTabla(object) + " (";
			for (Field field : atributos) {
				if (field.getName() == "counter")
					continue;
				Query += field.getName();
				if (!field.equals(atributos[atributos.length - 1]))
					Query += ", ";
			}
			;
			Query += ") VALUES (";

			for (Field field : atributos) {
				field.setAccessible(true);
				if (field.getName() == "counter")
					continue;
				try {
					Object valor = field.get(object);
					if (valor instanceof String)
						Query += "'" + valor + "'";
					else if (valor instanceof Number)
						Query += valor;
					if (!field.equals(atributos[atributos.length - 1]))
						Query += ", ";
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			Query += ");";
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos almacenados correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}

	public ResultSet getValues(String db, String table_name) {
		ResultSet resultSet = null;
		try {
			String useDbQuery = "USE " + db;
			Statement useDbStatement = conexion.createStatement();
			useDbStatement.executeUpdate(useDbQuery);

			String selectQuery = "SELECT * FROM " + table_name;
			Statement selectStatement = conexion.createStatement();
			resultSet = selectStatement.executeQuery(selectQuery);

			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
		return resultSet;
	}

	public ResultSet getById(String db, String table_name, int id) {
		ResultSet resultSet = null;

		try {
			String useDbQuery = "USE " + db;
			Statement useDbStatement = conexion.createStatement();
			useDbStatement.executeUpdate(useDbQuery);

			String selectQuery = "SELECT * FROM " + table_name + " WHERE id = " + id;
			Statement selectStatement = conexion.createStatement();
			resultSet = selectStatement.executeQuery(selectQuery);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}

		return resultSet;
	}

	private String obtenerNombreTabla(Object objeto) {
		String nombreClase = objeto.getClass().getSimpleName();
		return nombreClase.substring(0, 1).toLowerCase() + nombreClase.substring(1) + "s";
	}

	public Field[] obtenerCampos(Object objeto) {
		Class<?> clase = objeto.getClass();
		return clase.getDeclaredFields();
	}

	public String getSqlType(Field atributo) {
		Class<?> tipo = atributo.getType();

		if (tipo == String.class) {
			return "VARCHAR(255)";
		} else if (tipo == int.class || tipo == Integer.class) {
			return "INT";
		} else if (tipo == long.class || tipo == Long.class) {
			return "BIGINT";
		} else {
			return "VARCHAR(255)";
		}
	}
	
	public Object update(String db, Object object, String primaryKey) {
	    try {
	        Field[] fields = obtenerCampos(object);
	        String tableName = obtenerNombreTabla(object);
	        String updateCondition = "";
	        
	    	String Querydb = "USE " + db + ";";
	    	Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
	        StringBuilder updateQuery = new StringBuilder("UPDATE " + tableName + " SET ");
	        for (Field field : fields) {
	        	if (field.getName() == "counter")
					continue;
	            field.setAccessible(true);
	            String fieldName = field.getName();
	            Object fieldValue = field.get(object);

	            if (fieldValue != null) {
	                if (!fieldName.equals("id")) {
	                    updateQuery.append(fieldName).append(" = ");
	                    if (field.getType() == String.class) {
	                        updateQuery.append("'").append(fieldValue).append("'");
	                    } else {
	                        updateQuery.append(fieldValue);
	                    }
	                    updateQuery.append(", ");
	                }
	            }
	            if (field.getName() == primaryKey)
	            	updateCondition = " WHERE " + primaryKey + " = " + field.get(object);
	        }

	        if (updateQuery.length() > 0) {
	            updateQuery.setLength(updateQuery.length() - 2);
	        } else {
	            System.out.println("No se proporcionaron valores para actualizar.");
	            return null;
	        }

	        String finalUpdateQuery = updateQuery.toString() + updateCondition;

	        System.out.println(finalUpdateQuery);

	        Statement statement = conexion.createStatement();
	        statement.executeUpdate(finalUpdateQuery);
	        System.out.println("Datos actualizados correctamente.");
	    } catch (SQLException | IllegalAccessException ex) {
	        ex.printStackTrace();
	        System.out.println("Error en la actualización de datos");
	    }
	    return object;
	}

}