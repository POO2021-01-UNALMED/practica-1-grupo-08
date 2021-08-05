package gestorAplicacion.Funcionamiento;
import gestorAplicacion.*;
import java.util.Date;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import uiMain.*;

/*Autores: Yojan Andr�s Alcaraz P�rez.
 ** Componentes: El presente m�dulo contiene la clase Reserva, sus atributos, su constructor, 
 * los respectivos m�todos get y set de cada uno de los atributos que lo requieren y los m�todos
 * reasignar_reserva() y cancelar_reserva().
 ** Funcionalidad y finalidad: Esta clase permite almacenar informaci�n sobre las reservas que 
 * realizar�n los clientes, por lo que es necesario aqu� un atributo de tipo Cliente.
 * Cada objeto de esta clase ser� almacenado en la lista reservas de la clase Hotel.*/

public class Reserva implements Serializable {

	/**
	 * 
	 */
	// ATRIBUTOS.
	//El siguiente atributo es necesario para la serizalizaci�n de las instancias de esta clase.
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

	// M�TODOS GET Y SET: que permiten el acceso y modificaci�n de los atributos que as� lo requieran.

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

	/// M�TODOS:
	
		
	/* El m�todo permite a los clientes cancelar sus reservas, eliminar de la lista de reservas para quitar
	 * la relaci�n reserva - cliente y viceversa, al igual que la relaci�n cliente - habitaci�n.
	 * El par�metro de entrada es el cliente que reserv� y no posee par�metros de salida, pues lo que hace 
	 * es la modificaci�n de atributos y eliminaci�n de una instancia en la lista.
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
