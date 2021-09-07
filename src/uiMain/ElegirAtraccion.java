package uiMain;

import java.util.ArrayList;
import java.util.Optional;

import Errores.Excepcion1;
import gestorAplicacion.Cliente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import uiMain.ElegirMenu.ElegirM;

public class ElegirAtraccion {
	Label criterio = new Label("Cédula: ");
	TextField campo = new TextField();
	Button enviar = new Button("Enviar");
	GridPane infoCed = new GridPane();

	public ElegirAtraccion() {
		ElegirA oyente = new ElegirA(campo);// Se le ingresa como parámetro el TextField campo(donde se le ingresa la
		// cedula)
		enviar.setOnAction(oyente);
		infoCed.addRow(0, criterio, campo, enviar);
		infoCed.setAlignment(Pos.CENTER);
		GridPane.setMargin(campo, new Insets(20, 20, 20, 20));
		Font tipoletraTex = new Font("Times New Roman", 18);
		criterio.setFont(tipoletraTex);
	}

	public GridPane getElegirAtraccion() {
		return infoCed;
	}

	class ElegirA implements EventHandler<ActionEvent> {
		TextField campo;

		public ElegirA(TextField c) {
			campo = c;
		}

		public void handle(ActionEvent evento) {
			BuscarCliente oidor = new BuscarCliente(campo);
			try {
				oidor.handle();
			} catch (Excepcion1 e) {
				Alert sinCliente = new Alert(AlertType.ERROR);
				sinCliente.setTitle("Error");
				sinCliente.setHeaderText("Cliente no encontrado.");
				sinCliente.setContentText(e.getMessage() + " cliente no registrado en la base de datos");
				Optional<ButtonType> result = sinCliente.showAndWait();
				if (!result.isPresent()) {
				} else if (result.get() == ButtonType.OK) {
					campo.clear();
				}
			}
			Cliente clienteNuevo = oidor.getBuscarCliente();
			if (clienteNuevo == null) {
				return;
			}

			if (clienteNuevo.getHabitacion() == null || clienteNuevo.isReserva() == true) {
				Alert noHospedado = new Alert(AlertType.INFORMATION);
				noHospedado.setTitle("Información");
				noHospedado.setHeaderText("Debes estar hospedado en el hotel para acceder a estos servicios.");
				noHospedado.setContentText(
						"Si desea acceder a nuestros servicios le invitamos a dirigirse al menú y tomar una habitación.");//// ¿AQUÍ
																															//// CÓMO
																															//// PROCEDE?
				Optional<ButtonType> resulta = noHospedado.showAndWait();
				if (resulta.get() == ButtonType.OK) {
					campo.clear();
					return;
				}

				if (!resulta.isPresent()) {
					return;
				}
			} else if (clienteNuevo != null) {
				infoCed.getChildren().clear();
				VBox eleccionatr = new VBox(10);
				Label cabecera;
				Button confirmar = new Button("Confirmar elección");
				CheckBox op1;
				CheckBox op2 = new CheckBox();
				CheckBox op3 = new CheckBox();
				CheckBox op4 = new CheckBox();
				CheckBox op5 = new CheckBox();
				CheckBox op6 = new CheckBox();
				CheckBox op7 = new CheckBox();
				CheckBox op8 = new CheckBox();
				Label respuesta;

				infoCed.addRow(1, eleccionatr);
				respuesta = new Label("No ha seleccionado ninguna atracción");
				respuesta.setWrapText(true);
				respuesta.setTextAlignment(TextAlignment.CENTER);
				cabecera = new Label("Seleccione las atracciones que desea:");
				op1 = new CheckBox();
				
				Font tipoletra = new Font("Times New Roman", 18);
				respuesta.setFont(tipoletra);
				cabecera.setFont(tipoletra);
				op1.setStyle("-fx-font-family: 'Times New Roman' ; -fx-font-size: 18px ;");
				op2.setStyle("-fx-font-family: 'Times New Roman' ; -fx-font-size: 18px ;");
				op3.setStyle("-fx-font-family: 'Times New Roman' ; -fx-font-size: 18px ;");
				op4.setStyle("-fx-font-family: 'Times New Roman' ; -fx-font-size: 18px ;");
				op5.setStyle("-fx-font-family: 'Times New Roman' ; -fx-font-size: 18px ;");
				op6.setStyle("-fx-font-family: 'Times New Roman' ; -fx-font-size: 18px ;");
				op7.setStyle("-fx-font-family: 'Times New Roman' ; -fx-font-size: 18px ;");
				op8.setStyle("-fx-font-family: 'Times New Roman' ; -fx-font-size: 18px ;");

				eleccionatr.getChildren().addAll(cabecera, op1, op2, op3, op4, op5, op6, op7, op8, respuesta,
						confirmar);
				eleccionatr.setPadding(new Insets(10,10,10,10));
				eleccionatr.setPrefSize(400,300);
				ArrayList<Integer> opatraccion = new ArrayList<Integer>();
				confirmar.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {

						if (opatraccion.size() == 0) {
							Alert noselect = new Alert(AlertType.WARNING);
							noselect.setTitle("Advertencia");
							noselect.setHeaderText("Por favor selecciona como mínimo una atracción");
							noselect.show();
							return;

						}
						Alert confirmacion = new Alert(AlertType.CONFIRMATION);
						confirmacion.setTitle("Confirmación.");
						confirmacion.setHeaderText("Elección de atracciones");
						confirmacion.setContentText("¿Deseas confirmar tu elección?");
						ButtonType si = new ButtonType("Sí", ButtonBar.ButtonData.YES);
						ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
						confirmacion.getButtonTypes().setAll(si, no);
						Optional<ButtonType> respuesta = confirmacion.showAndWait();
						if (respuesta.get().equals(confirmacion.getButtonTypes().get(1))) {
							// mande al campo de escoger más atracciones
						} else if (respuesta.get().equals(confirmacion.getButtonTypes().get(0))) {
							// Gastos Servicios
							for (int i = 0; i < opatraccion.size(); i++) {
								clienteNuevo.getServicio().tipoAtraccion(opatraccion.get(i), clienteNuevo);
							}
							Alert pedido = new Alert(AlertType.INFORMATION);
							pedido.setTitle("Información");
							pedido.setHeaderText(null);
							pedido.setContentText("Entrada a los juegos confirmada ¡Que se divierta!");
							Optional<ButtonType> resultado = pedido.showAndWait();
							if (resultado.get() == ButtonType.OK) {
								// combomenu.valueProperty().set(null);
								// combomenu.getSelectionModel().clearSelection();
								op1.setSelected(false);
								op2.setSelected(false);
								op3.setSelected(false);
								op4.setSelected(false);
								op5.setSelected(false);
								op6.setSelected(false);
								op7.setSelected(false);
								op8.setSelected(false);
							}
						}
					}
				});

