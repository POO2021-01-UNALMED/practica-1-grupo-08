package gestorAplicacion.Personal;
import gestorAplicacion.Funcionamiento.*;
public class Empleado {
	private String nombre;
	private long id;
	private String cargo;
	private int salario;
	public HorasExtras horasextras;
	Hotel hotel;
	int cantidadTipoHorasExtras[] = new int[4]; 
    
	//Constructores
	public Empleado(String nombre,long id, String cargo,HorasExtras horasextras) {
		this.nombre=nombre;
		this.id=id;
		this.cargo=cargo;
		this.horasextras=horasextras;
	}
	public Empleado(String nombre,long id, String cargo) {
		this.nombre=nombre;
		this.id=id;
		this.cargo=cargo;
	}
	public Empleado() {}
	//M�todos
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
	
	public void pagoHorasExtras() {}
	
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
