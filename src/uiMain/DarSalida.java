package uiMain;

import java.util.Optional;

import Errores.Excepcion1;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import gestorAplicacion.Personal.Mucama;
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
//import uiMain.TomarHabitacion.buscarCliente;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class DarSalida {
	Label criterio = new Label("Cédula: ");
	TextField campo = new TextField();
	Button enviar = new Button("Enviar");
	GridPane panel1 = new GridPane();

	// Constructor
	public DarSalida() {
		evento oyente = new evento(campo);// Se le ingresa como parámetro el TextField campo(donde se le ingresa la
										// cedula)
		enviar.setOnAction(oyente);
		panel1.addRow(0, criterio, campo, enviar);
		panel1.setAlignment(Pos.CENTER);
		GridPane.setMargin(campo, new Insets(20,20,20,20));
		Font tipoletraTex = new Font("Times New Roman", 18);
		criterio.setFont(tipoletraTex);
	}

	public GridPane getDarSalida() {
		return panel1;
	}

// Buscar cliente
	class evento implements EventHandler<ActionEvent> {
		TextField campo;
		 
		public evento(TextField c) {
			campo = c; 
		}
		public void handle(ActionEvent evento) {
			BuscarCliente oidor= new BuscarCliente(campo);
			try {				
				oidor.handle();}
			catch(Excepcion1 e){
				Alert sinCliente = new Alert(AlertType.ERROR);
				sinCliente.setTitle("Error");
				sinCliente.setHeaderText("Cliente no encontrado.");
				sinCliente.setContentText(e.getMessage());
				Optional<ButtonType> result = sinCliente.showAndWait();
				if (!result.isPresent()) {
					campo.clear();
				}
				else if (result.get() == ButtonType.OK) {
					campo.clear();
			}
			}
			
			
			Cliente cliente = oidor.getBuscarCliente();
			if (cliente == null){
				return;
			}
			
			
			if (cliente.getHabitacion() == null) {
				Alert noregistrado = new Alert(AlertType.ERROR);
				noregistrado.setTitle("Error");
				noregistrado.setHeaderText("Usted no se encuentra en el hotel y no tiene deudas pendientes.");
				// noregistrado.setContentText("");
				Optional<ButtonType> resulta = noregistrado.showAndWait();
				if (!resulta.isPresent()) {
					campo.clear();
				}
				else if (resulta.get() == ButtonType.OK) {
					campo.clear();
				}
				return;

			}
			if (cliente.isReserva()) {
				Alert conreserva = new Alert(AlertType.INFORMATION);
				conreserva.setTitle("Información");
				conreserva.setHeaderText("Usted tiene una reserva asignada");
				conreserva.setContentText(
						"Si desea cancelarla, diríjase al menú y seleccione la opción 'Cancelar Reserva'");
				Optional<ButtonType> resulta = conreserva.showAndWait();
				if (!resulta.isPresent()) {
					campo.clear();
				}
				if (resulta.get() == ButtonType.OK) {
					campo.clear();
				}
				return;
			}
			Hotel.cobrarDeudas(cliente);

			int rd = (int) (Math.random() * (Hotel.getEmpleados().size()));
			Mucama mucamaAux = new Mucama();
			cliente.getHabitacion().getClientes().remove(0);

			while (true) {
				int rd2 = (int) (Math.random() * (Hotel.getEmpleados().size()));
				if (Hotel.getEmpleados().get(rd) instanceof Mucama) {
					mucamaAux = (Mucama) Hotel.getEmpleados().get(rd);
					break;
				}
				rd = rd2;
			}
			if (cliente.getHabitacion().getClientes().size() == 0) {
				mucamaAux.limpiarHabitacion(cliente.getHabitacion());
			} else {
				mucamaAux.limpiarHabitacion(cliente);
			}

			cliente.setHabitacion(null);
			mucamaAux.setHabitacion(null);
			// Hacer Reserva
			Alert hacerReserva = new Alert(AlertType.CONFIRMATION);
			hacerReserva.setTitle("Confirmación.");
			hacerReserva.setHeaderText("¿Desea hacer una nuerva reserva?");
			ButtonType si = new ButtonType("Sí", ButtonBar.ButtonData.YES);
			ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
			hacerReserva.getButtonTypes().setAll(si, no);
			Optional<ButtonType> resultado = hacerReserva.showAndWait();
			if (!resultado.isPresent()) {
				campo.clear();
				return;
			}
			else if (resultado.get().equals(hacerReserva.getButtonTypes().get(1))) {
				campo.clear();
				Alert adios = new Alert(AlertType.INFORMATION);
				adios.setHeaderText("¡Gracias por visitarnos, vuelva pronto!");
				adios.show();
			} else if (resultado.get().equals(hacerReserva.getButtonTypes().get(0))) {
				// Formulario Reserva
				VBox formulario = new VBox(10);
				formulario.setStyle("-fx-background-color:#FCF3CF ;");
				formulario.setAlignment(Pos.TOP_CENTER);
				Label titulo = new Label("Formulario nueva reserva.");
				Font tipoletraTit = new Font("Times New Roman", 30);
				titulo.setFont(tipoletraTit);
				titulo.setTextFill(Color.web("#873600"));
				titulo.setTextAlignment(TextAlignment.CENTER);
				VBox.setMargin(titulo, new Insets(30,10,10,10));
				Label descripcion = new Label("Por favor ingrese la siguiente información para realizar la reserva:");
				Font tipoletraDes = new Font("Times New Roman", 18);
				descripcion.setFont(tipoletraDes);
				descripcion.setTextAlignment(TextAlignment.CENTER);
				

				String[] criterios = { "Cédula", "Nombre", "Fecha de entrada en formato yyyy-mm-dd", "Fecha de salida en formato yyyy-mm-dd",
						"Número de acompañantes" };
				String[] valores = { String.valueOf(cliente.getId()), cliente.getNombre(), null, null, null };
				Boolean[] habilitados = { false, false, true, true, true };
				FieldPane campos = new FieldPane("Criterio", criterios, "Valor", valores, habilitados);

				formulario.getChildren().addAll(titulo, descripcion, campos.getFieldPane());
				Scene salidaCliente = new Scene(formulario, 800, 550);
				GUI.ventana.setScene(salidaCliente);

			}
		}
	}
}
