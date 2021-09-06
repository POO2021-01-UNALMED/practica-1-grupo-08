package gestorAplicacion.Funcionamiento;
import uiMain.*;
import java.util.ArrayList;

import Errores.ExcepcionNoGanancias;
import gestorAplicacion.*;
import gestorAplicacion.Personal.Administrador;
import gestorAplicacion.Personal.Empleado;

/*Autores: Veronica Seguro, Ximena Castañeda y Yojan Alcaraz.
 *Componentes: Atributos,métodos get y set,métodos asignarHabitacion(),descuentoFamiliar(),descuentoPorConsumo(),
 *cobrarDeudas() y gananciaNeta().
 *Finalidad: Esta clase junto a "Recepcion" son las clases principales que permiten el funcionamiento del sistema. 
 *La clase hotel reúne la información general del hotel por medio de 5 arreglos donde cada uno almacena los objetos de cada tipo y 
 *dos atributos enteros que indican el código RNT.
 *Además, los métodos que define son complementarios a los métodos que desarrollan las funcionalidades principales 
 *del programa (Recepcion).*/

/*Esta clase no se definió serializable, ya que al ser la clase central no es necesario una instancia de su tipo. */


public abstract class Hotel {

	//ATRIBUTOS	
	//Atributo constante único para el hotel ya que indica su registro turístico.
	private static final int codigoRNT = 10562;
	private static ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
	private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private static ArrayList<Servicio> servicios = new ArrayList<Servicio>();
	private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static Administrador ad1 = new Administrador("Julián", 134344);

	
	//MÉTODOS GET Y SET: permiten acceder y modificar el valor de los atributos. 
	public static int getcodigoRNT() {
		return codigoRNT;
	}
	
	public static ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	
	public static ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public static ArrayList<Servicio> getServicios() {
		return servicios;
	}
	
	public static ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public static void setHabitaciones(ArrayList<Habitacion> habitaciones1) {
		habitaciones = habitaciones1;
	}

	public static void setReservas(ArrayList<Reserva> Listareservas) {
		reservas = Listareservas;
	}

	public static void setServicios(ArrayList<Servicio> ListaServicios) {
		servicios = ListaServicios;
	}

	public static void setEmpleados(ArrayList<Empleado> listaempleados) {
		empleados = listaempleados;
	}

	public static void setCliente(ArrayList<Cliente> listaClientes) {
		clientes = listaClientes;
	}

	//MÉTODOS.
	
	/*Asigna una habitación al cliente después de comprobar que hay habitaciones disponibles para el número de personas que
	 *necesita; establece la relación habitación-cliente por medio de los atributos de referencia en cada instancia y cambia
	 *la disponiblidad de la habitación a "false" para que no sea asignada a otro cliente a no ser que sea por medio de una reserva.
	 *Luego, disminuye el número de habitaciones disponibles con la capacidad requerida por el cliente, restando uno a los 
	 *atributos estáticos de capacidad en la clase habitación.
	 *Recibe como parámetro una instancia cliente para realizar la relación descrita anteriormente y no retorna ningún valor.*/
	public static void asignarHabitacion(Cliente cliente) {
		int cap2 = Habitacion.getCapacidad2();
		int cap3 = Habitacion.getCapacidad3();
		int cap4 = Habitacion.getCapacidad4();
		int cap5 = Habitacion.getCapacidad5();
		if (Habitacion.disponibilidad(cliente.getNumAcompanantes()) == true) {
			
			for (Habitacion i: Hotel.getHabitaciones()) {
				if (cliente.getNumAcompanantes() == 0){
					if((i.getTipoCapacidad() == 2) && (i.isDisponibilidadHab() == true)){
						cliente.setHabitacion(i);
						i.setClientes(cliente);
						i.setDisponibilidadHab(false);
						break;
					}
				} else if ((i.getTipoCapacidad() == (cliente.getNumAcompanantes() + 1)) && (i.isDisponibilidadHab() == true)){
					cliente.setHabitacion(i);
					i.setClientes(cliente);
					i.setDisponibilidadHab(false);
					break;
				}
			}
			if ((cliente.getNumAcompanantes() + 1) == 1) {
				Habitacion.setCapacidad2(cap2 - 1);
			} else if (cliente.getNumAcompanantes() + 1 == 2){
				Habitacion.setCapacidad2(cap2 - 1);
			} else if ((cliente.getNumAcompanantes() + 1 == 3)) {
				Habitacion.setCapacidad3(cap3 - 1);

			} else if ((cliente.getNumAcompanantes() + 1 == 4)) {
				Habitacion.setCapacidad4(cap4 - 1);

			} else if ((cliente.getNumAcompanantes() + 1 == 5)) {
				Habitacion.setCapacidad5(cap5 - 1);
			}
			return;
		}
	}

