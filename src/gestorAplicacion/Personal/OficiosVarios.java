package gestorAplicacion.Personal;

public class OficiosVarios extends Empleado {
 
	public OficiosVarios(String nombre, long id, String cargo, HorasExtras horasextras, int cantidadHoras) {
		super(nombre,id,cargo,horasextras,cantidadHoras);
	}

	public OficiosVarios(String nombre, long id, String cargo) {
		super(nombre,id,cargo);
		
	}

	// M�todos
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
