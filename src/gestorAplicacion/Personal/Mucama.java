package gestorAplicacion.Personal;

import java.io.Serializable;
import gestorAplicacion.Funcionamiento.*;
import uiMain.Recepcion;
/* Autor: Verónica Seguro Varela.
 * Componentes: Atributos, constructores, métodos gets y sets,toString(),
 * asignarSalario() método obligatorio al ser esta clase heredada de la clase 
 * Empleado y método limpiarHabitacion().
 * Finalidad: El objetivo de esta clase es utilizar a las mucamas para dar 
 * disponibilidad a las habitaciones de los clientes que dejan el hotel, estas 
 * al ser llamadas a través del método limpiarHabitacion() tendrán una habitación
 * asignada la cual dejarán disponible para un nuevo cliente.
 *  */
   public class Mucama extends Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Habitacion habitacion;
	
	//CONSTRUCTORES 
	/* Se usarán los constructores de su clase padre Empleado, el tipo constructor a usar
	 * dependerá si la mucama tiene horas extras por pagar o no. 
	 * */
	
	public Mucama(String nombre, long id, HorasExtras horasextras, int cantidadHoras) {
		super(nombre, id, "Mucama", horasextras, cantidadHoras);
	}

	public Mucama(String nombre, long id) {
		super(nombre, id, "Mucama");
	}

	//MÉTODOS 
	
   /* Método que le asignará a los objetos de tipo mucama un salario fijo de
    * $915.000 
    */
	@Override
	public void asignarSalario() {
		super.setSalario(915000);
	}
	//Get y Set 
	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	/* Método que recibe un atributo de tipo habitación el cual será la habitación 
	 * que se le asignará a la mucama para limpiar, este método tiene como
	 * objetivo dejar disponible la habitación que se le asigna a la mucama 
	 * para ser usada por otro cliente, por ende este método será llamada cada vez
	 * que un cliente salga de un hotel.
	 * */
	public void limpiarHabitacion(Habitacion habitacion) {
		this.habitacion=habitacion;
			int cap2 = Habitacion.getCapacidad2();
			int cap3 = Habitacion.getCapacidad3();
			int cap4 = Habitacion.getCapacidad4();
			int cap5 = Habitacion.getCapacidad5();
			
				habitacion.setDisponibilidadHab(true);// cambio la disponibilidad de la																	// habitacion
				if (habitacion.getTipoCapacidad() == 2) {
					Habitacion.setCapacidad2(cap2 + 1); // si la cap es de 2, aumento en habitacion esa capacida
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
	
	//?????????????
	/*
	public String toString() {
		if (habitacion == null) {
			return "Mucama identificada con " + getId() + " sin habitaciones asignadas";
		}
		return "Mucama con identificación: " + getId() + "con habitación asignada: " + habitacion.getNumhabitacion();
		
	}*/
}
