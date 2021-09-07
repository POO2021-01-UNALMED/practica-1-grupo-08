package uiMain;

import java.util.Optional;

import Errores.Excepcion1;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class TomarHabitacion {
	Label criterio = new Label("Cédula: ");
	TextField campo = new TextField();
	Button enviar = new Button("Enviar");
	GridPane panel1 = new GridPane();
	
	public TomarHabitacion() {
		evento oyente = new evento(campo);
		enviar.setOnAction(oyente);
		panel1.addRow(0, criterio, campo, enviar);
		panel1.setAlignment(Pos.CENTER);
		GridPane.setMargin(campo, new Insets(20,20,20,20));
		Font tipoletraTex = new Font("Times New Roman", 18);
		criterio.setFont(tipoletraTex);
	}

	class evento implements EventHandler<ActionEvent> {
		TextField campo;
		 
		public evento(TextField c) {
			campo = c; 
		}
		public void handle(ActionEvent evento) {
			BuscarCliente oidor = new BuscarCliente(campo);
			try {				
				oidor.handle();}
			catch(Excepcion1 e){
				Alert sinCliente = new Alert(AlertType.ERROR);
				sinCliente.setTitle("Error");
				sinCliente.setHeaderText("Cliente no encontrado.");
				sinCliente.setContentText(e.getMessage() +" cliente no registrado en la base de datos");
				Optional<ButtonType> result = sinCliente.showAndWait();
				if (!result.isPresent()) {
				}
				else if (result.get() == ButtonType.OK) {
					campo.clear();
			 }
			}
			
			Cliente clienteNuevo = oidor.getBuscarCliente();
			if (clienteNuevo == null){
				return;
			}
			if (clienteNuevo.getHabitacion() != null) {
				Alert siHabitacion = new Alert(AlertType.INFORMATION);
				siHabitacion.setTitle("Información");
				siHabitacion.setHeaderText("Usted ya tiene una habitación asignada.");
				siHabitacion.setContentText("Ya puedes acceder a nuestros servicios,dirígete a la barra superior.");
				Optional<ButtonType> resulta = siHabitacion.showAndWait();
				if (!resulta.isPresent()) {}
				if (resulta.get() == ButtonType.OK) {
					campo.clear();
				}

			} else if (clienteNuevo.getHabitacion() == null) {
				Hotel.asignarHabitacion(clienteNuevo);
				if (clienteNuevo.getHabitacion() != null) {
					Alert siHabitacion = new Alert(AlertType.INFORMATION);
					siHabitacion.setTitle("Información");
					siHabitacion.setHeaderText("Habitación asignada con éxito.");
					siHabitacion.setContentText("La habitación que le ha sido asignada es: "
							+ clienteNuevo.getHabitacion().getNumhabitacion());
					Optional<ButtonType> resultad = siHabitacion.showAndWait();
					if (!resultad.isPresent()) {}
					else if (resultad.get() == ButtonType.OK) {
						campo.clear();
					}
				} else if (clienteNuevo.getHabitacion() == null) {
					Alert noHabitacion = new Alert(AlertType.CONFIRMATION);
					noHabitacion.setTitle("Confirmación.");
					noHabitacion.setHeaderText("No se encuentran habitaciones disponibles.");
					noHabitacion.setContentText("¿Desea reservar una habitación?");
					ButtonType si = new ButtonType("Sí", ButtonBar.ButtonData.YES);
					ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
					noHabitacion.getButtonTypes().setAll(si, no);
					Optional<ButtonType> resultado = noHabitacion.showAndWait();
					if (!resultado.isPresent()) {}
					else if (resultado.get().equals(noHabitacion.getButtonTypes().get(1))) {
						campo.clear();
						Alert adios = new Alert(AlertType.INFORMATION);
						adios.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("./Imagenes/triste.png"),50,50,false,false)));
						adios.setHeaderText("No se encuentran habitaciones disponibles.");
						adios.setContentText("¡Gracias por elegirnos, esperamos tener disponibilidad la próxima ocasión!");
						adios.show();
					} else if (resultado.get().equals(noHabitacion.getButtonTypes().get(0))) {
						//Formulario Reserva
						VBox formulario = new VBox(10);
						formulario.setStyle("-fx-background-color:#FCF3CF ;");
						formulario.setAlignment(Pos.CENTER);
						Label titulo = new Label("Formulario nueva reserva.");
						Font tipoletraTit = new Font("Times New Roman", 30);
						titulo.setFont(tipoletraTit);
						titulo.setTextFill(Color.web("#873600"));
						titulo.setTextAlignment(TextAlignment.CENTER);
						
						Label descripcion = new Label("Por favor ingrese la siguiente información para realizar la reserva:");
						Font tipoletraDes = new Font("Times New Roman", 18);
						descripcion.setFont(tipoletraDes);
						descripcion.setTextAlignment(TextAlignment.CENTER);
						
						String[] criterios = {"Cédula","Nombre","Fecha de entrada en formato yyyy-mm-dd","Fecha de salida en formato yyyy-mm-dd","Número de acompañantes"};
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
					 * println("¡Gracias por elegirnos, esperamos tener disponibilidad la próxima ocasión!"
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
