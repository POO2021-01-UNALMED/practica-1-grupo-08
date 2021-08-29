package uiMain;

import java.util.Optional;

import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class BuscarCliente {
	private TextField campo;
	Cliente clienteNuevo;
	public BuscarCliente(TextField c) {
		campo = c;
	}
	public void handle() {
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
			System.out.println("Entra");
			Alert sinCliente = new Alert(AlertType.ERROR);
			sinCliente.setTitle("Error");
			sinCliente.setHeaderText("Cliente no encontrado.");
			sinCliente.setContentText("Por favor ingrese una nueva cédula.");
			Optional<ButtonType> result = sinCliente.showAndWait();

			if (result.get() == ButtonType.OK) {
				campo.clear();
			}
		}
	
}
	public Cliente getBuscarCliente() {
		return clienteNuevo;
	}
}