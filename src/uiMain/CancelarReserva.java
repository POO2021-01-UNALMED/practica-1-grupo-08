package uiMain;

import java.util.Optional;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import gestorAplicacion.Funcionamiento.Reserva;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.*;

public class CancelarReserva {
	Label criterio = new Label("Cédula: ");
	TextField campo = new TextField();
	Button enviar = new Button("Enviar");
	GridPane formCedula = new GridPane();
		
	public CancelarReserva(){
		Cancelar oyente = new Cancelar(campo);
		enviar.setOnAction(oyente);
		formCedula.addRow(0, criterio, campo, enviar);
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
			oidor.handle();
			cliente = oidor.getBuscarCliente();
				if (cliente == null){
					return;
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
						//Button regresar = new Button("Regresar");
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
							
							/*regresar.setOnAction(new EventHandler<ActionEvent>(){
								public void handle(ActionEvent e) {
									Funcionalidades.titulo.setText("Bienvenido al hotel.");
									Funcionalidades.descripcion.setText("En la barra superior encontrarás los servicios que tenemos disponibles,esperamos que sean de tu agrado.");
									Funcionalidades.principal.getChildren().remove(3);
									Image imagen = new Image(getClass().getResourceAsStream("./Imagenes/images.jpg"),350,250,false,false);
								   	Label label = new Label("", new ImageView(imagen));
								   	Funcionalidades.principal.getChildren().add(label);
									Funcionalidades.ventanaF.setScene(Funcionalidades.estandar);
								}
							});*/
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