	/*Efectua el descuento que tienen los clientes si son familiares de algún empleado del hotel.Tiene como parámetro de 
	 * entrada una instancia cliente para verificar el parentesco, se utiliza su atributo "idFamiliar" que indica 
	 * la cédula del empleado y dicho descuento es hecho sobre el gasto en servicios que lleva el cliente.
	 * Por ser una operación interna no retorna ningún valor.*/
	public static void descuentoFamiliar(Cliente cliente) {
		if (cliente.getIdFamiliar() != 0) {
			for (int i = 0; i < Hotel.getEmpleados().size(); i++) {
				if (Hotel.getEmpleados().get(i).getId() == cliente.getIdFamiliar()) {
					int descuento = cliente.getServicio().getGastosServicios() - 40000;
					cliente.getServicio().setGastosServicios(descuento);
					break;
				}
			}
		}
		return;
	}

	/*Efectua el descuento que tienen los clientes si consumen más de $150.000 en el restaurante y la zona de atracciones.
	 * Tiene como parámetro de entrada una instancia cliente para que a través de su atributo de referencia "servicio",
	 * se realice el descuento sobre el valor del atributo "gastoServicio".
	 * Por ser una operación interna no retorna ningún valor.*/
	public static void descuentoPorConsumo(Cliente cliente) {
		if (cliente.getServicio().getGastosServicios() > 150000) {
			int gasto = cliente.getServicio().getGastosServicios();
			int porcentaje = (gasto - (int) ((gasto * 0.12)));
			cliente.getServicio().setGastosServicios(porcentaje);
		}
	}

	/*Este método permite cobrar la cuenta final del cliente en el hotel,por ello tiene como parámetro de entrada una instancia
	 *cliente, para conocer el valor de la habitación en que se alojó, los gastos en servicios y si aplica a alguno de los
	 *dos descuentos.Después de calcular el valor final a pagar, se guarda en el atributo "cuentaFinal" 
	 */
	public static void cobrarDeudas(Cliente cliente) {
		Hotel.descuentoPorConsumo(cliente);
		Hotel.descuentoFamiliar(cliente);
		cliente.getHabitacion().precioHabitacion();
		int preciofin = cliente.getHabitacion().getPrecio();
		int gastoser = cliente.getServicio().getGastosServicios();
		cliente.setCuentaFinal(gastoser + preciofin);	
	}
	
	/*Calcula la ganancia neta del hotel,sumando el dinero recibido por la cuenta Final de cada cliente alojado y restando 
	 * el pago de salario a cada empleado. Tiene como parámetro de retorno un entero que indica el valor final de la 
	 * ganancia neta.*/
	public static int gananciaNeta() throws ExcepcionNoGanancias {
		int total = 0;
		for (Cliente i : Hotel.getClientes()) {
			total += i.getCuentaFinal();
		}
				
		int salario = Hotel.getAd1().pagarSalario();
		if(total-salario <= 0) {
			throw new ExcepcionNoGanancias();
		}
		return total - salario;
		
	}
	
	public static Administrador getAd1() {
		return ad1;
	}
}