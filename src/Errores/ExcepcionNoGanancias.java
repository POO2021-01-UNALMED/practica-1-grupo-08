package Errores;
/*Componentes: método getMessage para llamar mensaje que aparecerá en el cuadro de diálogo cuando suceda este
 * tipo de excepción.
 * Funcionalidad: Esta excepción será lanzada cuando el administrador quiera observar las ganancias del hotel, pero estas sean
 * negativas o nulas. Especificamente, en Hotel/gananciasNetas() y es tratada Funcionalidades$Eventos*/
public class ExcepcionNoGanancias extends ErrorAplicacion{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return  super.getMessage()+ " el hotel no ha registrado ganancias hasta el momento";
	}

}
