package gestorAplicacion;
import gestorAplicacion.Funcionamiento.*;
import gestorAplicacion.Personal.*;
import java.util.ArrayList;
import java.util.Date;

public class Cliente {
	public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private String nombre;
	private long id;
	private Date fecha_entrada;
	private Date fecha_salida;
	private boolean parentescoEmpleado;
	private long idFamiliar;
	private int numAcompanantes;
	private boolean reserva;
	public int cuentaFinal;
	public int saldo;
	public Habitacion habitacion;
	public Hotel hotel;
	public Servicio servicio;
	
	
	public Cliente(String nombre,long id,Date fecha_entrada,Date fecha_salida ,int saldo, long idFamiliar) {
		this.nombre = nombre;
		this.id = id;
		this.fecha_entrada= fecha_entrada;
		this.fecha_salida= fecha_salida;
		this.saldo = saldo;
		this.idFamiliar = idFamiliar;
		this.parentescoEmpleado = true;
		clientes.add(this);
		
	}
	
	public Cliente(String nombre,long id,Date fecha_entrada,Date fecha_salida ,int saldo) {
		this.nombre = nombre;
		this.id = id;
		this.fecha_entrada= fecha_entrada;
		this.fecha_salida= fecha_salida;
		this.saldo = saldo;
		clientes.add(this);
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

	public Date getFecha_entrada() {
		return fecha_entrada;
	}

    
	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}


	public Date getFecha_salida() {
		return fecha_salida;
	}


	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}


	public void setParentescoEmpleado(boolean parentescoEmpleado) {
		this.parentescoEmpleado = parentescoEmpleado;
	}
	
	public boolean isParentescoEmpleado() {
		return parentescoEmpleado;
	}

	public int getNumAcompanantes() {
		return numAcompanantes;
	}

	public void setNumAcompaņantes(int numAcompaņantes) {
		this.numAcompanantes = numAcompaņantes;
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
	
}
