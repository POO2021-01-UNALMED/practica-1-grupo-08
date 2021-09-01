package uiMain;

import java.util.Optional;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class TomarHabitacion {
	//Label titulo = new Label("Tomar una habitaci�n.");
	//Label descripcion = new Label("Para que le sea asignada una habitaci�n por favor ingrese su n�mero de c�dula.");
	Label criterio = new Label("C�dula: ");
	TextField campo = new TextField();
	Button enviar = new Button("Enviar");
	GridPane panel1 = new GridPane();
	
	public TomarHabitacion() {
		buscarCliente oyente = new buscarCliente();
		enviar.setOnAction(oyente);
		//panel1.addRow(0, titulo);
		//panel1.addRow(1, descripcion);
		panel1.addRow(0, criterio, campo, enviar);
	}

	class buscarCliente implements EventHandler<ActionEvent> {
		public void handle(ActionEvent evento) {
			Long cedula = Long.parseLong(campo.getText());
			boolean confirmacion = false;
			Cliente clienteNuevo = null;

			for (Cliente i : Hotel.getClientes()) {
				if (cedula == i.getId()) {
					clienteNuevo = i;
					confirmacion = true;
					break;
				}
			}

			if (confirmacion == false) {
				Alert sinCliente = new Alert(AlertType.ERROR);
				sinCliente.setTitle("Error");
				sinCliente.setHeaderText("Cliente no encontrado.");
				sinCliente.setContentText("Por favor ingrese una nueva c�dula.");
				Optional<ButtonType> result = sinCliente.showAndWait();
				if (!result.isPresent()) {}
				else if (result.get() == ButtonType.OK) {
					campo.clear();
				}
			} else if (clienteNuevo.getHabitacion() != null) {
				Alert siHabitacion = new Alert(AlertType.INFORMATION);
				siHabitacion.setTitle("Informaci�n");
				siHabitacion.setHeaderText("Usted ya tiene una habitaci�n asignada.");
				siHabitacion.setContentText("Ya puedes acceder a nuestros servicios,dir�gete a la barra superior.");
				Optional<ButtonType> resulta = siHabitacion.showAndWait();
				if (!resulta.isPresent()) {}
				if (resulta.get() == ButtonType.OK) {
					campo.clear();
				}

			} else if (confirmacion == true) {
				Hotel.asignarHabitacion(clienteNuevo);
				if (clienteNuevo.getHabitacion() != null) {
					Alert siHabitacion = new Alert(AlertType.INFORMATION);
					siHabitacion.setTitle("Informaci�n");
					siHabitacion.setHeaderText("Habitaci�n asignada con �xito.");
					siHabitacion.setContentText("La habitaci�n que le ha sido asignada es: "
							+ clienteNuevo.getHabitacion().getNumhabitacion());
					Optional<ButtonType> resultad = siHabitacion.showAndWait();
					if (!resultad.isPresent()) {}
					else if (resultad.get() == ButtonType.OK) {
						campo.clear();
					}
				} else if (clienteNuevo.getHabitacion() == null) {
					Alert noHabitacion = new Alert(AlertType.CONFIRMATION);
					noHabitacion.setTitle("Confirmaci�n.");
					noHabitacion.setHeaderText("No se encuentran habitaciones disponibles.");
					noHabitacion.setContentText("�Desea reservar una habitaci�n?");
					ButtonType si = new ButtonType("S�", ButtonBar.ButtonData.YES);
					ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
					noHabitacion.getButtonTypes().setAll(si, no);
					Optional<ButtonType> resultado = noHabitacion.showAndWait();
					if (!resultado.isPresent()) {}
					else if (resultado.get().equals(noHabitacion.getButtonTypes().get(1))) {
						campo.clear();
						Alert adios = new Alert(AlertType.INFORMATION);
						adios.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("./Imagenes/triste.png"),50,50,false,false)));
						adios.setHeaderText("No se encuentran habitaciones disponibles.");
						adios.setContentText("�Gracias por elegirnos, esperamos tener disponibilidad la pr�xima ocasi�n!");
						adios.show();
					} else if (resultado.get().equals(noHabitacion.getButtonTypes().get(0))) {
						//Formulario Reserva
						VBox formulario = new VBox();
						Label titulo = new Label("Formulario nueva reserva.");
						Label descripcion = new Label("Por favor ingrese la siguiente informaci�n para realizar la reserva.");
						
						String[] criterios = {"Cedula","Nombre","Fecha de entrada","Fecha de salida","N�mero de acompa�antes"};
						String[] valores = {String.valueOf(clienteNuevo.getId()),clienteNuevo.getNombre(),null,null,null};
						Boolean[] habilitados = {false,false,true,true,true};
						FieldPane campos = new FieldPane("Criterio",criterios,"Valor",valores, habilitados );
						
						formulario.getChildren().addAll(titulo,descripcion,campos.getFieldPane());
						Scene tomarHabitacion = new Scene(formulario,800,550);
						GUI.ventana.setScene(tomarHabitacion);
						
					}
					/*
					 * if (respuesta.equals("si")) { hacerReserva(clientenuevo); return; } else if
					 * (respuesta.equals("no")) { System.out.
					 * println("�Gracias por elegirnos, esperamos tener disponibilidad la pr�xima ocasi�n!"
					 * ); }
					 */
				}
			}

		}
	}

	public GridPane getTomarHabitacion() {
		return panel1;
	}

}
