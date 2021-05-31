package gestorAplicacion;
/* Autores: Ver�nica Seguro Varela
 * Componentes: Atributos
 * Finalidad: Establecer atributos obligatorios que tienen en com�n las personas
 * que hacen parte del hotel, ya sea los empleados o los clientes.
 * */
public interface Persona {
	
	//Atributos
	String getNombre();
	long getId();
	String toString();
	void setNombre(String nombre);
	void setId(long id);
}
