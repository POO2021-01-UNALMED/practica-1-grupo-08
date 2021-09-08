package Errores;


/*Componentes: Atributo error; permite identificar el tipo de error por el cual se lanzó esta excepción, 
 * método getMessage; para llamar mensaje que aparecerá en el cuadro de diálogo cuando suceda este
 * tipo de excepción.
 * Funcionalidades: Este tipo de excepción controla las fechas ingresadas por el usuario, es lanzada cuando por dos tipos de 
 * errores: 
 * 	1. La fecha en que sale el cliente del hotel es después a la fecha en la que desea reservar.
 *  2. La fecha en que finaliza la reserva es antes a la fecha que inicia la misma.
 * Esta excepción es lanzada en la clase FielPane/ fechas() y tratada en clase FieldPane$oyenteConfirmar/handle()*/

public class ExcepcionFechas extends ErrorAplicacion {
	private static final long serialVersionUID = 1L;
	String error;
	
	public ExcepcionFechas(String error) {
		this.error = error;
	}
	
	@Override
	public String getMessage() {
		return  super.getMessage()+ "Fechas ingresadas inválidas.";
	}
	
	public String getError() {
		return error;
	}

}
