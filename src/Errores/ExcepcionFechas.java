package Errores;


/*Componentes: Atributo error; permite identificar el tipo de error por el cual se lanz� esta excepci�n, 
 * m�todo getMessage; para llamar mensaje que aparecer� en el cuadro de di�logo cuando suceda este
 * tipo de excepci�n.
 * Funcionalidades: Este tipo de excepci�n controla las fechas ingresadas por el usuario, es lanzada cuando por dos tipos de 
 * errores: 
 * 	1. La fecha en que sale el cliente del hotel es despu�s a la fecha en la que desea reservar.
 *  2. La fecha en que finaliza la reserva es antes a la fecha que inicia la misma.
 * Esta excepci�n es lanzada en la clase FielPane/ fechas() y tratada en clase FieldPane$oyenteConfirmar/handle()*/

public class ExcepcionFechas extends ErrorAplicacion {
	private static final long serialVersionUID = 1L;
	String error;
	
	public ExcepcionFechas(String error) {
		this.error = error;
	}
	
	@Override
	public String getMessage() {
		return  super.getMessage()+ "Fechas ingresadas inv�lidas.";
	}
	
	public String getError() {
		return error;
	}

}
