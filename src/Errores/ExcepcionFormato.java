package Errores;

/*Componentes: m�todo getMessage para llamar mensaje que aparecer� en el cuadro de di�logo cuando suceda este
 * tipo de excepci�n.
 * Funcionalidad: Esta excepci�n
 * */
public class ExcepcionFormato extends ErrorAplicacion {
	@Override
	public String getMessage() {
		return  super.getMessage()+ "Formato inv�lido.";
	}
}
