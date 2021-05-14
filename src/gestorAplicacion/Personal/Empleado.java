package gestorAplicacion.Personal;

import gestorAplicacion.Persona;
import gestorAplicacion.Funcionamiento.*;
import uiMain.Recepcion;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Empleado implements Persona, Serializable {

	private String nombre;
    private long id;
	private String cargo;
	private int salario;
	private HorasExtras horasextras;
    private int cantidadHoras;

	// Constructores
	public Empleado(String nombre, long id, String cargo, HorasExtras horasextras, int cantidadHoras) {
	this(nombre,id,cargo.toLowerCase());
	this.horasextras = horasextras;
	this.cantidadHoras = cantidadHoras;
	this.asignarSalario();
	this.pagoHorasExtras();
}
	public Empleado(String nombre, long id, String cargo) {
		this.nombre = nombre;
		this.id = id;
		this.cargo = cargo.toLowerCase();
		this.asignarSalario();
		Recepcion.getHotel().getEmpleados().add(this);
	}
	// Métodos
	abstract void asignarSalario(); 

	public void pagoHorasExtras() {
		if (horasextras.getPrecioHora() == 4731) {
			salario = salario + (4731 * (cantidadHoras));
		} else if (horasextras.getPrecioHora() == 6624) {
			salario = salario + 6624 * (cantidadHoras);
		} else if (horasextras.getPrecioHora() == 7570) {
			salario = salario + 7570 * (cantidadHoras);
		} else if (horasextras.getPrecioHora() == 9463) {
			salario = salario + 9463 * (cantidadHoras);
		}
	}
	// Getters y Setters
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public HorasExtras getHorasextras() {
		return horasextras;
	}
	public void setHorasextras(HorasExtras horasextras) {
		this.horasextras = horasextras;
	}
	public int getCantidadHoras() {
		return cantidadHoras;
	}
	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}	
	
}
