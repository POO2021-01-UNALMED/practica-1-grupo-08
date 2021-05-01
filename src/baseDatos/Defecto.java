package baseDatos;

import gestorAplicacion.Cliente;
import uiMain.Recepcion;
import uiMain.Recepcion2;

public class Defecto {
	
	
	
	public static void defectoClientes() {
		Cliente cliente2 = new Cliente("Fabio", 21356780, "02/06/2021", "06/06/2021", 3, 20000000);
		Recepcion2.hotel.getClientes().add(cliente2);
		Cliente cliente3 = new Cliente("Yesenia", 21724520, "03/06/2021", "15/06/2021", 4, 25000000);
		Recepcion2.hotel.getClientes().add(cliente3);
		Cliente cliente4 = new Cliente("Wilmar", 15670834, "28/05/2020", "07/06/2001", 4, 35000000, 4567234); ///// Solo
		Recepcion2.hotel.getClientes().add(cliente4);																								///// titular.
		Cliente cliente5 = new Cliente("Sofía", 4321689, "07/07/2020", "20/07/2020", 2, 15600000, 115467300);
		Recepcion2.hotel.getClientes().add(cliente5);

	}
}
