package gestorAplicacion.Funcionamiento;
import gestorAplicacion.Cliente;

public class Habitacion {
	public int numHabitacion;
	public boolean disponibilidad;
	public static int capacidad2;
	public static int capacidad3;
	public static int capacidad4;
	public static int capacidad5;
	public Cliente cliente;
	public Reserva reserva;

	
	public void setNumHabitacion(int num) {
		this.numHabitacion = num;
	}
	
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	public void setCapacidad2(int capacidad2) {
		Habitacion.capacidad2 = capacidad2;
	}
	
	public void setCapacidad3(int capacidad3) {
		Habitacion.capacidad3 = capacidad3;
	}
	
	public void setCapacidad4(int capacidad4) {
		Habitacion.capacidad4 = capacidad4;
	}
	
	public void setCapacidad5(int capacidad5) {
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
	
	public boolean getDisponibilidad() {
		return this.disponibilidad;
		
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
		return this.cliente;
	}
	
	public Reserva getReserva() {
		return this.reserva;
	}
}
