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
	
	// CONSTRUCTOR:
	public Reserva(String fecha_de_ingreso, String fecha_de_salida, Cliente cliente) {
		LocalDate fecha_ingresar = LocalDate.parse(fecha_de_ingreso);
		this.fecha_de_ingreso = fecha_ingresar;
		LocalDate fecha_salir = LocalDate.parse(fecha_de_salida);
		this.fecha_de_salida = fecha_salir;
		this.cliente = cliente;
		
		cliente.setReserva(true);
		Hotel.getReservas().add(this);
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
	
		
	/* El método permite a los clientes cancelar sus reservas, eliminar de la lista de reservas para quitar
	 * la relación reserva - cliente y viceversa, al igual que la relación cliente - habitación.
	 * El parámetro de entrada es el cliente que reservó y no posee parámetros de salida, pues lo que hace 
	 * es la modificación de atributos y eliminación de una instancia en la lista.
	 */

	public void cancelar_reserva(Cliente cliente) {
		cliente.getHabitacion().getClientes().remove(cliente);
		
		cliente.setReserva(false);
		
		for (int i = 0; i < Hotel.getReservas().size(); i++) {
			if (Hotel.getReservas().get(i).cliente.equals(cliente)) {
				Hotel.getReservas().get(i).getCliente().setHabitacion(null);
				Hotel.getReservas().remove(Hotel.getReservas().get(i));
				break;
			}
			
		}
	}
	

}
