package gestorAplicacion.Funcionamiento;
import uiMain.*;
import java.util.ArrayList;
import gestorAplicacion.*;
import gestorAplicacion.Personal.Empleado;

/*Autores: Veronica Seguro, Ximena Castañeda y Yojan Alcaraz.
 *Componentes: Atributos,métodos get y set,métodos asignarHabitacion(),descuentoFamiliar(),descuentoPorConsumo(),
 *cobrarDeudas() y gananciaNeta().
 *Finalidad: Esta clase junto a "Recepcion" son las clases principales que permiten el funcionamiento del sistema. 
 *La clase hotel reúne la información general del hotel por medio de 5 arreglos donde cada uno almacena los objetos de cada tipo y 
 *dos atributos enteros que indican el código RNT.
 *Además, los métodos que define son complementarios a los métodos que desarrollan las funcionalidades principales 
 *del programa (Recepcion).*/

/*Esta clase no se definió serializable, ya que al ser la clase central solo es necesario una instancia de su tipo. Dicha
 * instancia es creada en la clase "Recepcion" y sus atributos son llenados al ejecutar el programa (excepto codigoRNT).
 */


public class Hotel {

	//ATRIBUTOS	
	//Atributo constante único para el hotel ya que indica su registro turístico.
	private static final int codigoRNT = 10562;
	private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private ArrayList<Servicio> servicios = new ArrayList<Servicio>();
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	

	
	//MÉTODOS GET Y SET: permiten acceder y modificar el valor de los atributos. 
	public int getcodigoRNT() {
		return codigoRNT;
	}
	
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public ArrayList<Servicio> getServicios() {
		return servicios;
	}
	
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public void setHabitaciones(ArrayList<Habitacion> habitaciones1) {
		habitaciones = habitaciones1;
	}

	public void setReservas(ArrayList<Reserva> Listareservas) {
		reservas = Listareservas;
	}

	public void setServicios(ArrayList<Servicio> ListaServicios) {
		servicios = ListaServicios;
	}

	public void setEmpleados(ArrayList<Empleado> listaempleados) {
		empleados = listaempleados;
	}

	public void setCliente(ArrayList<Cliente> listaClientes) {
		clientes = listaClientes;
	}

	//MÉTODOS.
	
	/*Asigna una habitación al cliente después de comprobar que hay habitaciones disponibles para el número de personas que
	 *necesita; establece la relación habitación-cliente por medio de los atributos de referencia en cada instancia y cambia
	 *la disponiblidad de la habitación a "false" para que no sea asignada a otro cliente.
	 *Luego, disminuye el número de habitaciones disponibles con la capacidad requerida por el cliente, restando uno a los 
	 *atributos estáticos de capacidad en la clase habitación.
	 *Recibe como parámetro una instancia cliente para realizar la relación descrita anteriormente y no retorna ningún valor.*/
	public void asignarHabitacion(Cliente cliente) {
		int cap2 = Habitacion.getCapacidad2();
		int cap3 = Habitacion.getCapacidad3();
		int cap4 = Habitacion.getCapacidad4();
		int cap5 = Habitacion.getCapacidad5();
		if (Habitacion.disponibilidad(cliente.getNumAcompanantes()) == true) {
			
			for (Habitacion i: Recepcion.getHotel().getHabitaciones()) {
				if (cliente.getNumAcompanantes() == 0){
					if((i.getTipoCapacidad() == 2) && (i.isDisponibilidadHab() == true)){
						cliente.setHabitacion(i);
						i.setCliente(cliente);
						i.setDisponibilidadHab(false);
						break;
					}
				} else if ((i.getTipoCapacidad() == (cliente.getNumAcompanantes() + 1)) && (i.isDisponibilidadHab() == true)){
					cliente.setHabitacion(i);
					i.setCliente(cliente);
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
	public void descuentoFamiliar(Cliente cliente) {
		if (cliente.getIdFamiliar() != 0) {
			for (int i = 0; i < Recepcion.getHotel().getEmpleados().size(); i++) {
				if (Recepcion.getHotel().getEmpleados().get(i).getId() == cliente.getIdFamiliar()) {
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
	public void descuentoPorConsumo(Cliente cliente) {
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
	public void cobrarDeudas(Cliente cliente) {
		Recepcion.getHotel().descuentoPorConsumo(cliente);
		Recepcion.getHotel().descuentoFamiliar(cliente);
		cliente.getHabitacion().precioHabitacion();
		int preciofin = cliente.getHabitacion().getPrecio();
		int gastoser = cliente.getServicio().getGastosServicios();
		cliente.setCuentaFinal(gastoser + preciofin);	
	}
	
	/*Calcula la ganancia neta del hotel,sumando el dinero recibido por la cuenta Final de cada cliente alojado y restando 
	 * el pago de salario a cada empleado. Tiene como parámetro de retorno un entero que indica el valor final de la 
	 * ganancia neta.*/
	public int gananciaNeta() {
		int total = 0;
		for (Cliente i : Recepcion.getHotel().getClientes()) {
			total += i.getCuentaFinal();
		}
		int salario = Recepcion.getAd1().pagarSalario();
		return total - salario;
	}
}