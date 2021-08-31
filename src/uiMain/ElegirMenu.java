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

	class oyenteComboM implements  EventHandler<ActionEvent>{
		ComboBox<String> combomenu;
		VBox eleccionmenu = new VBox();
		Label cabecera = new Label("Seleccione los platos que desea:");
		Button confirmar = new Button("Confirmar elección");
		/**/
		
		public oyenteComboM(ComboBox<String> combomenu) {
			this.combomenu = combomenu;
		}
		
		
		
		public void handle(ActionEvent e) {
			eleccionmenu.getChildren().add(cabecera);
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
						// mande a escoger platillo
					} else if (respuesta.get().equals(confirmacion.getButtonTypes().get(0))) {
						Alert pedido = new Alert(AlertType.INFORMATION);
						pedido.setTitle("Información");
						pedido.setContentText("Disfrute su plato. ¡Buen provecho! ");
						Optional<ButtonType> resultado = pedido.showAndWait();
						if (resultado.get() == ButtonType.OK) {
							combomenu.valueProperty().set(null);
						}
					}
				}
			});
			
			if(combomenu.getValue().equals("Carta vegetariana")) {
				
				Label respuesta = new Label("No ha seleccionado ningún plato");
				Label seleccionados = new Label("Platos seleccionados: <none>");
				CheckBox op1 = new CheckBox("Espirales con setas y verduras. - $20000");
				CheckBox op2 = new CheckBox("Ensala de espárragos y requesón - $18000");
				CheckBox op3 = new CheckBox("Lasaña vegetal - $15000");
				CheckBox op4 = new CheckBox("Alcachofas rellenas de quinoa - $22000");
				CheckBox op5 = new CheckBox("Hamburguesa vegetariana - $15000");
				eleccionmenu.getChildren().addAll(cabecera, op1, op2, op3, op4, op5, respuesta, seleccionados);
				eleccionmenu.getChildren().remove(op1, op2, op3, op4, op5, respuesta, seleccionados);
				ArrayList<Integer> opcarta = new ArrayList<Integer>();

				// Acciones:
				op1.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (op1.isSelected()) {
							respuesta.setText("Espirales con setas y verduras seleccionados.");
							opcarta.add(1);
						} else {
							respuesta.setText("Quitaste el plato: Espirales con setas y verduras");
							opcarta.remove(1);

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
							opcarta.remove(2);
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
							opcarta.remove(3);
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
							opcarta.remove(4);
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
							opcarta.remove(5);
						}
					}
				});
				infoCed.addRow(1, eleccionmenu);
				infoCed.addRow(2, confirmar);
				
				
				
				//void mostrar() { String platosselect = ""; }
				
				
				
			}else {
				//VBox eleccionmenu = new VBox();
			}
			
			
			
		}
		
	}

				
					

					
					 
					 

					
					
					

					
				
		
	
}
