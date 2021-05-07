package gestorAplicacion.Personal;

import java.io.Serializable;

import uiMain.Recepcion;

public class Administrador extends Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrador(String nombre, long id) {
		super(nombre, id, "Administrador");
	}

	@Override
	public void asignarSalario() {
		super.setSalario(3500000);
	}

	public int pagarSalario() {
		int totalSalario = 0;
		for (int i = 0; i < Recepcion.getHotel().getEmpleados().size(); i++) {
			totalSalario += Recepcion.getHotel().getEmpleados().get(i).getSalario();
		}
		return totalSalario;
	}
	
	}
