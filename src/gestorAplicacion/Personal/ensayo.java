package gestorAplicacion.Personal;

import java.text.SimpleDateFormat; //// Fechas
import java.util.Date;

import baseDatos.Defecto;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Habitacion;
import gestorAplicacion.Funcionamiento.Hotel;
import gestorAplicacion.Funcionamiento.Servicio;
import uiMain.Recepcion;

public class ensayo {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		Defecto.ObjetosDefecto();
		Habitacion h1 = new Habitacion(103, 2);
		Cliente cliente2 = new Cliente("Fabio", 21356780, "02/06/2021", "06/06/2021", 3, 20000000);
		Recepcion.hotel.asignarHabitacion(cliente2);
		Mucama m1 = new Mucama("Maria", 243554);
		// System.out.println(m1.getSalario());
		Habitacion.setCapacidad2(9);
		m1.limpiarHabitacion(103);
		//System.out.println(Habitacion.getCapacidad2());
		System.out.println(cliente2.getHabitacion());
		
		

		

	}

}
