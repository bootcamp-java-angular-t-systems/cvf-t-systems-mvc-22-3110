package UD22.ejercicios.ejercicio1.utils;

import UD22.ejercicios.conexion.Conexion;
import UD22.ejercicios.ejercicio1.models.Cliente;

public class Utils {
	
	public static void populateDatabase() {
		System.out.println("Creando conexion...");
		Conexion conexionEx1 = new Conexion("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", "root", "contrasenya123");
		conexionEx1.createDB("Ejercicio1");
		
		 Cliente cliente1 = new Cliente("Carla", "Velasco", "C/ De la esperanza 42", 4517825);
		 Cliente cliente2 = new Cliente("Antoni", "Andreu", "C/ De el oblit 48", 4582796);
		 Cliente cliente3 = new Cliente("David", "Maza", "C/ torredembarra 88", 48524828);
		 Cliente cliente4 = new Cliente("Jan", "Cossio", "C/ Trafalgar 1", 5450455);
		 Cliente cliente5 = new Cliente("Sergi", "Rodriguez", "C/ Nou barris", 4582824);
		 
		 conexionEx1.createTable("Ejercicio1", cliente1, "id");
		 
		 conexionEx1.insertData("Ejercicio1", cliente1);
		 conexionEx1.insertData("Ejercicio1", cliente2);
		 conexionEx1.insertData("Ejercicio1", cliente3);
		 conexionEx1.insertData("Ejercicio1", cliente4);
		 conexionEx1.insertData("Ejercicio1", cliente5);
	}

}
