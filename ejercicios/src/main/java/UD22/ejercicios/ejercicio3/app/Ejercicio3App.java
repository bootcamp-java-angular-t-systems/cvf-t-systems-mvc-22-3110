package UD22.ejercicios.ejercicio3.app;

import UD22.ejercicios.ejercicio3.controllers.CientificoController;
import UD22.ejercicios.ejercicio3.services.CientificoService;
import UD22.ejercicios.ejercicio3.utils.Utils;
import UD22.ejercicios.ejercicio3.views.cientifico.ListCientificoView;

public class Ejercicio3App {

	public static void main(String[] args) {

		Utils.populateDatabase();

		ListCientificoView view = new ListCientificoView();
		CientificoService service = CientificoService.getInstance();
		
		CientificoController controlador = new CientificoController(view, service);
		controlador.iniciarVista();
	}

}