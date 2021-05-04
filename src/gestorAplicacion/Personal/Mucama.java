package gestorAplicacion.Personal;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.Funcionamiento.*;
import uiMain.Recepcion;

public class Mucama extends Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// public Hotel hotel;

	public Mucama(String nombre, long id, HorasExtras horasextras, int cantidadHoras) {
		super(nombre, id, "Mucama", horasextras, cantidadHoras);
		asignarSalario();
		super.pagoHorasExtras();
		//Recepcion.hotel.getMucamas().add(this);
	}

	public Mucama(String nombre, long id) {
		super(nombre, id, "Mucama");
		asignarSalario();
		//Recepcion.hotel.getMucamas().add(this);
	}

	@Override
	public void asignarSalario() {
		super.setSalario(915000);
	}

	public void limpiarHabitacion(int num) {

		for (int i = 0; i < Recepcion.hotel.getHabitaciones().size(); i++) {
			int cap2 = Habitacion.getCapacidad2();
			int cap3 = Habitacion.getCapacidad3();
			int cap4 = Habitacion.getCapacidad4();
			int cap5 = Habitacion.getCapacidad5();
			if (num == Recepcion.hotel.getHabitaciones().get(i).getNumhabitacion()) {
				Recepcion.hotel.getHabitaciones().get(i).setDisponibilidadHab(true);// cambio la disponibilidad de la
																					// habitacion
				if (Recepcion.hotel.getHabitaciones().get(i).getTipoCapacidad() == 2) {
					Habitacion.setCapacidad2(cap2 + 1); // si la cap es de 2, aumento en habitacion esa capacidad
					break;
				} else if (Recepcion.hotel.getHabitaciones().get(i).getTipoCapacidad() == 3) {
					Habitacion.setCapacidad3(cap3 + 1);
					break;
				} else if (Recepcion.hotel.getHabitaciones().get(i).getTipoCapacidad() == 4) {
					Habitacion.setCapacidad4(cap4 + 1);
					break;
				} else if (Recepcion.hotel.getHabitaciones().get(i).getTipoCapacidad() == 5) {
					Habitacion.setCapacidad5(cap5 + 1);
					break;
				}

			}
		}
	}
}
