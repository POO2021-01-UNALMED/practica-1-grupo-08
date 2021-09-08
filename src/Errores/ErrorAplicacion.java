package Errores;

/*Componentes: atributo serializable, constructor.
 * Finalidad: Es la clase padre de las clases que manejan las excepciones del sistema. Se encarga de enviar
 * la primer parte del mensaje cuando ocurre alguna excepcion, por ejemplo, cuando no se ha completado todos los campos pedidos
 * en el formulario.*/

public class ErrorAplicacion extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ErrorAplicacion() {
		super("Manejo de errores de la Aplicación: ");
	}	
}
