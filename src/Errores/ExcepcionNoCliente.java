package Errores;

import javafx.scene.control.TextField;
import uiMain.BuscarCliente;

/*EXCEPCIÓN SUGERIDA. 
 * Componentes: Atributo campo, constructor, método getMessage para llamar mensaje que aparecerá en el cuadro de diálogo cuando suceda este
 * tipo de excepción.
 * Funcionalidades: Este tipo de excepción es lanzada cuando la cédula ingresada por el usuario no está registrada en la
 * base de datos del hotel y es tratada en las funcionalidades; tomar habitación, cancelar reserva, dar salida a un cliente,
 * elegir menú o atracciones.*/

public class ExcepcionNoCliente extends ErrorAplicacion {
	private static final long serialVersionUID = 1L;
	
	TextField campo = new TextField();
	public ExcepcionNoCliente(TextField campo) {
		super();
		this.campo = campo;
	}
	@Override
	public String getMessage() {
		return  super.getMessage()+"cliente no registrado en la base de datos";
	}
	
}
