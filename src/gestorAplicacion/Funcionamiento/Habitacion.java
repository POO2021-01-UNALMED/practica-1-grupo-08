package gestorAplicacion.Funcionamiento;
import gestorAplicacion.Cliente;
import static java.time.temporal.ChronoUnit.DAYS;
import uiMain.Recepcion;
import java.io.Serializable;

/*Autores: Ximena Casta�eda.
 *Componentes: Atributos,constructor,m�todos get y set,m�todos disponibilidad(),precioHabitacion() y aumentarCapacidad().
 *Finalidad: Contiene informaci�n b�sica que registra un hotel de sus habitaciones y los m�todos necesarios 
 *para su control. Por tanto, permite crear instancias de tipo habitaci�n, donde cada una ser� 
 *relacionada con una instancia cliente cuando se haga una reserva o se tome una habitaci�n.
 *Esta clase contiene el atributo constante,serialVersionUID, necesario para la serizalizaci�n de las instancias
 *y dos atributos de referencia, cliente y reserva, para establecer la relaci�n entre objetos mencionada anteriormente.
 *Cada objeto de esta clase ser� almacenado en la lista habitaciones de la clase Hotel.
 **/


public class Habitacion implements Serializable {
	
	//ATRIBUTOS.
	private static final long serialVersionUID = 1L;
	private int numHabitacion;
	//Cantidad de personas que pueden alojar una habitaci�n.
	private int tipoCapacidad;
	private int precio;
	private boolean disponibilidadHab;
  /*Los atributos que tienen por nombre "capacidad" llevaran el conteo de cu�ntas habitaciones disponibles para 
   * 1,2,3,4 y 5 personas tiene el hotel,por tal motivo son est�ticos.*/
	private static int capacidad2 = 0;
	private static int capacidad3 = 0;
	private static int capacidad4 = 0;
	private static int capacidad5 = 0;
	private Cliente cliente;
	
	//CONSTRUCTOR.
	public Habitacion(int numHabitacion, int tipoCapacidad) {
		this.numHabitacion = numHabitacion;
		this.disponibilidadHab = true;
		this.tipoCapacidad = tipoCapacidad;
		Recepcion.getHotel().getHabitaciones().add(this);
	}

	//M�TODOS SET Y GET: permiten acceder y modificar el valor de los atributos. 
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

	public int getTipoCapacidad() {
		return this.tipoCapacidad;
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	//M�TODOS.
	
	/*Verifica si hay una habitaci�n disponible con la capacidad de personas requerida.Tiene como param�tro de entrada
	 * un entero que indica el n�mero de acompa�antes del cliente a quien se asignar� una habitaci�n y retorna un boolean
	 * que negar� cuando no halla una habitaci�n disponible para esa cantidad de personas acompa�antes m�s el cliente titular. 
	 */
	public static boolean disponibilidad(int numAcompanantes) {
		int totalPersonas = 1 + numAcompanantes;
		boolean confirmacion = true;

		if ((totalPersonas == 1) && capacidad2 == 0) {
			confirmacion = false;
		} else if ((totalPersonas == 2) && capacidad2 == 0) {
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
    
	/*Calcula el valor de la habitaci�n seg�n la cantidad de personas que aloja y los d�as de estad�a del cliente.
	 *Este m�todo no tiene par�metros de entrada o salida,porque el valor resultante del c�lculo es guardado en 
	 *el atributo precio de cada instancia. */
	public void precioHabitacion() {
		long diff = DAYS.between(cliente.getFecha_entrada(),cliente.getFecha_salida());/*
		Hace el c�lculo de d�as entre dos fechas, en este caso la fecha de entrada y la fecha de
		salida del cliente*/
		if (tipoCapacidad == 2) {
			precio = 70000*(int)diff;
		} else if (tipoCapacidad == 3) {
			precio = 100000*(int)diff;
		} else if (tipoCapacidad == 4) {
			precio = 130000*(int)diff;
		} else if (tipoCapacidad == 5) {
			precio = 170000*(int)diff;
		}
	}

	/*Modifica los atributos de clase. Seg�n la capacidad de personas que aloja cada habitaci�n perteneciente al hotel,
	 *aumenta en uno el valor del atributo correspondiente,para esto se recorre el arreglo que almacena cada instancia habitaci�n.
	 *No recibe ni retorna param�tros ya que modifica los atributos est�ticos y no es necesario su retorno.*/
	public static void aumentarCapacidad() {
		for (Habitacion i: Recepcion.getHotel().getHabitaciones()) {
			if (i.tipoCapacidad == 2) {
				capacidad2 = capacidad2+1;
			}
			else if (i.tipoCapacidad == 3) {
				capacidad3 = capacidad3+1;
			}
			else if (i.tipoCapacidad == 4) {
				capacidad4 = capacidad4+1;
			}
			else if (i.tipoCapacidad == 5) {
				capacidad5 = capacidad5+1;
			}
		}
	}

}
