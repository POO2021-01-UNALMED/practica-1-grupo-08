package Errores;

/*Componentes: método getMessage para llamar mensaje que aparecerá en el cuadro de diálogo cuando suceda este
 * tipo de excepción.
 * Funcionalidad: Esta excepción
 * */
public class ExcepcionFormato extends ErrorAplicacion {
	@Override
	public String getMessage() {
		return  super.getMessage()+ "Formato inválido.";
	}
}
