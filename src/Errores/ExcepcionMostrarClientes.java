package Errores;

public class ExcepcionMostrarClientes extends ErrorAplicacion{
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return  super.getMessage()+"En el momento no se encuentran clientes hospedados en el hotel.";
	}
}
