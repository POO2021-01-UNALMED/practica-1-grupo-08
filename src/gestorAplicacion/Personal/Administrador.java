package gestorAplicacion.Personal;

public class Administrador extends Empleado{
	public Administrador(String nombre,long id, String cargo, HorasExtras horasextras) {
		super(nombre,id,cargo,horasextras);
		super.asignarSalario();
		super.pagoHorasExtras();
	}
	public Administrador(String nombre,long id, String cargo) {
		super(nombre,id,cargo);
	}
	
	public void pagarSalario() {}
	
	@Override
	public void asignarSalario() {
		super.setSalario(3500000);
	}
}
