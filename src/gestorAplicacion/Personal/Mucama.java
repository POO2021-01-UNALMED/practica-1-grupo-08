package gestorAplicacion.Personal;
import gestorAplicacion.Funcionamiento.*;

public class Mucama extends Empleado {
	public Hotel hotel;
	int numHabitacion;

	public Mucama(String nombre,long id, String cargo, HorasExtras horasextras) {
		super(nombre,id,cargo,horasextras);
		super.asignarSalario();
		super.pagoHorasExtras();
	}
	public Mucama(String nombre,long id, String cargo) {
		super(nombre,id,cargo);
	}
	
	@Override
	public void asignarSalario() {
		super.setSalario(9150000);
	}
	
	public void limpiarHabitacion(int numHabitacion) {
	//crear atributo que me de la capacidad de habitacion

	}    
}
