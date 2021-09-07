package uiMain;

import java.util.Optional;

import Errores.Excepcion1;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import gestorAplicacion.Funcionamiento.Reserva;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class CancelarReserva {
	Label criterio = new Label("Cédula: ");
	TextField campo = new TextField();
	Button enviar = new Button("Enviar");
	GridPane formCedula = new GridPane();
		
	public CancelarReserva(){
		Cancelar oyente = new Cancelar(campo);
		enviar.setOnAction(oyente);
		formCedula.addRow(0, criterio, campo, enviar);
		formCedula.setAlignment(Pos.CENTER);
		GridPane.setMargin(campo, new Insets(20,20,20,20));
		Font tipoletraTex = new Font("Times New Roman", 18);
		criterio.setFont(tipoletraTex);
	}
	
	public GridPane getCancelarReserva() {
		return formCedula;
	}
	
	class Cancelar implements EventHandler<ActionEvent> {
		TextField campoBuscar;
		Button eliminar;
		TextArea info;
		Cliente cliente;
		
		public Cancelar(TextField c) {
			campoBuscar = c; 
	}
		
		public void handle(ActionEvent evento) {
			BuscarCliente oidor = new BuscarCliente(campoBuscar);
			try {
				oidor.handle();}
			catch(Excepcion1 e) {
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
			cliente = oidor.getBuscarCliente();
				if (cliente == null){
					return;
				}

			//Revisar!!!!!!!	
			if(cliente.isReserva()==false && cliente.getHabitacion().isDisponibilidadHab()==true) {
				Alert eliminada = new Alert(AlertType.INFORMATION);
				eliminada.setTitle("Información");
				eliminada.setHeaderText("Reserva cancelada con éxito.");
				eliminada.setContentText("Esperamos que pronto disfrutes de nuestros servicios.");
				Optional<ButtonType> result = eliminada.showAndWait();
				if (result.get() == ButtonType.OK) {
					Funcionalidades.titulo.setText(("Cancelar una reserva."));
					Funcionalidades.descripcion.setText("Para cancelar su reserva por favor ingrese su número de cédula.");
					campo.clear();
					formCedula.getChildren().removeAll(info,eliminar);
					formCedula.getChildren().addAll(criterio,campo,enviar);
				}
			}	
			if (cliente.isReserva() == true) {
				for (Reserva i : Hotel.getReservas()) {
					if (i.getCliente() == cliente) {
						formCedula.getChildren().removeAll(criterio,campo,enviar);
						Funcionalidades.titulo.setText(("Información de la reserva."));
						Funcionalidades.descripcion.setText("Se registra la siguiente reserva para el cliente: " + cliente.getNombre());
						info = new TextArea();
						info.setWrapText(true);
						info.setText("Número de habitación: " + cliente.getHabitacion().getNumhabitacion() + "\n" + "Número de acompañantes: " +cliente.getNumAcompanantes() + "\n" + "Fecha de ingreso: " + i.getFecha_de_ingreso() + "\n" + "Fecha de salida: " + i.getFecha_de_salida());
						info.setDisable(true);
						eliminar = new Button("Cancelar reserva");
						formCedula.addRow(0, info);
						formCedula.addRow(1, eliminar);
						eliminar.setOnAction(new EventHandler<ActionEvent>(){
							public void handle(ActionEvent e) {
								Alert confirm = new Alert(AlertType.CONFIRMATION);
								confirm.setTitle("Confirmación.");
								confirm.setHeaderText("Proceso de cancelación.");
								confirm.setContentText("¿Está seguro que desea cancelar la reserva?");
								ButtonType si = new ButtonType("Sí", ButtonBar.ButtonData.YES);
								ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
								confirm.getButtonTypes().setAll(si, no);
								Optional<ButtonType> resultado = confirm.showAndWait();
									if (resultado.get().equals(confirm.getButtonTypes().get(1))) {
										Funcionalidades.titulo.setText(("Cancelar una reserva."));
										Funcionalidades.descripcion.setText("Para cancelar su reserva por favor ingrese su número de cédula.");
										formCedula.getChildren().removeAll(info,eliminar);
										campo.clear();
										formCedula.getChildren().addAll(criterio,campo,enviar);
									}else if(resultado.get().equals(confirm.getButtonTypes().get(0))) {
										i.cancelar_reserva(cliente);
										Alert eliminada = new Alert(AlertType.INFORMATION);
										eliminada.setTitle("Información");
										eliminada.setHeaderText("Reserva cancelada con éxito.");
										eliminada.setContentText("Esperamos que pronto disfrutes de nuestros servicios.");
										Optional<ButtonType> result = eliminada.showAndWait();
										if (result.get() == ButtonType.OK) {
											Funcionalidades.titulo.setText(("Cancelar una reserva."));
											Funcionalidades.descripcion.setText("Para cancelar su reserva por favor ingrese su número de cédula.");
											campo.clear();
											formCedula.getChildren().removeAll(info,eliminar);
											formCedula.getChildren().addAll(criterio,campo,enviar);
										}
									}
								}
							});
							break;
					}
				}				
					
			} else {
				Alert noReserva = new Alert(AlertType.INFORMATION);
				noReserva.setTitle("Información");
				noReserva.setHeaderText("Reserva no encontrada.");
				noReserva.setContentText("Usted no tiene reservas para cancelar.");
				Optional<ButtonType> result = noReserva.showAndWait();
					if (result.get() == ButtonType.OK) {
						campo.clear();
					}
				}
		}
	}
}


