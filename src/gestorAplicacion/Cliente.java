package gestorAplicacion;
import gestorAplicacion.Funcionamiento.*;
import gestorAplicacion.Personal.*;
import uiMain.Recepcion;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private long id;
	private LocalDate fecha_entrada;
	private LocalDate fecha_salida;
	private long idFamiliar;
	private int numAcompanantes;
	private boolean reserva;
	public int cuentaFinal;
	public int saldo;
	public Habitacion habitacion;
	public Hotel hotel;
	public Servicio servicio;
	
	
	public static DateTimeFormatter convertidor = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Cliente(String nombre,long id,String fecha_entrada,String fecha_salida, int numAcompanantes,int saldo, long idFamiliar) {
		this.nombre = nombre;
		this.id = id;
		LocalDate fecha_entrar = LocalDate.parse(fecha_entrada,convertidor);
		this.fecha_entrada= fecha_entrar;
		LocalDate fecha_salir = LocalDate.parse(fecha_salida,convertidor);
		this.fecha_salida= fecha_salir;
		this.numAcompanantes = numAcompanantes;
		this.saldo = saldo;
		this.idFamiliar = idFamiliar;
		Recepcion.hotel.getClientes().add(this);
		
	}
	

	public Cliente(String nombre,long id,String fecha_entrada,String fecha_salida, int numAcompanantes ,int saldo) {
		this.nombre = nombre;
		this.id = id;
		LocalDate fecha_entrar = LocalDate.parse(fecha_entrada,convertidor);
		this.fecha_entrada= fecha_entrar;
		LocalDate fecha_salir = LocalDate.parse(fecha_salida,convertidor);
		this.fecha_salida= fecha_salir;
		this.numAcompanantes = numAcompanantes;
		this.saldo = saldo;
		Recepcion.hotel.getClientes().add(this);
	}

	
	
	//Setter y getters
    
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

	public String getFecha_entrada() {
		return fecha_entrada.toString();
	}

    
	public void setFecha_entrada(String fecha_entrada) {
		LocalDate fecha_entrar = LocalDate.parse(fecha_entrada,convertidor);
		this.fecha_entrada= fecha_entrar;
		}


	public String getFecha_salida() {
		return fecha_salida.toString();
	}


	public void setFecha_salida(String fecha_salida) {
		LocalDate fecha_salir = LocalDate.parse(fecha_salida,convertidor);
		this.fecha_salida= fecha_salir;
	}

	public int getNumAcompanantes() {
		return numAcompanantes;
	}

	public void setNumAcompañantes(int numAcompañantes) {
		this.numAcompanantes = numAcompañantes;
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
	
	/*public void pagarDeuda() {
		saldo-cuentafinal
	}*/
	
}
