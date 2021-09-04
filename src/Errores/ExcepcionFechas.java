package Errores;

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
