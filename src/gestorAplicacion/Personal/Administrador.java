package gestorAplicacion.Personal;



public class Administrador extends Empleado{
	
	public Administrador(String nombre,long id, HorasExtras horasextras) {
		super(nombre,id,"Administrador",horasextras);
		asignarSalario();
		super.pagoHorasExtras();
	}
	public Administrador(String nombre,long id) {
		super(nombre,id,"Administrador");
		asignarSalario();
	}
	
	@Override
	public void asignarSalario() {
		super.setSalario(3500000);
	}
	public int pagarSalario() {
		int totalSalario=0;
		for (int i =0; i<Empleado.getEmpleados().size();i++) {
         totalSalario += Empleado.getEmpleados().get(i).getSalario();
	    }
		return totalSalario += (Mucama.getMucamas().size())*950000 + 3500000;		
}
} 