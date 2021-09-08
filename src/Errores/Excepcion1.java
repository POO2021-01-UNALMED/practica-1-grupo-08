package Errores;

import javafx.scene.control.TextField;
import uiMain.BuscarCliente;

/*EXCEPCI�N SUGERIDA. 
 * Componentes: Atributo campo, constructor, m�todo getMessage para llamar mensaje que aparecer� en el cuadro de di�logo cuando suceda este
 * tipo de excepci�n.
 * Funcionalidades: Este tipo de excepci�n es lanzada cuando la c�dula ingresada por el usuario no est� registrada en la
 * base de datos del hotel y es tratada en las funcionalidades; tomar habitaci�n, cancelar reserva, dar salida a un cliente,
 * elegir men� o atracciones.*/

public class Excepcion1 extends ErrorAplicacion {
	private static final long serialVersionUID = 1L;
	
	TextField campo = new TextField();
	public Excepcion1(TextField campo) {
		super();
		this.campo = campo;
		//Throwable("cliente no registrado en la base de datos");
	}
	@Override
	public String getMessage() {
		return  super.getMessage()+"cliente no registrado en la base de datos";
	}
	
	
	
	
	
	//Formato
	//Fechas superiores
/*	public String getMensaje() {
		return super.getMessage()+" cliente no registrado en la base de datos";	}*/
}
