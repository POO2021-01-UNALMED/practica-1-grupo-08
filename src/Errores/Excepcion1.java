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
	try {
		BuscarCliente c1 = new BuscarCliente();
	}
	
}
