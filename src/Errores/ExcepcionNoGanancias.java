package Errores;
/*Componentes: m�todo getMessage para llamar mensaje que aparecer� en el cuadro de di�logo cuando suceda este
 * tipo de excepci�n.
 * Funcionalidad: Esta excepci�n ser� lanzada cuando el administrador quiera observar las ganancias del hotel, pero estas sean
 * negativas o nulas. Especificamente, en Hotel/gananciasNetas() y es tratada Funcionalidades$Eventos*/
public class ExcepcionNoGanancias extends ErrorAplicacion{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return  super.getMessage()+ " el hotel no ha registrado ganancias hasta el momento";
	}

}
