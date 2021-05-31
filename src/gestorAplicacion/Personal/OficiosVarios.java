package gestorAplicacion.Personal;

import java.io.Serializable;
/* Autores: Verónica Seguro Varela
 * Componentes: Constructores, método asignarsalario()
 * Finalidad: Crear empleados con diferentes cargos que permitan un correcto
 * funcionamiento del hotel. */
public class OficiosVarios extends Empleado implements Serializable {
 
// El siguiente atributo es necesario para la serizalización de las instancias de esta clase.
	private static final long serialVersionUID = 1L;

	//CONSTRUCTORES 
/* Se usarán los constructores de su clase padre Empleado, el tipo de constructor a usar
	 * dependerá si la empleado tiene horas extras por pagar o no. 
	 * 
	 * El cargo que se debe ingresar debe ser específicamente uno de los siguientes:
	 * chef, recepcionista, vigilante o bartender. 
	 * */
	public OficiosVarios(String nombre, long id, String cargo, HorasExtras horasextras, int cantidadHoras) {
		super(nombre,id,cargo,horasextras,cantidadHoras);
	}

	public OficiosVarios(String nombre, long id, String cargo) {
		super(nombre,id,cargo);
		
	}

	// MÉTODO
	
	/* Este método buscará que tipo de cargo tiene el empleado ya sea chef, 
	 * recepcionista, vigilante o bartender y de acuerdo a esto le asignará el 
	 * salario fijo correspondiente.
	 * */
	public void asignarSalario() {
		if (this.getCargo().equals("chef")) {
			this.setSalario(3000000);
		}
		if (this.getCargo().equals("recepcionista")) {
			this.setSalario(1500000);
		}
		if ((this.getCargo().equals("vigilante")) || (this.getCargo().equals("bartender"))) {
			this.setSalario(1600000);
		}
	}

}
