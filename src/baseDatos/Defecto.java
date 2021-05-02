package baseDatos;

import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Habitacion;
import gestorAplicacion.Funcionamiento.*;
import gestorAplicacion.Personal.Empleado;
import gestorAplicacion.Personal.HorasExtras;
import gestorAplicacion.Personal.Mucama;
import uiMain.Recepcion;
import uiMain.Recepcion2;

public class Defecto {

	public static void ObjetosDefecto() {
		Cliente cliente2 = new Cliente("Fabio", 21356780, "2021-06-02", "2021-06-06", 3, 20000000);
		Recepcion.hotel.getClientes().add(cliente2);
		Cliente cliente3 = new Cliente("Yesenia", 21724520, "2021-06-03", "2021-06-15", 4, 25000000);
		Recepcion.hotel.getClientes().add(cliente3);
		Cliente cliente4 = new Cliente("Manuel", 15670834, "2020-05-28", "2021-06-07", 4, 35000000, 4567234); ///// Solo
		Recepcion.hotel.getClientes().add(cliente4);																								///// titular.
		Cliente cliente5 = new Cliente("Sofía", 4321689, "2020-07-07", "2020-07-20", 2, 15600000, 115467300);
		Recepcion.hotel.getClientes().add(cliente5);
		Habitacion hab1 = new Habitacion(103, 2);
		Recepcion.hotel.getHabitaciones().add(hab1);
		//Habitacion hab2 = new Habitacion(202, 4);
		//Recepcion.hotel.getHabitaciones().add(hab2);
		Habitacion hab3 = new Habitacion(101, 3);
		Recepcion.hotel.getHabitaciones().add(hab3);
		Habitacion hab4 = new Habitacion(303, 5);
		Recepcion.hotel.getHabitaciones().add(hab4);
		//Habitacion hab5 = new Habitacion(205, 4);
		//Recepcion.hotel.getHabitaciones().add(hab5);
		Empleado emp1 = new Empleado("Luis", 2489364,"vigilante", HorasExtras.DIURNA, 10);
		Recepcion.hotel.getEmpleados().add(emp1);
		Empleado emp2 = new Mucama("Karla", 3544565, HorasExtras.DIURNADOMINICAL, 9);
		Recepcion.hotel.getEmpleados().add(emp2);
		Empleado emp3 = new Empleado("Mario", 10595906,"Rececionista");
		Recepcion.hotel.getEmpleados().add(emp3);
		Servicio ser2 = new Servicio(cliente2);
		Recepcion.hotel.getServicios().add(ser2);
		Servicio ser3 = new Servicio(cliente3);
		Recepcion.hotel.getServicios().add(ser3);
		Servicio ser4 = new Servicio(cliente4);
		Recepcion.hotel.getServicios().add(ser4);
		Servicio ser5 = new Servicio(cliente5);
		Recepcion.hotel.getServicios().add(ser5);
		Mucama muc1 = new Mucama("Camila",1023456789,HorasExtras.DIURNADOMINICAL,4);
		Recepcion.hotel.getMucamas().add(muc1);
		Mucama muc2 = new Mucama("Camila",102344333,HorasExtras.NOCTURNA,2);
		Recepcion.hotel.getMucamas().add(muc2);
		Reserva res1 = new Reserva("2021-06-23","2021-06-26",cliente2);
		Recepcion.hotel.getReservas().add(res1);
		
	}
}
