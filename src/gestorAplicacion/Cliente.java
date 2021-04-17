package gestorAplicacion;

import gestorAplicacion.Funcionamiento.*;

import gestorAplicacion.Personal.*;

public class Cliente {
	private String nombre;
	private long cedulaIdentidad;
	private int numNoches;
	private String parentescoEmpleado;
	private int numAcompañantes;
	private boolean reserva;
	public int cuentaFinal;
	public int saldo;
	public Habitacion habitacion;
	public Hotel hotel;
	public Servicio servicio;
	
	
	public Cliente(String nombre,long cedula,int numNoches,int saldo) {
		this.nombre = nombre;
		this.cedulaIdentidad = cedula;
		this.numNoches = numNoches;
		this.saldo = saldo;
	}
	
	public Cliente() {
		
	}
	
	//Setter y getters

	public int getNumNoches() {
		return numNoches;
	}

	public void setNumNoches(int numNoches) {
		this.numNoches = numNoches;
	}

	public String getParentescoEmpleado() {
		return parentescoEmpleado;
	}

	public void setParentescoEmpleado(String parentescoEmpleado) {
		this.parentescoEmpleado = parentescoEmpleado;
	}

	public int getNumAcompañantes() {
		return numAcompañantes;
	}

	public void setNumAcompañantes(int numAcompañantes) {
		this.numAcompañantes = numAcompañantes;
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
	
}
