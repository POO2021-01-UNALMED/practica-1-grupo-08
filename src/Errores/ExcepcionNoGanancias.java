package Errores;

public class ExcepcionNoGanancias extends ErrorAplicacion{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return  super.getMessage()+ " el hotel no ha registrado ganancias hasta el momento";
	}

}
