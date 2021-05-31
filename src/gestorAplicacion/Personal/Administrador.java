package gestorAplicacion.Personal;

import java.io.Serializable;

import uiMain.Recepcion;

public class Administrador extends Empleado implements Serializable {

	/* Autores: Ver�nica Seguro Varela.
	 * Componentes: Constructor, m�todos asignarSalario() y pagarSalario()
	 * Finalidad: El hotel s�lo tendr� un administrador el cual ser� el encargado
	 * de llevar la contabilidad  y para esto deber� tener el valor final
	 * del salario de todos los empleados (incluido el pago de las horas extras).
	 * El administrador deber� conocer los ingresos del hotel y con esto pagarles
	 * a sus empleados, dicha acci�n se realiza en el m�todo gananciaNeta() de la 
	 * clase Hotel. 
	 */
	
// El siguiente atributo es necesario para la serizalizaci�n de las instancias de esta clase.
	private static final long serialVersionUID = 1L;
    
	//CONSTRUCTOR 
	/*Al ser el administrador del hotel no trabajar� horas extras y por lo tanto
	 * s�lo se usar� el constructor 2 de su clase padre Empleado.
	 */
	public Administrador(String nombre, long id) {
		super(nombre, id, "Administrador");
	}

	//M�TODOS
	
	/* Se le asignar� al administrador un salario fijo de $3.500.000
	 * */
	@Override
	public void asignarSalario() {
		super.setSalario(3500000);
	}

	/* Este m�todo recorre la lista de empleados de la clase Hotel obteniendo de 
	 * cada empleado el valor de su salario con el fin de pagarles. Adem�s
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
