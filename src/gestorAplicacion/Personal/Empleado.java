package gestorAplicacion.Personal;

import gestorAplicacion.Persona;
import gestorAplicacion.Funcionamiento.*;
import uiMain.Recepcion;

import java.io.Serializable;
import java.util.ArrayList;
/*Autores: Verónica Seguro Varela. 
 * Componentes: Atributos,constructores, un método abstracto, métodos gets y sets,
 * métodos para el pago de salario de los distintos empleados.   
 * Finalidad: Clase abstracta en donde se busca que los tipos de 
 * empleados hereden la mayoría de estos métodos y atributos, esta superclase busca 
 * crear empleados que especifiquen si han pagado horas extras y la cantidad horas 
 * pagadas para modificar su salario, dicha información será utilizada para ver 
 * la ganancia neta del Hotel. 
 * Cada empleado que sea creado se agregará a la lista de empleados de la clase
 * Hotel  
 * */
public abstract class Empleado implements Persona, Serializable {
    //ATRIBUTOS
	private static final long serialVersionUID = 1L;
    
	private String nombre;
    private long id;
	private String cargo;
	private int salario;
	private HorasExtras horasextras; /*Atributo de la clase numérica HorasExtras 
	que será utilizado en caso de que el empleado haya trabajado por fuera de su
	jornada laboral, pueden ser horas diurnas, nocturnas, diurnas dominicales y 
	nocturnas dominicales, cada tipo de hora extra tiene un valor diferente. */
    private int cantidadHoras;

	// CONSTRUCTOR 1
    /* Este constructor será usado en el caso de que el empleados tenga horas 
     * extras por cobrar,deberá especificar el tipo de hora extra pagada y 
     * la cantidad horas extras trabajadas esto con la finalidad de modificar
     * su salario y aumentarlo.
     * 
     * Cabe aclarar que el empleado sólo podrá tener un tipo de hora extra ya sea 
     * diurna, nocturna, diurna dominical o nocturna dominical.
     * */
	public Empleado(String nombre, long id, String cargo, HorasExtras horasextras, int cantidadHoras) {
	this(nombre,id,cargo.toLowerCase()); /* Se usa el método toLowerCase() dado que
	se necesita que el cargo del empleado esté en minúscula para un correcto
	funcionamiento del método asignarSalario() de la clase OficiosVarios.
	 */ 
	this.horasextras = horasextras;
	this.cantidadHoras = cantidadHoras;
	this.asignarSalario();
	this.pagoHorasExtras();
}
	/* CONSTRUCTOR 2
	 * Este será usado en el caso en que el empleado no tenga horas extras que
	 * cobrar y por lo tanto su salario no será modificado.
	 * */
	public Empleado(String nombre, long id, String cargo) {
		this.nombre = nombre;
		this.id = id;
		this.cargo = cargo.toLowerCase();
		this.asignarSalario();
		Recepcion.getHotel().getEmpleados().add(this);
	}
	// MÉTODOS
	
	abstract void asignarSalario(); // Las clases creadas a partir de esta
	//para identificar el tipo de empleado deberán implementar este método.

	/* Este método será el encargado realizar el pago de horas extras y aumentar
	 * dicho pago en el salario de los empleados que en su efecto hayan extendido su
	 * jornada laboral (empleados creados con el constructor 1).
	 * */
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
	/*public void setHorasextras(HorasExtras horasextras) {
		this.horasextras = horasextras;
	}*/
	public int getCantidadHoras() {
		return cantidadHoras;
	}
	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}	
	
}
