package UD22.ejercicios.ejercicio2.app;

import UD22.ejercicios.ejercicio2.controllers.ClienteController;
import UD22.ejercicios.ejercicio2.services.ClienteService;
import UD22.ejercicios.ejercicio2.utils.Utils;
import UD22.ejercicios.ejercicio2.views.cliente.ListClientView;

public class Ejercicio2App {

	public static void main(String[] args) {

		Utils.populateDatabase();

		// TODO ListClientView singleton
		ListClientView view = new ListClientView();
		ClienteService service = ClienteService.getInstance();
		
		ClienteController controlador = new ClienteController(view, service);
		controlador.iniciarVista();
	}

}
