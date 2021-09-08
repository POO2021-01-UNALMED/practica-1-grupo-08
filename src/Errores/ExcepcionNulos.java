package Errores;

/*EXCEPCI�N SUGERIDA.
 * Componentes: m�todo getMessage para llamar mensaje que aparecer� en el cuadro de di�logo cuando suceda este
 * tipo de excepci�n.
 * Funcionalidad: Esta excepci�n se da cuando falto un campo por llenar del formulario Reserva, por tanto, es lanzada en 
 * FieldPane/nulos() y tratada en FieldPane$oyenteCOnfirmar. Adicional del mensaje definido para la excepci�n, el cuadro de 
 * dialogo arroja qu� campos faltan por completar.*/



public class ExcepcionNulos extends ErrorAplicacion{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return  super.getMessage()+"Por favor, llena todos los campos.";
	}

}
