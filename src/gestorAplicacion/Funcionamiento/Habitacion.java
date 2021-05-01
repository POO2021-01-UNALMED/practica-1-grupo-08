package gestorAplicacion.Funcionamiento;

import gestorAplicacion.Cliente;
import gestorAplicacion.Personal.Mucama;
import uiMain.Recepcion;

import java.io.Serializable;
import java.util.ArrayList;

public class Habitacion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int numHabitacion;
	public boolean disponibilidadHab;
	private int tipoCapacidad;
	private static int capacidad2 = 0;
	private static int capacidad3 = 0;
	private static int capacidad4 = 0;
	private static int capacidad5 = 0;
	private Cliente cliente;
	private Reserva reserva;
	private int precio;

	public Habitacion(int numHabitacion, int tipoCapacidad) {
		this.numHabitacion = numHabitacion;
		this.disponibilidadHab = true;
		this.tipoCapacidad = tipoCapacidad;
		if (tipoCapacidad == 2) {
			capacidad2++;
		}
		if (tipoCapacidad == 3) {
			capacidad3++;
		}
		if (tipoCapacidad == 4) {
			capacidad4++;
		}
		if (tipoCapacidad == 5) {
			capacidad5++;
		}
	}

	public void setTipoCapacidad(int num) {
		this.tipoCapacidad = num;
	}

	public int getTipoCapacidad() {
		return this.tipoCapacidad;
	}

	public void setNumHabitacion(int num) {
		this.numHabitacion = num;
	}

	public void setDisponibilidadHab(boolean disponibilidadHab) {
		this.disponibilidadHab = disponibilidadHab;
	}

	public static void setCapacidad2(int capacidad2) {
		Habitacion.capacidad2 = capacidad2;
	}

	public static void setCapacidad3(int capacidad3) {
		Habitacion.capacidad3 = capacidad3;
	}

	public static void setCapacidad4(int capacidad4) {
		Habitacion.capacidad4 = capacidad4;
	}

	public static void setCapacidad5(int capacidad5) {
		Habitacion.capacidad5 = capacidad5;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public int getNumhabitacion() {
		return this.numHabitacion;
	}

	public boolean isDisponibilidadHab() {
		return this.disponibilidadHab;
	}

	public static int getCapacidad2() {
		return capacidad2;
	}

	public static int getCapacidad3() {
		return capacidad3;
	}

	public static int getCapacidad4() {
		return capacidad4;
	}

	public static int getCapacidad5() {
		return capacidad5;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public static boolean disponibilidad(int numAcompanantes) {
		// validar que todas las cantidades sean positivas. ¿static?
		// Validar el número de acompañantes ¿Desde el constructor?
		int totalPersonas = 1 + numAcompanantes;
		boolean confirmacion = true;

		if ((totalPersonas == 1 || totalPersonas == 2) && capacidad2 == 0) {
			confirmacion = false;
		} else if (totalPersonas == 3 && capacidad3 == 0) {
			confirmacion = false;
		} else if (totalPersonas == 4 && capacidad4 == 0) {
			confirmacion = false;
		} else if (totalPersonas == 5 && capacidad5 == 0) {
			confirmacion = false;
		}

		return confirmacion;

	}

	public void precioHabitacion() {
		if (tipoCapacidad == 2) {
			precio = 70000;
		} else if (tipoCapacidad == 3) {
			precio = 100000;
		} else if (tipoCapacidad == 4) {
			precio = 130000;
		} else if (tipoCapacidad == 5) {
			precio = 170000;
		}
	}

}
