package gestorAplicacion.Personal;
import gestorAplicacion.Funcionamiento.*;
import java.util.ArrayList;

public class Empleado {
	protected ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private String nombre;
	private long id;
	private String cargo;
	private int salario;	
	public HorasExtras horasextras;
	Hotel hotel;
	private int horaExtraDiurna;
	private int horaExtraNocturna;
	private int horaExtraDiurnaDom;
	private int horaExtraNocturnaDom;
    
	//Constructores
	public Empleado(String nombre,long id, String cargo, HorasExtras horasextras) {
		this.nombre=nombre;
		this.id=id;
		this.cargo=cargo;
		this.horasextras=horasextras;
		asignarSalario();
		pagoHorasExtras();
	}
	public Empleado(String nombre,long id, String cargo) {
		this.nombre=nombre;
		this.id=id;          
		this.cargo=cargo;
		asignarSalario();
		
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
			salario = salario+4731*(horaExtraDiurna);
		}else if(horasextras.getPrecioHora()==6624) {
			salario = salario+6624*(horaExtraNocturna);
		}else if(horasextras.getPrecioHora()==7570) {
			salario = salario+7570*(horaExtraDiurnaDom);
		}else if(horasextras.getPrecioHora()==9463) {
			salario = salario+9463*(horaExtraNocturnaDom);
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
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
	
}
