package uiMain;

import java.util.Optional;

import Errores.Excepcion1;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import gestorAplicacion.Personal.Mucama;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import uiMain.TomarHabitacion.buscarCliente;

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
				sinCliente.setContentText(e.getMessage() +" cliente no registrado en la base de datos");
				Optional<ButtonType> result = sinCliente.showAndWait();
				if (!result.isPresent()) {
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
				if (resulta.get() == ButtonType.OK) {
					campo.clear();
				}

			}
			if (cliente.isReserva()) {
				Alert conreserva = new Alert(AlertType.INFORMATION);
				conreserva.setTitle("Información");
				conreserva.setHeaderText("Usted tiene una reserva asignada");
				conreserva.setContentText(
						"Si desea cancelarla, diríjase al menú y seleccione la opción 'Cancelar Reserva'");
				Optional<ButtonType> resulta = conreserva.showAndWait();
				if (resulta.get() == ButtonType.OK) {
					campo.clear();
				}
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
			// noHabitacion.setContentText("¿Desea reservar una habitación?");
			ButtonType si = new ButtonType("Sí", ButtonBar.ButtonData.YES);
			ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
			hacerReserva.getButtonTypes().setAll(si, no);
			Optional<ButtonType> resultado = hacerReserva.showAndWait();

			if (resultado.get().equals(hacerReserva.getButtonTypes().get(1))) {
				campo.clear();
				Alert adios = new Alert(AlertType.INFORMATION);
				// adios.setGraphic(new ImageView(new
				// Image(getClass().getResourceAsStream("./Imagenes/triste.png"),50,50,false,false)));
				adios.setHeaderText("¡Gracias por visitarnos, vuelva pronto!");
				// adios.setContentText("¡Gracias por elegirnos, esperamos tener disponibilidad
				// la próxima ocasión!");
				adios.show();
			} else if (resultado.get().equals(hacerReserva.getButtonTypes().get(0))) {
				// Formulario Reserva
				VBox formulario = new VBox();
				Label titulo = new Label("Formulario nueva reserva.");
				Label descripcion = new Label("Por favor ingrese la siguiente información para realizar la reserva.");

				String[] criterios = { "Cedula", "Nombre", "Fecha de entrada", "Fecha de salida",
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
