package UD22.ejercicios.ejercicio2.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import UD22.ejercicios.conexion.Conexion;
import UD22.ejercicios.ejercicio2.models.Cliente;
import UD22.ejercicios.ejercicio2.models.Video;

public class Utils {
	
	public static void populateDatabase() {
		System.out.println("Creando conexion...");
		Conexion conexionEx2 = new Conexion("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", "root", "contrasenya123");
		conexionEx2.createDB("Ejercicio2");
		
		 Cliente cliente1 = new Cliente("Carla", "Velasco", "C/ De la esperanza 42", 4517825);
		 Cliente cliente2 = new Cliente("Antoni", "Andreu", "C/ De el oblit 48", 4582796);
		 Cliente cliente3 = new Cliente("David", "Maza", "C/ torredembarra 88", 48524828);
		 Cliente cliente4 = new Cliente("Jan", "Cossio", "C/ Trafalgar 1", 5450455);
		 Cliente cliente5 = new Cliente("Sergi", "Rodriguez", "C/ Nou barris", 4582824);
		 
		 conexionEx2.createTable("Ejercicio2", cliente1, "id");
		 
		 conexionEx2.insertData("Ejercicio2", cliente1);
		 conexionEx2.insertData("Ejercicio2", cliente2);
		 conexionEx2.insertData("Ejercicio2", cliente3);
		 conexionEx2.insertData("Ejercicio2", cliente4);
		 conexionEx2.insertData("Ejercicio2", cliente5);
		 
		 Video video1 = new Video("Video 1", "Director video 1", cliente3.getId());
		 Video video2 = new Video("Video 2", "Director video 2", cliente2.getId());
		 Video video3 = new Video("Video 3", "Director video 3", cliente2.getId());
		 Video video4 = new Video("Video 4", "Director video 4", cliente1.getId());
		 Video video5 = new Video("Video 5", "Director video 5", cliente5.getId());
		 
		 conexionEx2.createTable("Ejercicio2", video1, "id", ", FOREIGN KEY (clientId) REFERENCES clientes(id) ON DELETE CASCADE ON UPDATE CASCADE");
		 
		 conexionEx2.insertData("Ejercicio2", video1);
		 conexionEx2.insertData("Ejercicio2", video2);
		 conexionEx2.insertData("Ejercicio2", video3);
		 conexionEx2.insertData("Ejercicio2", video4);
		 conexionEx2.insertData("Ejercicio2", video5);
		 
		 conexionEx2.closeConnection();
	}

}
