package Errores;

/*EXCEPCIÓN SUGERIDA.
 * Componentes: método getMessage para llamar mensaje que aparecerá en el cuadro de diálogo cuando suceda este
 * tipo de excepción.
 * Funcionalidad: Esta excepción se da cuando falto un campo por llenar del formulario Reserva, por tanto, es lanzada en 
 * FieldPane/nulos() y tratada en FieldPane$oyenteCOnfirmar. Adicional del mensaje definido para la excepción, el cuadro de 
 * dialogo arroja qué campos faltan por completar.*/



public class ExcepcionNulos extends ErrorAplicacion{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return  super.getMessage()+"Por favor, llena todos los campos.";
	}

}
