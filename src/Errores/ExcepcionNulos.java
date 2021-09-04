package Errores;

public class ExcepcionNulos extends ErrorAplicacion{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return  super.getMessage()+"Por favor, llena todos los campos.";
	}

}
