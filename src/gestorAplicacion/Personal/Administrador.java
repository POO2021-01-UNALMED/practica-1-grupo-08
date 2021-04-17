package gestorAplicacion.Personal;
import java.util.Iterator;
import java.util.ArrayList;

public class Administrador extends Empleado{
	
	public Administrador(String nombre,long id, String cargo, HorasExtras horasextras) {
		super(nombre,id,cargo,horasextras);
		super.asignarSalario();
		super.pagoHorasExtras();
	}
	public Administrador(String nombre,long id, String cargo) {
		super(nombre,id,cargo);
	}
	
	@Override
	public void asignarSalario() {
		super.setSalario(3500000);
	}
	public void pagarSalario() {
		int totalSalario=0;
		for (int i =0; i<empleados.size();i++) {
			empleados.get(i).getSalario();
			totalSalario=totalSalario+empleados.get(i).getSalario();
		}
	}
}
