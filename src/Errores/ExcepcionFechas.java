package Errores;

public class ExcepcionFechas extends ErrorAplicacion {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return  super.getMessage()+ "Fechas ingresadas inválidas.";
	}
	

}
