package uiMain;

import java.awt.Checkbox;
import java.util.Optional;

import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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

public class ElegirMenu {
	Label criterio = new Label("Cédula: ");
	TextField campo = new TextField();
	Button enviar = new Button("Enviar");
	GridPane infoCed = new GridPane();

	public ElegirMenu() {
		ElegirM oyente = new ElegirM(campo);// Se le ingresa como parámetro el TextField campo(donde se le ingresa la
		// cedula)
		enviar.setOnAction(oyente);
		infoCed.addRow(0, criterio, campo, enviar);
	}

	public GridPane getElegirMenu() {
		return infoCed;
	}

	class ElegirM implements EventHandler<ActionEvent> {
		TextField campo;
		//GridPane eleccionmenu;
		//GridPane platos;

		public ElegirM(TextField c) {
			campo = c;
		}

		public void handle(ActionEvent evento) { 
			BuscarCliente oidor = new BuscarCliente(campo);
			oidor.handle();
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
				}
			} else if (clienteNuevo != null) {
				GridPane eleccionmenu = new GridPane();
				Label titulo = new Label("Opciones de carta y platos.");
				Label descripcion = new Label("Elija a continuación el tipo de carta y los platos que desee.");
				String tipomenu[] = { "Carta vegetariana", "Carta tradicional" };
				ComboBox combomenu = new ComboBox(FXCollections.observableArrayList(tipomenu));
				combomenu.setPromptText("Tipo de carta");
				TextField eleccion = new TextField();
				
				combomenu.valueProperty().addListener(new ChangeListener<String>() {
					public void changed(ObservableValue ov, String t, String t1) {
						eleccion.setText(t1);
						System.out.println(t1);
					}
				});
				
				System.out.println(eleccion.getText());
				
				if (eleccion.getText().equals("Carta tradicional")) {
					GridPane platos = new GridPane();
					Label cabecera = new Label("Seleccione los platos que desea:");
					Label respuesta = new Label("No ha seleccionado ningún plato");
					Label seleccionados = new Label("Platos seleccionados: <none>");
					CheckBox op1 = new CheckBox("Espirales con setas y verduras. - $20000");
					CheckBox op2 = new CheckBox("Ensala de espárragos y requesón - $18000");
					CheckBox op3 = new CheckBox("Lasaña vegetal - $15000");
					CheckBox op4 = new CheckBox("Alcachofas rellenas de quinoa - $22000");
					CheckBox op5 = new CheckBox("Hamburguesa vegetariana - $15000");

					// Acciones:
					op1.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							if (op1.isSelected()) {
								respuesta.setText("Espirales con setas y verduras seleccionados.");
							} else {
								respuesta.setText("Quitaste el plato: Espirales con setas y verduras");

							}
						}
					});

					op2.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							if (op2.isSelected()) {
								respuesta.setText("Ensala de espárragos y requesón seleccionados.");
							} else {
								respuesta.setText("Quitaste el plato: Ensala de espárragos y requesón");

							}
						}
					});

					op3.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							if (op3.isSelected()) {
								respuesta.setText("Lasaña vegetal seleccionados.");
							} else {
								respuesta.setText("Quitaste el plato: Lasaña vegetal");
							}
						}
					});

					op4.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							if (op4.isSelected()) {
								respuesta.setText("Alcachofas rellenas de quinoa seleccionados.");
							} else {
								respuesta.setText("Quitaste el plato: Alcachofas rellenas de quinoa");
							}
						}
					});

					op5.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							if (op5.isSelected()) {
								respuesta.setText("Hamburguesa vegetariana seleccionados.");
							} else {
								respuesta.setText("Quitaste el plato: Hamburguesa vegetariana");
							}
						}
					});

					platos.getChildren().addAll(cabecera, op1, op2, op3, op4, op5, respuesta, seleccionados);

					
					/* void mostrar() { 
						 String platosselect = "";
					 }*/
					 

				}// cierra if
			}

			/*Button confirmar = new Button("Confirmar elección");
			Button regresar = new Button("Regresar");
			eleccionmenu.addRow(0, titulo);
			eleccionmenu.addRow(1, descripcion);
			eleccionmenu.addRow(2, combomenu, eleccion);
			eleccionmenu.addRow(3, confirmar, regresar);
			Scene elegirMenu = new Scene(eleccionmenu, 800, 550);
			Funcionalidades.ventanaF.setScene(elegirMenu);

			confirmar.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					Alert confirmacion = new Alert(AlertType.CONFIRMATION);
					confirmacion.setTitle("Confirmación.");
					confirmacion.setHeaderText("Elección de platos");
					confirmacion.setContentText("¿Deseas confirmar el pedido?");
					ButtonType si = new ButtonType("Sí", ButtonBar.ButtonData.YES);
					ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
					confirmacion.getButtonTypes().setAll(si, no);
					Optional<ButtonType> respuesta = confirmacion.showAndWait();
					if (respuesta.get().equals(confirmacion.getButtonTypes().get(1))) {
						titulo.setText("Elige otros platos que desees");
					} else if (respuesta.get().equals(confirmacion.getButtonTypes().get(0))) {
						Alert pedido = new Alert(AlertType.INFORMATION);
						pedido.setTitle("Información");
						pedido.setContentText("Disfrute su plato. ¡Buen provecho! ");
						Optional<ButtonType> resultado = pedido.showAndWait();
						if (resultado.get() == ButtonType.OK) {
							eleccionmenu.getChildren().removeAll(confirmar);
							/// NECESITO LIMPIAR LAS ELECCIONES.
						}
					}
				}
			});*/
		}

	}
}
