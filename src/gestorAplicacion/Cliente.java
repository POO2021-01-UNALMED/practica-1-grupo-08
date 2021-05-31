package gestorAplicacion;
import gestorAplicacion.Funcionamiento.*;
import gestorAplicacion.Personal.*;
import uiMain.Recepcion;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/*Autores: Yojan Andr�s Alcaraz P�rez.
 ** Componentes: El presente m�dulo contiene la clase Cliente, sus atributos, su constructor y un caso 
 * de sobrecarga de este, los respectivos m�todos get y set de cada uno de los atributos que lo requieren 
 * y un m�todo toString.
 ** Funcionalidad y finalidad: La clase Cliente permite almacenar informaci�n sobre los clientes que se 
 * hospedar�n en el hotel, pemitiendo crear objetos de tipo Cliente que ser�n relacionados con sus respectivas 
 * instancias de tipo Habitaci�n en el momento que el cliente tome una habitaci�n y Servicio cuando el cliente 
 * haga uso de un servicio, para ello, la clase cuentas con dos atributos de referencia, habitacion y servicio. 
 */

public class Cliente implements Serializable,Persona{
	/**
	 * 
	 */
	// ATRIBUTOS.
	
	// El siguiente atributo es necesario para la serizalizaci�n de las instancias de esta clase.
	private static final long serialVersionUID = 1L; 
	
	private String nombre;
	private long id;
	/* Los dos siguientes atributos, fecha_entrada y fecha_salida, hacen referencia a la fecha en la que el 
	 * cliente ingresa al hotel y la fecha en la que sale, respectivamente.
	 */
	private LocalDate fecha_entrada;
	private LocalDate fecha_salida;
	/* Es necesario saber si el cliente cuenta con familiares que son empleados del hotel para aplicar a 
	 * descuentos durante su estancia, para la verificaci�n de ello establecemos el atributo idFamiliar.
	 */
	private long idFamiliar;
	private int numAcompanantes;
	private boolean reserva;
	private int cuentaFinal; // Que almacenar� los gastos totales del cliente durante su estancia en el hotel.
	private int saldo;
	private Habitacion habitacion;
	private Servicio servicio;
	
	
	public static DateTimeFormatter convertidor = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // ��!! TENER EN CUENTA //////
	
	// CONSTRUCTORES.
	
	public Cliente(String nombre,long id,String fecha_entrada,String fecha_salida, int numAcompanantes,int saldo, long idFamiliar) {
		this(nombre, id, fecha_entrada, fecha_salida, numAcompanantes,saldo);
		this.idFamiliar = idFamiliar;
	}
	

	public Cliente(String nombre,long id,String fecha_entrada,String fecha_salida, int numAcompanantes ,int saldo) {
		this.nombre = nombre;
		this.id = id;
		LocalDate fecha_entrar = LocalDate.parse(fecha_entrada);
		this.fecha_entrada= fecha_entrar;
		LocalDate fecha_salir = LocalDate.parse(fecha_salida);
		this.fecha_salida= fecha_salir;
		this.numAcompanantes = numAcompanantes;
		this.saldo = saldo;
		Recepcion.getHotel().getClientes().add(this);
	}

	
	
	// M�TODOS GET Y SET: para el acceso y modificaci�n (cuando sea necesario) de los atributos.
    
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(String fecha_entrada) {
		LocalDate fecha_entrar = LocalDate.parse(fecha_entrada);
		this.fecha_entrada= fecha_entrar;
		}

	public LocalDate getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(String fecha_salida) {
		LocalDate fecha_salir = LocalDate.parse(fecha_salida);
		this.fecha_salida= fecha_salir;
	}

	public int getNumAcompanantes() {
		return numAcompanantes;
	}

	public boolean isReserva() {
		return reserva;
	}

	public void setReserva(boolean reserva) {
		this.reserva = reserva;
	}

	public int getCuentaFinal() {
		return cuentaFinal;
	}

	public void setCuentaFinal(int cuentaFinal) {
		this.cuentaFinal = cuentaFinal;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	public Servicio getServicio() {
		return servicio;
	}
	
	public void setIdFamiliar(long id) {
		this.idFamiliar = id;
	}
	
	public long getIdFamiliar() {
		return this.idFamiliar;
	}
	
	public void setNumAcompanantes(int numAcompanantes) {
		this.numAcompanantes = numAcompanantes;
	}


	// M�TODOS.
	
	/*El siguiente m�todo toString ser� utilizado en la funcionalidad "Mostrar clientes" que nos permitir� 
	 * obtener la lista de clientes que al momento se encuentran hospedados en el hotel.
	 * 
	 */
	public String toString() {
		if (habitacion == null) {
			return "Cliente identificado con " + id + " sin habitaci�n asignada";
		}
		return "Cliente identificado con " + id + ", hospedado en la habitaci�n " + habitacion.getNumhabitacion();
	}
	
}
