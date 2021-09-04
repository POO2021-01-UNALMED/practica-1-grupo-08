package Errores;

public class ExcepcionFormato extends ErrorAplicacion {
	@Override
	public String getMessage() {
		return  super.getMessage()+ "Formato inválido.";
	}
}
