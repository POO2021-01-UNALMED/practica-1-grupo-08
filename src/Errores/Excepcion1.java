package Errores;

import javafx.scene.control.TextField;
import uiMain.BuscarCliente;

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
