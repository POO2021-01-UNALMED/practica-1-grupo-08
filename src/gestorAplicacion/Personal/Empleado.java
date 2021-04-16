package gestorAplicacion.Personal;

public class Empleado {
	private String nombre;
	private long id;
	private String cargo;
	private int salario;
	public HorasExtras horasextras;
	//Hotel hotel;??
	int cantidadTipoHorasExtras[] = new int[4]; 
    //El empleado diga su salario o se lo asignamos?
	public Empleado(String nombre,long id, String cargo,HorasExtras horasextras) {
		this.nombre=nombre;
	}
}
