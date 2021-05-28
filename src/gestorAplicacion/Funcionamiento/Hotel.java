package gestorAplicacion.Funcionamiento;
import uiMain.*;
import java.util.ArrayList;
import gestorAplicacion.*;
import gestorAplicacion.Personal.Empleado;

public class Hotel {

	//ATRIBUTOS	
	static final int codigoRNT = 10562;
	private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private ArrayList<Servicio> servicios = new ArrayList<Servicio>();
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int ingresos;

	//CONSTRUCTOR
	public Hotel(){
		
	}
	
	//MÉTODOS GET Y SET: permiten acceder y modificar el valor de los atributos. 
	public int getcodigoRNT() {
		return codigoRNT;
	}
	
	public int getIngresos() {
		return ingresos;
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

	public void setIngresos(int ingresos) {
		this.ingresos += ingresos;
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
	
	// si la habitacion es asignada cambiar disponibilidad
	public void asignarHabitacion(Cliente cliente) {
		int cap2 = Habitacion.getCapacidad2();
		int cap3 = Habitacion.getCapacidad3();
		int cap4 = Habitacion.getCapacidad4();
		int cap5 = Habitacion.getCapacidad5();
		if (Habitacion.disponibilidad(cliente.getNumAcompanantes()) == true) {// va a disponibilidad con el parametro de
			
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

	public void descuentoPorConsumo(Cliente cliente) {
		if (cliente.getServicio().getGastosServicios() > 150000) {
			int gasto = cliente.getServicio().getGastosServicios();
			int porcentaje = (gasto - (int) ((gasto * 0.12)));
			cliente.getServicio().setGastosServicios(porcentaje);
		}
	}

	public void cobrarDeudas(Cliente cliente) {
		Recepcion.getHotel().descuentoPorConsumo(cliente);
		Recepcion.getHotel().descuentoFamiliar(cliente);
		cliente.getHabitacion().precioHabitacion();
		int preciofin = cliente.getHabitacion().getPrecio();
		int gastoser = cliente.getServicio().getGastosServicios();
		cliente.setCuentaFinal(gastoser + preciofin);
		int nuevosaldo = cliente.getSaldo() - cliente.getCuentaFinal();
		cliente.setSaldo(nuevosaldo);
		Recepcion.getHotel().setIngresos(cliente.getCuentaFinal());
	}
	//AQUI!!
	
	public int gananciaNeta() {
		int total = 0;
		for (Cliente i : Recepcion.getHotel().getClientes()) {
			total += i.getCuentaFinal();
		}
		int salario = Recepcion.getAd1().pagarSalario();
		return total - salario;
	}
}