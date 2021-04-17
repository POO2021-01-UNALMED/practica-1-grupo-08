package gestorAplicacion.Personal;

public class Mucama extends Empleado {
	public int num_habitacion;
	public Mucama(String nombre,long id, String cargo,HorasExtras horasextras) {
		super(nombre,id,cargo,horasextras);
		super.setSalario(9150000);
	}
	
}
