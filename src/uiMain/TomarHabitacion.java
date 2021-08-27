package uiMain;

import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;

public class TomarHabitacion{
	Label titulo = new Label("Tomar una habitaci�n.");
	Label descripcion = new Label("Para que le sea asignada una habitaci�n por favor ingrese su n�mero de c�dula.");
	Label criterio = new Label("C�dula:");
	TextField campo = new TextField();
	Button enviar = new Button("Enviar");
	
	
	public TomarHabitacion() {
		GridPane panel1 = new GridPane();
		panel1.addRow(0, titulo);
		panel1.addRow(1, descripcion);
		panel1.addRow(2, criterio,campo,enviar);
	}
	
	class buscarCliente implements EventHandler<ActionEvent>{
		public void handle(ActionEvent evento) {
			Long cedula = Long.parseLong(campo.getText());
			boolean confirmacion = false;	
			
			for (Cliente i : Hotel.getClientes()) {
				if (cedula == i.getId()) {
					confirmacion = true;
					break;
			}
			
			if(confirmacion == false) {
				campo.clear();
				Alert sinCliente = new Alert(AlertType.WARNING);
				sinCliente.setTitle("Error");
				sinCliente.setHeaderText("Cliente no encontrado.");
				sinCliente.setContentText("Por favor ingrese una nueva c�dula.");
				sinCliente.show();
				
				//Cambiar mensaje bot�n - Hacer oyente de boton aceptar -> aqu� va campo.clear()
			}
			
		}
	}
	
	
	}	

}
