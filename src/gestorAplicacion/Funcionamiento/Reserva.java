package gestorAplicacion.Funcionamiento;
import gestorAplicacion.*;
import java.util.Date;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import uiMain.*;

/*Autores: Yojan Andrés Alcaraz Pérez.
 ** Componentes: El presente módulo contiene la clase Reserva, sus atributos, su constructor, 
 * los respectivos métodos get y set de cada uno de los atributos que lo requieren y los métodos
 * reasignar_reserva() y cancelar_reserva().
 ** Funcionalidad y finalidad: Esta clase permite almacenar información sobre las reservas que 
 * realizarán los clientes, por lo que es necesario aquí un atributo de tipo Cliente.
 * Cada objeto de esta clase será almacenado en la lista reservas de la clase Hotel.*/

public class Reserva implements Serializable {

	/**
	 * 
	 */
	// ATRIBUTOS.
	//El siguiente atributo es necesario para la serizalización de las instancias de esta clase.
	private static final long serialVersionUID = 1L;
	private LocalDate fecha_de_ingreso;
	private LocalDate fecha_de_salida;
	private Cliente cliente;
	
	//public static DateTimeFormatter convertidor = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// CONSTRUCTOR:
	public Reserva(String fecha_de_ingreso, String fecha_de_salida, Cliente cliente) {
		LocalDate fecha_ingresar = LocalDate.parse(fecha_de_ingreso);
		this.fecha_de_ingreso = fecha_ingresar;
		LocalDate fecha_salir = LocalDate.parse(fecha_de_salida);
		this.fecha_de_salida = fecha_salir;
		this.cliente = cliente;
		Recepcion.getHotel().asignarHabitacion(cliente);
		/* Se hace el llamado al método asignarHabitacion() de la clase "Hotel" porque las habitaciones 
		 * son asignadas al momento en el que el cliente realiza la reserva. 
		 */
		cliente.setReserva(true);
		Recepcion.getHotel().getReservas().add(this);
	}

	// MÉTODOS GET Y SET: que permiten el acceso y modificación de los atributos que así lo requieran.

	public LocalDate getFecha_de_ingreso() {
		return fecha_de_ingreso;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setFecha_de_ingreso(String fecha_de_ingreso) {
		LocalDate fecha_ingresar = LocalDate.parse(fecha_de_ingreso);
		this.fecha_de_ingreso = fecha_ingresar;
	}

	public LocalDate getFecha_de_salida() {
		return fecha_de_salida;
	}

	public void setFecha_de_salida(String fecha_de_salida) {
		LocalDate fecha_salir = LocalDate.parse(fecha_de_salida);
		this.fecha_de_ingreso = fecha_salir;
	}

	/// MÉTODOS:
	
	/*
	 * El siguiente método reasigna una reserva cuando el cliente así lo desee, los parámetros de entrada 
	 * son las fechas de ingreso y salida de la nueva reserva y no tiene ningún tipo de retorno, pues lo 
	 * único que se hace es la modificación, mediante el método set de las fechas que son ingresadas como 
	 * parámetro en el constructor.
	 */
	public void reasignar_reserva(String nueva_fecha_ing, String nueva_fecha_sal) {
		cliente.setFecha_entrada(nueva_fecha_ing);
		cliente.setFecha_salida(nueva_fecha_sal);
		Recepcion.getHotel().asignarHabitacion(cliente);
	}
	
	/* El método permite a los clientes cancelar sus reservas, da la disponibilidad de la habitación
	 * que había sido asignada al cliente al momento de realizar la reserva, para ello, verifica la capacidad 
	 * de dicha habitación y aumenta en uno la disponibilidad del tipo de habitaciones acorde a su capacidad,
	 * posteriormente, elimina la relación entre la habitación y el cliente y finalmente elimina la reserva 
	 * de la lista de reservas que hay en la clase "Hotel".
	 * El parámetro de entrada es el cliente que reservó y no posee parámetros de salida, pues lo que hace 
	 * es la modificación de atributos y eliminación de una instancia en la lista.
	 */

	public void cancelar_reserva(Cliente cliente) {
		cliente.getHabitacion().setDisponibilidadHab(true);
		int cap2 = Habitacion.getCapacidad2();
		int cap3 = Habitacion.getCapacidad3();
		int cap4 = Habitacion.getCapacidad4();
		int cap5 = Habitacion.getCapacidad5();
		int totalPersonas = 1 + cliente.getNumAcompanantes();

		if ((totalPersonas == 1 || totalPersonas == 2)) {
			Habitacion.setCapacidad2(cap2 + 1);
		} else if (totalPersonas == 3) {
			Habitacion.setCapacidad3(cap3 + 1);
		} else if (totalPersonas == 4) {
			Habitacion.setCapacidad4(cap4 + 1);
		} else if (totalPersonas == 5) {
			Habitacion.setCapacidad5(cap5 + 1);
		}
		cliente.setReserva(false);
		
		for (int i = 0; i < Recepcion.getHotel().getReservas().size(); i++) {
			if (Recepcion.getHotel().getReservas().get(i).cliente.equals(cliente)) {
				Recepcion.getHotel().getReservas().get(i).getCliente().getHabitacion().setCliente(null);
				Recepcion.getHotel().getReservas().get(i).getCliente().setHabitacion(null);
				Recepcion.getHotel().getReservas().remove(Recepcion.getHotel().getReservas().get(i));
				break;
		}
			break;
		}
	}
	
	/*
	 * El siguiente método es una sobrecarga del método anterior, cuya funcionalidad es eliminar la reserva de la 
	 * lista de reservas, el método es utilizado si al intentar asignar una habitación a un cliente no hay disponibilidad
	 * de acuerdo a la capacidad que necesita 
	 */
	public void cancelar_reserva() {
		Recepcion.getHotel().getReservas().remove(this);
		cliente.setReserva(false);
	}
}