				op1.setText("Montaña rusa - $15000.");
				op2.setText("Paseo oscuro - $15000.");
				op3.setText("Carritos chocones - $10000.");
				op4.setText("Piscina - $20000.");
				op5.setText("Piscina de pelotas - $8000.");
				op6.setText("Carrusel - $8000.");
				op7.setText("Bungy - $10000.");
				op8.setText("Barco pirata - $15000.");

				// Acciones:
				op1.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op1.isSelected()) {
							respuesta.setText("Montaña rusa seleccionada");
							opatraccion.add(1);
						} else {

							respuesta.setText("Quitaste la atracción: Montaña rusa");

							for (int i = 0; i < opatraccion.size(); i++) {
								if (opatraccion.get(i) == 1) {
									opatraccion.remove(i);
								}
							}

						}
					}
				});

				op2.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op2.isSelected()) {
							respuesta.setText("Paseo oscuro seleccionado.");
							opatraccion.add(2);
						} else {
							respuesta.setText("Quitaste la atracción: Paseo oscuro");

							for (int i = 0; i < opatraccion.size(); i++) {
								if (opatraccion.get(i) == 2) {
									opatraccion.remove(i);
								}
							}
						}
					}
				});

				op3.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op3.isSelected()) {
							respuesta.setText("Carritos chocones seleccionados");
							opatraccion.add(3);
						} else {
							respuesta.setText("Quitaste la atracción: Carritos chocones");

							for (int i = 0; i < opatraccion.size(); i++) {
								if (opatraccion.get(i) == 3) {
									opatraccion.remove(i);
								}
							}
						}
					}
				});

				op4.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op4.isSelected()) {
							respuesta.setText("Piscina seleccionada.");
							opatraccion.add(4);
						} else {
							respuesta.setText("Quitaste la atracción: Piscina");

							for (int i = 0; i < opatraccion.size(); i++) {
								if (opatraccion.get(i) == 4) {
									opatraccion.remove(i);
								}
							}
						}
					}
				});

				op5.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op5.isSelected()) {
							respuesta.setText("Piscina de pelotas seleccionada.");
							opatraccion.add(5);
						} else {
							respuesta.setText("Quitaste la atracción: Piscina de pelotas");

							for (int i = 0; i < opatraccion.size(); i++) {
								if (opatraccion.get(i) == 5) {
									opatraccion.remove(i);
								}
							}
						}
					}
				});

				op6.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op6.isSelected()) {
							respuesta.setText("Carrusel seleccionado.");
							opatraccion.add(6);
						} else {

							respuesta.setText("Quitaste la atracción: Carrusel");

							for (int i = 0; i < opatraccion.size(); i++) {
								if (opatraccion.get(i) == 6) {
									opatraccion.remove(i);
								}
							}

						}
					}
				});

				op7.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op7.isSelected()) {
							respuesta.setText("Bungy seleccionado.");
							opatraccion.add(7);
						} else {

							respuesta.setText("Quitaste la atracción: Bungy");

							for (int i = 0; i < opatraccion.size(); i++) {
								if (opatraccion.get(i) == 7) {
									opatraccion.remove(i);
								}
							}

						}
					}
				});

				op8.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op8.isSelected()) {
							respuesta.setText("Barco pirata seleccionado.");
							opatraccion.add(8);
						} else {

							respuesta.setText("Quitaste la atracción: Barco pirata");

							for (int i = 0; i < opatraccion.size(); i++) {
								if (opatraccion.get(i) == 8) {
									opatraccion.remove(i);
								}
							}

						}
					}
				});

			}

		}
	}

}
