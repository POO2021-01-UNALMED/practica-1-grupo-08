package gestorAplicacion.Personal;

import java.io.Serializable;

import uiMain.Recepcion;

public class Administrador extends Empleado implements Serializable {

	/* Autores: Verónica Seguro Varela.
	 * Componentes: Constructor, métodos asignarSalario() y pagarSalario()
	 * Finalidad: El hotel sólo tendrá un administrador el cual será el encargado
	 * de llevar la contabilidad  y para esto deberá tener el valor final
	 * del salario de todos los empleados (incluido el pago de las horas extras).
	 * El administrador deberá conocer los ingresos del hotel y con esto pagarles
	 * a sus empleados, dicha acción se realiza en el método gananciaNeta() de la 
	 * clase Hotel. 
	 */
	
// El siguiente atributo es necesario para la serizalización de las instancias de esta clase.
	private static final long serialVersionUID = 1L;
    
	//CONSTRUCTOR 
	/*Al ser el administrador del hotel no trabajará horas extras y por lo tanto
	 * sólo se usará el constructor 2 de su clase padre Empleado.
	 */
	public Administrador(String nombre, long id) {
		super(nombre, id, "Administrador");
	}

	//MÉTODOS
	
	/* Se le asignará al administrador un salario fijo de $3.500.000
	 * */
	@Override
	public void asignarSalario() {
		super.setSalario(3500000);
	}

	/* Este método recorre la lista de empleados de la clase Hotel obteniendo de 
	 * cada empleado el valor de su salario con el fin de pagarles. Además
	 * se necesita este dato para conocer la ganancia neta del hotel.
	 * 
	 * */
	public int pagarSalario() {
		int totalSalario = 0;
		for (int i = 0; i < Recepcion.getHotel().getEmpleados().size(); i++) {
			totalSalario += Recepcion.getHotel().getEmpleados().get(i).getSalario();
		}
		return totalSalario;
	}
	
	}
