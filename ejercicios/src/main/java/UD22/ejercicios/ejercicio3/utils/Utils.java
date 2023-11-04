package UD22.ejercicios.ejercicio3.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import UD22.ejercicios.conexion.Conexion;
import UD22.ejercicios.ejercicio3.models.Asignado_A;
import UD22.ejercicios.ejercicio3.models.Cientifico;
import UD22.ejercicios.ejercicio3.models.Proyecto;


public class Utils {
	
	public static void populateDatabase() {
		System.out.println("Creando conexion...");
		Conexion conexionEx3 = new Conexion("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", "root", "contrasenya123");
		conexionEx3.createDB("Ejercicio3");
		
		 Cientifico cientifico1 = new Cientifico("4528757F", "Carla Velasco Fabrega");
		 Cientifico cientifico2 = new Cientifico("5369879P", "Pedro Lopez Martinez");
		 Cientifico cientifico3 = new Cientifico("4896582E", "Aina Velazquez Agusti");
		 Cientifico cientifico4 = new Cientifico("4289658A", "Marcos Soto Buesa");
		 Cientifico cientifico5 = new Cientifico("4857596D", "Maria Recasens Garcia");
		 
		 conexionEx3.createTable("Ejercicio3", cientifico1, "dni");
		 
		 conexionEx3.insertData("Ejercicio3", cientifico1);
		 conexionEx3.insertData("Ejercicio3", cientifico2);
		 conexionEx3.insertData("Ejercicio3", cientifico3);
		 conexionEx3.insertData("Ejercicio3", cientifico4);
		 conexionEx3.insertData("Ejercicio3", cientifico5);
		 
		 Proyecto proyecto1 = new Proyecto("22A", "Proyecto Alfa", 300);
		 Proyecto proyecto2 = new Proyecto("11J", "Proyecto Beta", 500);
		 Proyecto proyecto3 = new Proyecto("73P", "Proyecto Gamma", 4000);
		 Proyecto proyecto4 = new Proyecto("89A", "Proyecto Echo", 30);
		 Proyecto proyecto5 = new Proyecto("33F", "Proyecto Tostadora", 520);
		 
		 conexionEx3.createTable("Ejercicio3", proyecto1, "id");
		 
		 conexionEx3.insertData("Ejercicio3", proyecto1);
		 conexionEx3.insertData("Ejercicio3", proyecto2);
		 conexionEx3.insertData("Ejercicio3", proyecto3);
		 conexionEx3.insertData("Ejercicio3", proyecto4);
		 conexionEx3.insertData("Ejercicio3", proyecto5);
		 
		 Asignado_A asignado1 = new Asignado_A(cientifico3.getDni(), proyecto2.getId());
		 Asignado_A asignado2 = new Asignado_A(cientifico4.getDni(), proyecto1.getId());
		 Asignado_A asignado3 = new Asignado_A(cientifico5.getDni(), proyecto1.getId());
		 Asignado_A asignado4 = new Asignado_A(cientifico2.getDni(), proyecto3.getId());
		 Asignado_A asignado5 = new Asignado_A(cientifico1.getDni(), proyecto4.getId());
		 
		 
		 List<String> pks = new ArrayList<String>();
		 pks.add("cientifico");
		 pks.add("proyecto");
		 conexionEx3.createTable("Ejercicio3", asignado1, pks, ", FOREIGN KEY (cientifico) REFERENCES cientificos(dni) ON DELETE CASCADE ON UPDATE CASCADE"
		 		+ ", FOREIGN KEY (proyecto) REFERENCES proyectos(id) ON DELETE CASCADE ON UPDATE CASCADE");
		 
		 conexionEx3.insertData("Ejercicio3", asignado1);
		 conexionEx3.insertData("Ejercicio3", asignado2);
		 conexionEx3.insertData("Ejercicio3", asignado3);
		 conexionEx3.insertData("Ejercicio3", asignado4);
		 conexionEx3.insertData("Ejercicio3", asignado5);
				 
		 
		 conexionEx3.closeConnection();
	}

}
