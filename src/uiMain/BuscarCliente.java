package uiMain;

import java.util.Optional;
import Errores.ExcepcionNoCliente;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
//Clase BuscarCliente
/* Funcionalidad: Esta clase permite hacer la b�squeda de un cliente luego de que en cada funcionalidad se le solicite ingresar
 * una c�dula, si el cliente no es encontrado mandar� excepci�n de ExcepcionNoCliente la cual informa al usuario
 * que el cliente no se encuentra registrado. Si por el contrario el cliente si se encuentra registrado entonces 
 * ser� enviado a la clase donde ha sido llamado a trav�s el m�todo getBuscar().
 * */
public class BuscarCliente  {
	private TextField campo;
	Cliente clienteNuevo;
	public BuscarCliente(TextField c) {
		campo = c;
	}
	public void handle() throws ExcepcionNoCliente{
		Long cedula = null;
		try {
			cedula = Long.parseLong(campo.getText());
		}catch(NumberFormatException e) {
			Alert sinCliente = new Alert(AlertType.WARNING);
			sinCliente.setTitle("Advertencia.");
			sinCliente.setHeaderText("Por favor, ingrese su c�dula correctamente.");
			Optional<ButtonType> result = sinCliente.showAndWait();
			if (!result.isPresent()) {
			}
			else if (result.get() == ButtonType.OK) {
				campo.clear();
			}
			return;
		}
		
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
			throw new ExcepcionNoCliente(campo);
		}
	
}
	public Cliente getBuscarCliente() {
		return clienteNuevo;
	}
}