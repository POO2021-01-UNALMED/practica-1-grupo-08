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
	private Habitacion habitacion;
	// public Hotel hotel;

	public Mucama(String nombre, long id, HorasExtras horasextras, int cantidadHoras) {
		super(nombre, id, "Mucama", horasextras, cantidadHoras);
	}

	public Mucama(String nombre, long id) {
		super(nombre, id, "Mucama");
	}

	@Override
	public void asignarSalario() {
		super.setSalario(915000);
	}
	
	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public void limpiarHabitacion(Habitacion habitacion) {
		this.habitacion=habitacion;
	for (Habitacion i : Recepcion.hotel.getHabitaciones()) {
			int cap2 = Habitacion.getCapacidad2();
			int cap3 = Habitacion.getCapacidad3();
			int cap4 = Habitacion.getCapacidad4();
			int cap5 = Habitacion.getCapacidad5();
			if (habitacion.equals(i)) {
				i.setDisponibilidadHab(true);// cambio la disponibilidad de la																	// habitacion
				if (i.getTipoCapacidad() == 2) {
					Habitacion.setCapacidad2(cap2 + 1); // si la cap es de 2, aumento en habitacion esa capacidad
					break;
				} else if (i.getTipoCapacidad() == 3) {
					Habitacion.setCapacidad3(cap3 + 1);
					break;
				} else if (i.getTipoCapacidad() == 4) {
					Habitacion.setCapacidad4(cap4 + 1);
					break;
				} else if (i.getTipoCapacidad() == 5) {
					Habitacion.setCapacidad5(cap5 + 1);
					break;
				}

			}
		}
	}
	
	public String toString() {
		return "Mucama con identificación: " + getId() + "con habitación asignada: " + habitacion.getNumhabitacion();
		
	}
}
