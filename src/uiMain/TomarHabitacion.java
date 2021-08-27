package uiMain;

import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;

public class TomarHabitacion{
	Label titulo = new Label("Tomar una habitación.");
	Label descripcion = new Label("Para que le sea asignada una habitación por favor ingrese su número de cédula.");
	Label criterio = new Label("Cédula:");
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
				sinCliente.setContentText("Por favor ingrese una nueva cédula.");
				sinCliente.show();
				
				//Cambiar mensaje botón - Hacer oyente de boton aceptar -> aquí va campo.clear()
			}
			
		}
	}
	
	
	}	

}
