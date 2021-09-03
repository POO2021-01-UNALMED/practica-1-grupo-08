package Errores;

import javafx.scene.control.TextField;
import uiMain.BuscarCliente;

public class Excepcion1 extends ErrorAplicacion {
	private static final long serialVersionUID = 1L;
	
	TextField campo = new TextField();
	public Excepcion1(TextField campo) {
		super();
		this.campo = campo;
	}
	
/*	public String getMensaje() {
		return super.getMessage()+" cliente no registrado en la base de datos";	}*/
}
