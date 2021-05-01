package gestorAplicacion.Funcionamiento;

import uiMain.*;

import java.io.Serializable;
import java.lang.Math.*;
import java.util.ArrayList;

import baseDatos.Deserializacion;
import gestorAplicacion.*;
import gestorAplicacion.Personal.Empleado;
import gestorAplicacion.Personal.Mucama;

public class Hotel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private ArrayList<Servicio> servicios = new ArrayList<Servicio>();
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private ArrayList<Mucama> mucamas = new ArrayList<Mucama>();
	public ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	/*public Hotel() {
		Deserializacion.deserializar(this);
		
	}*/
	
	public Hotel(){
		
	}
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Habitacion> habitaciones1) {
		habitaciones = habitaciones1;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> Listareservas) {
		reservas = Listareservas;
	}

	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<Servicio> ListaServicios) {
		servicios = ListaServicios;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> listaempleados) {
		empleados = listaempleados;
	}

	public ArrayList<Mucama> getMucamas() {
		return mucamas;
	}

	public void setMucamas(ArrayList<Mucama> listamucamas) {
		mucamas = listamucamas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setCliente(ArrayList<Cliente> listaClientes) {
		clientes = listaClientes;
	}

	// habitaciones con capacidad dos[[103,104,105,106,107],[103,104,105,106,107]]
	// si la habitacion es asignada cambiar disponibilidad
	public void asignarHabitacion(Cliente cliente) {
		int cap2 = Habitacion.getCapacidad2();
		int cap3 = Habitacion.getCapacidad3();
		int cap4 = Habitacion.getCapacidad4();
		int cap5 = Habitacion.getCapacidad5();
		if (Habitacion.disponibilidad(cliente.getNumAcompanantes()) == true) {// va a disponibilidad con el parametro de
																				// num de clientes
			if ((cliente.getNumAcompanantes() + 1 == 1) || (cliente.getNumAcompanantes() + 1 == 2)) {
				Habitacion.setCapacidad2(cap2 - 1);

			} else if ((cliente.getNumAcompanantes() + 1 == 3)) {
				Habitacion.setCapacidad3(cap3 - 1);

			} else if ((cliente.getNumAcompanantes() + 1 == 4)) {
				Habitacion.setCapacidad4(cap4 - 1);

			} else if ((cliente.getNumAcompanantes() + 1 == 5)) {
				Habitacion.setCapacidad5(cap5 - 1);
			}
			for (int i = 0; i < Recepcion.hotel.getHabitaciones().size(); i++) {
				if (Recepcion.hotel.getHabitaciones().get(i).getTipoCapacidad() == cliente.getNumAcompanantes() + 1) {
					cliente.setHabitacion(Recepcion.hotel.getHabitaciones().get(i));
					//System.out.println(cliente.getHabitacion()); ///////////////////////
					Recepcion.hotel.getHabitaciones().get(i).setCliente(cliente);
					Recepcion.hotel.getHabitaciones().get(i).disponibilidadHab = false;
					break;
				}
			}
			return;
		}

		// ¿desea hacer reserva? !!!!!

		// Reserva reserva = new
		// Reserva(cliente.getFecha_entrada(),cliente.getFecha_salida(), cliente);

	}

	public void descuentoFamiliar(Cliente cliente) {
		if (cliente.getIdFamiliar() != 0) {
			for (int i = 0; i < Recepcion.hotel.getEmpleados().size(); i++) {
				if (Recepcion.hotel.getEmpleados().get(i).getId() == cliente.getIdFamiliar()) {
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

	// Probar
	public void cobrarDeudas(Cliente cliente) {
		Recepcion.hotel.descuentoPorConsumo(cliente);
		Recepcion.hotel.descuentoFamiliar(cliente);
		int preciofin = cliente.getHabitacion().getPrecio();
		int gastoser = cliente.getServicio().getGastosServicios();
		cliente.setCuentaFinal(gastoser + preciofin);
		int nuevosaldo = cliente.getSaldo() - cliente.getCuentaFinal();
		cliente.setSaldo(nuevosaldo);
		int rd = (int) (Math.random() * (Recepcion.hotel.getMucamas().size() + 1));
		Recepcion.hotel.getMucamas().get(rd).limpiarHabitacion(cliente.getHabitacion().getNumhabitacion());// Asignación
																											// de mucama
		cliente.getHabitacion().setCliente(null);
		cliente.setHabitacion(null);
	}

	public int gananciaNeta() {
		int total = 0;
		for (Cliente i : Recepcion.hotel.getClientes()) {
			total += i.getCuentaFinal();
		}
		int salario = Recepcion.ad1.pagarSalario();
		return total - salario;
	}
}