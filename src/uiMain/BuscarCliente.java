package uiMain;

import java.util.Optional;

import Errores.Excepcion1;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class BuscarCliente  {
	private TextField campo;
	Cliente clienteNuevo;
	public BuscarCliente(TextField c) {
		campo = c;
	}
	public void handle() throws Excepcion1{
		Long cedula = Long.parseLong(campo.getText());
		boolean confirmacion = false;
		 clienteNuevo = null;

		for (Cliente i : Hotel.getClientes()) {
			if (cedula == i.getId()) {
				clienteNuevo = i;
				confirmacion = true;
				break;
			}
		}
		if (confirmacion == false) {
			throw new Excepcion1(campo);
		}
	
}
	public Cliente getBuscarCliente() {
		return clienteNuevo;
	}
}