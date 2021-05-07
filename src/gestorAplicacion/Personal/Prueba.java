package gestorAplicacion.Personal;

import baseDatos.Defecto;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Habitacion;
import gestorAplicacion.Funcionamiento.Hotel;
import gestorAplicacion.Funcionamiento.Reserva;
import gestorAplicacion.Funcionamiento.Servicio;
import uiMain.*;

public class Prueba {

	public static void main(String[] args) {
		/*
		 * Cliente c1 = new Cliente("luis", 4874, "21/04/2021", "25/04/2021", 300000,
		 * 87574); Empleado e1 = new Empleado("Veronica",87574,"ayudante");
		 * //c1.setParentescoEmpleado(true); Habitacion h1 = new Habitacion(102,2);
		 * h1.setPrecio(70000); c1.setHabitacion(h1); Servicio s1 = new Servicio(c1);
		 * c1.setServicio(s1); h1.setCliente(c1);
		 * 
		 * 
		 * //System.out.println(c1.getFecha_entrada());
		 * c1.getServicio().setGastosServicios(200000);
		 * //Recepcion.hotel.descuentoPorConsumo(c1);
		 * //System.out.println(c1.getServicio().getGastosServicios());
		 * //Recepcion.hotel.descuentoFamiliar(c1); Recepcion.hotel.cobrarDeudas(c1);
		 * //System.out.println(c1.getServicio().getGastosServicios());
		 * System.out.println(c1.getSaldo()); System.out.println(c1.getCuentaFinal());
		 */
		//Hotel ht1=new Hotel(3);
		/*Cliente cliente1 = new Cliente("Nora", 21345687, "27/05/2021", "03/06/2021", 2, 15000000, 1000656556);
		Cliente cliente2 = new Cliente("Fabio", 21356780, "02/06/2021", "06/06/2021", 3, 20000000);
		Cliente cliente3 = new Cliente("Yesenia", 21724520, "03/06/2021", "15/06/2021", 4, 25000000);
		Cliente cliente4 = new Cliente("Wilmar", 15670834, "28/05/2020", "07/06/2001", 4, 35000000, 4567234); ///// Solo																										///// titular.
		Cliente cliente5 = new Cliente("Sofía", 4321689, "07/07/2020", "20/07/2020", 2, 15600000, 115467300);*/

		/*Habitacion hab1 = new Habitacion(103, 2);
		Habitacion hab2 = new Habitacion(202, 4);
		Habitacion hab3 = new Habitacion(101, 3);
		Habitacion hab4 = new Habitacion(303, 5);
		Habitacion hab5 = new Habitacion(205, 4);

		Empleado emp1 = new Empleado("Luis", 2489364,"vigilante", HorasExtras.DIURNA, 10);
		Empleado emp2 = new Mucama("Karla", 3544565, HorasExtras.DIURNADOMINICAL, 9);
		Empleado emp3 = new Empleado("Mario", 10595906,"Rececionista");*/
		
		/*Cliente clientep = new Cliente("Fabio", 21356780, "02/06/2021", "06/06/2021", 3, 20000000);
		Cliente cliente3 = new Cliente("Yesenia", 21724520, "03/06/2021", "15/06/2021", 4, 25000000);
		Reserva res = new Reserva("20/06/2021","26/06/2021",clientep);
		Habitacion hab = new Habitacion(202, 4);
		
		System.out.println(clientep.getFecha_entrada() + res.getFecha_de_ingreso());
*/
		Cliente clientep = new Cliente("Fabio", 21356780, "02/06/2021", "06/06/2021", 3, 20000000);
		//clientep.setHabitacion(new Habitacion(23434,4));
		System.out.println(Recepcion.getHotel().getClientes());

	}

}
