package gestorAplicacion.Personal;
import gestorAplicacion.Funcionamiento.*;
import uiMain.Recepcion;

import java.util.ArrayList;

public class Empleado {
	
	private String nombre;
	private long id;
	private String cargo;
	private int salario;	
	public HorasExtras horasextras;
	private int cantidadHoras;
    
	//Constructores
	public Empleado(String nombre,long id, String cargo, HorasExtras horasextras,int cantidadHoras) {
		this.nombre=nombre;
		this.id=id;
		this.cargo=cargo;
		this.horasextras=horasextras;
		this.cantidadHoras=cantidadHoras;
		asignarSalario();
		pagoHorasExtras();
		Recepcion.hotel.getEmpleados().add(this);
	}
	public Empleado(String nombre,long id, String cargo) {
		this.nombre=nombre;
		this.id=id;          
		this.cargo=cargo;
		asignarSalario();
		Recepcion.hotel.getEmpleados().add(this);
		
	}
	public Empleado() {}
	//Métodos
	public void asignarSalario() {
		if(nombre.equals("Chef")){
			salario=3000000;
		}
		if(nombre.equals("Recepcionista")){
			salario=1300000;
		}
		if ((nombre.equals("Vigilante"))||(nombre.equals("Bartender"))){
			salario=1200000;
		}
	}
	
	public void pagoHorasExtras() {
		if(horasextras.getPrecioHora()==4731) {
			salario = salario+4731*(cantidadHoras);
		}else if(horasextras.getPrecioHora()==6624) {
			salario = salario+6624*(cantidadHoras);
		}else if(horasextras.getPrecioHora()==7570) {
			salario = salario+7570*(cantidadHoras);
		}else if(horasextras.getPrecioHora()==9463) {
			salario = salario+9463*(cantidadHoras);
	    }
    }
	//Getters y Setters
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
	
	
	
	
}
