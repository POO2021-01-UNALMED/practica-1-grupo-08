package uiMain;

import java.awt.Checkbox;
import java.util.ArrayList;
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
import javafx.scene.layout.VBox;

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
		// GridPane eleccionmenu;
		// GridPane platos;

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
					return;
				}

				if (!resulta.isPresent()) {
					return;
				}
			} else if (clienteNuevo != null) {
				infoCed.getChildren().clear();

				Funcionalidades.titulo.setText("Opciones de tipo de carta y platos");
				Funcionalidades.descripcion.setText("Elija a continuación el tipo de carta y los platos que desee.");
				String tipomenu[] = { "Carta vegetariana", "Carta tradicional" };
				ComboBox<String> combomenu = new ComboBox<String>(FXCollections.observableArrayList(tipomenu));
				combomenu.setPromptText("Tipo de carta");
				oyenteComboM elemenu = new oyenteComboM(combomenu);
				combomenu.setOnAction(elemenu);
				infoCed.addRow(0, combomenu);

			}
		}

	}

	class oyenteComboM implements EventHandler<ActionEvent> {
		ComboBox<String> combomenu;
		VBox eleccionmenu = new VBox();
		Label cabecera;
		Button confirmar = new Button("Confirmar elección");
		CheckBox op1;
		CheckBox op2 = new CheckBox();
		CheckBox op3 = new CheckBox();
		CheckBox op4 = new CheckBox();
		CheckBox op5 = new CheckBox();
		Label respuesta;
		Label seleccionados;

		public oyenteComboM(ComboBox<String> combomenu) {
			this.combomenu = combomenu;
			infoCed.addRow(1, eleccionmenu);
			respuesta = new Label("No ha seleccionado ningún plato");
			seleccionados = new Label("Platos seleccionados: <none>");
			cabecera = new Label("Seleccione los platos que desea:");
			op1 = new CheckBox();
		}

		public void handle(ActionEvent e) {
			eleccionmenu.getChildren().clear();
			eleccionmenu.getChildren().addAll(cabecera, op1, op2, op3, op4, op5, respuesta, seleccionados, confirmar);
			ArrayList<Integer> opcarta = new ArrayList<Integer>();
			confirmar.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					
					/*int numselect = 0;
					CheckBox[] op = {op1,op2,op3,op4,op5};
					for (int i=0; i<op.length;i++) {
						if(op[i].isSelected() == true) {
							numselect ++;
						}
					}*/
					if (opcarta.size() == 0) {
						Alert noselect = new Alert(AlertType.WARNING);
						noselect.setTitle("Advertencia");
						noselect.setHeaderText("Por favor selecciona como mínimo un plato.");
						noselect.show();
						return;
						
						}
					Alert confirmacion = new Alert(AlertType.CONFIRMATION);
					confirmacion.setTitle("Confirmación.");
					confirmacion.setHeaderText("Elección de platos");
					confirmacion.setContentText("¿Deseas confirmar el pedido?");
					ButtonType si = new ButtonType("Sí", ButtonBar.ButtonData.YES);
					ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
					confirmacion.getButtonTypes().setAll(si, no);
					Optional<ButtonType> respuesta = confirmacion.showAndWait();
					if (respuesta.get().equals(confirmacion.getButtonTypes().get(1))) {
						// mande a escoger platillo
					} else if (respuesta.get().equals(confirmacion.getButtonTypes().get(0))) {
						Alert pedido = new Alert(AlertType.INFORMATION);
						pedido.setTitle("Información");
						pedido.setContentText("Disfrute su plato. ¡Buen provecho!");
						Optional<ButtonType> resultado = pedido.showAndWait();
						if (resultado.get() == ButtonType.OK) {
							//combomenu.valueProperty().set(null);
							 //combomenu.getSelectionModel().clearSelection();
							op1.setSelected(false);
							op2.setSelected(false);
							op3.setSelected(false);
							op4.setSelected(false);
							op5.setSelected(false);
						}
					}
				}
			});

			if (combomenu.getValue().equals("Carta vegetariana")) {
				System.out.println("Holi");
				op1.setText("Espirales con setas y verduras. - $20000");
				op2.setText("Ensala de espárragos y requesón - $18000");
				op3.setText("Lasaña vegetal - $15000");
				op4.setText("Alcachofas rellenas de quinoa - $22000");
				op5.setText("Hamburguesa vegetariana - $15000");

				// Crear otro arreglo para tradicional y al final se envían los dos. Serían dos
				// líneas en comparación a otras 5
				

				// Acciones:
				op1.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op1.isSelected()) {
							respuesta.setText("Espirales con setas y verduras seleccionados.");
							opcarta.add(1);
						} else {

							respuesta.setText("Quitaste el plato: Espirales con setas y verduras");
							
							for (int i = 0; i < opcarta.size(); i++) {
								if (opcarta.get(i) == 1) {
									opcarta.remove(i);
								}
							}

						}
					}
				});

				op2.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op2.isSelected()) {
							respuesta.setText("Ensala de espárragos y requesón seleccionados.");
							opcarta.add(2);
						} else {
							respuesta.setText("Quitaste el plato: Ensala de espárragos y requesón");
							
							for (int i = 0; i < opcarta.size(); i++) {
								if (opcarta.get(i) == 2) {
									opcarta.remove(i);
								}
							}
						}
					}
				});

				op3.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op3.isSelected()) {
							respuesta.setText("Lasaña vegetal seleccionada.");
							opcarta.add(3);
						} else {
							respuesta.setText("Quitaste el plato: Lasaña vegetal");
							
							for (int i = 0; i < opcarta.size(); i++) {
								if (opcarta.get(i) == 3) {
									opcarta.remove(i);
								}
							}
						}
					}
				});

				op4.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op4.isSelected()) {
							respuesta.setText("Alcachofas rellenas de quinoa seleccionadas.");
							opcarta.add(4);
						} else {
							respuesta.setText("Quitaste el plato: Alcachofas rellenas de quinoa");
							
							for (int i = 0; i < opcarta.size(); i++) {
								if (opcarta.get(i) == 4) {
									opcarta.remove(i);
								}
							}
						}
					}
				});

				op5.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op5.isSelected()) {
							respuesta.setText("Hamburguesa vegetariana seleccionados.");
							opcarta.add(5);
						} else {
							respuesta.setText("Quitaste el plato: Hamburguesa vegetariana");
							
							for (int i = 0; i < opcarta.size(); i++) {
								if (opcarta.get(i) == 5) {
									opcarta.remove(i);
								}
							}
						}
					}
				});

				// void mostrar() { String platosselect = ""; }

			} else if(combomenu.getValue().equals("Carta tradicional")) {
				op1.setText("Alitas orientales - $15000.");
				op2.setText("Arroz atollado - $18000.");
				op3.setText("Bandeja paisa - $25000.");
				op4.setText("Crema de champiñones - $15000.");
				op5.setText("Hígado encebollado - $20000.");
				
				

				// Acciones:
				op1.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op1.isSelected()) {
							respuesta.setText("Espirales con setas y verduras seleccionados.");
							opcarta.add(1);
						} else {

							respuesta.setText("Quitaste el plato: Espirales con setas y verduras");
							
							for (int i = 0; i < opcarta.size(); i++) {
								if (opcarta.get(i) == 1) {
									opcarta.remove(i);
								}
							}

						}
					}
				});

				op2.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op2.isSelected()) {
							respuesta.setText("Ensala de espárragos y requesón seleccionados.");
							opcarta.add(2);
						} else {
							respuesta.setText("Quitaste el plato: Ensala de espárragos y requesón");
						
							for (int i = 0; i < opcarta.size(); i++) {
								if (opcarta.get(i) == 2) {
									opcarta.remove(i);
								}
							}
						}
					}
				});

				op3.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op3.isSelected()) {
							respuesta.setText("Lasaña vegetal seleccionada.");
							opcarta.add(3);
						} else {
							respuesta.setText("Quitaste el plato: Lasaña vegetal");
							
							for (int i = 0; i < opcarta.size(); i++) {
								if (opcarta.get(i) == 3) {
									opcarta.remove(i);
								}
							}
						}
					}
				});

				op4.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op4.isSelected()) {
							respuesta.setText("Alcachofas rellenas de quinoa seleccionadas.");
							opcarta.add(4);
						} else {
							respuesta.setText("Quitaste el plato: Alcachofas rellenas de quinoa");
							
							for (int i = 0; i < opcarta.size(); i++) {
								if (opcarta.get(i) == 4) {
									opcarta.remove(i);
								}
							}
						}
					}
				});

				op5.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op5.isSelected()) {
							respuesta.setText("Hamburguesa vegetariana seleccionados.");
							opcarta.add(5);
						} else {
							respuesta.setText("Quitaste el plato: Hamburguesa vegetariana");
							
							for (int i = 0; i < opcarta.size(); i++) {
								if (opcarta.get(i) == 5) {
									opcarta.remove(i);
								}
							}
						}
					}
				});


			}

		}
	}

}
