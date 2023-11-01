package UD22.ejercicios.ejercicio1.app;

import UD22.ejercicios.ejercicio1.controllers.ClienteController;
import UD22.ejercicios.ejercicio1.models.Cliente;
import UD22.ejercicios.ejercicio1.services.ClienteService;
import UD22.ejercicios.ejercicio1.utils.Utils;
import UD22.ejercicios.ejercicio1.views.ListView;

public class Ejercicio1App {

	public static void main(String[] args) {

		Utils.populateDatabase();

		ListView view = new ListView();
		ClienteService service = ClienteService.getInstance();
		
		ClienteController controlador = new ClienteController(view, service);
		controlador.iniciarVista();

	}

}
