package gestorAplicacion.Personal;

import java.io.Serializable;

import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.*;
import uiMain.Recepcion;
/* Autor: Ver�nica Seguro Varela.
 * Componentes: Atributos, constructores, m�todos gets y sets,toString(),
 * asignarSalario() m�todo obligatorio al ser esta clase heredada de la clase 
 * Empleado y m�todo limpiarHabitacion().
 * Finalidad: El objetivo de esta clase es utilizar a las mucamas para dar 
 * disponibilidad a las habitaciones de los clientes que dejan el hotel, estas 
 * al ser llamadas a trav�s del m�todo limpiarHabitacion() tendr�n una habitaci�n
 * asignada la cual dejar�n disponible para un nuevo cliente.
 *  */
   public class Mucama extends Empleado {

	private static final long serialVersionUID = 1L;
	
	private Habitacion habitacion;
	
	//CONSTRUCTORES 
	/* Se usar�n los constructores de su clase padre Empleado, el tipo constructor a usar
	 * depender� si la mucama tiene horas extras por pagar o no. 
	 * */
	
	public Mucama(String nombre, long id, HorasExtras horasextras, int cantidadHoras) {
		super(nombre, id, "Mucama", horasextras, cantidadHoras);
	}

	public Mucama(String nombre, long id) {
		super(nombre, id, "Mucama");
	}

   public Mucama() {
		
	}

	/* M�todo que le asignar� a los objetos de tipo mucama un salario fijo de
    * $915.000 
    */
	@Override
	public void asignarSalario() {
		super.setSalario(915000);
		bono();
	}
	//M�TODO GET Y SET: para el acceso y modificaci�n.
	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	/* SOBRECARGA DE M�TODOS.*/

	/* Este m�todo ser� usado cuando al salir el cliente, la lista de clientes que hay para su habitaci�n
	asignada queda vac�a, por lo tanto, modifica las capacidades y da la disponibilidad de la habitaci�n.*/
	public void limpiarHabitacion(Habitacion habitacion) {
		this.habitacion=habitacion;
			
			int cap2 = Habitacion.getCapacidad2();
			int cap3 = Habitacion.getCapacidad3();
			int cap4 = Habitacion.getCapacidad4();
			int cap5 = Habitacion.getCapacidad5();
			
			habitacion.setDisponibilidadHab(true);																	// habitacion
				if (habitacion.getTipoCapacidad() == 2) {
					Habitacion.setCapacidad2(cap2 + 1); 
					return;
				} else if (habitacion.getTipoCapacidad() == 3) {
					Habitacion.setCapacidad3(cap3 + 1);
					return;
				} else if (habitacion.getTipoCapacidad() == 4) {
					Habitacion.setCapacidad4(cap4 + 1);
					return;
				} else if (habitacion.getTipoCapacidad() == 5) {
					Habitacion.setCapacidad5(cap5 + 1);
					return;
				}		
	}

	/*Este m�todo ser� llamado cuando al salir el cliente, la habitaci�n tiene aun reservas pendientes, por lo
	 * tanto, el cliente que est� en la primera posici�n de la lista pasa a ocupar la habitaci�n.*/
	public void limpiarHabitacion(Cliente cliente) {
		this.habitacion = cliente.getHabitacion();
		
		habitacion.getClientes().get(0).setReserva(false);
		
		for(Reserva i : Hotel.getReservas()) {
			if(i.getCliente().equals(cliente)) {
				Hotel.getReservas().remove(i);
			}
		}
		
	}
}
