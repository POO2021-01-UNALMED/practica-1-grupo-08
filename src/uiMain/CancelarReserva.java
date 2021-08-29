package uiMain;

import java.util.Optional;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import gestorAplicacion.Funcionamiento.Reserva;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class CancelarReserva {
	Label criterio = new Label("Cédula: ");
	TextField campo = new TextField();
	Button enviar = new Button("Enviar");
	GridPane formCedula = new GridPane();
		
	public CancelarReserva(){
		Cancelar oyente = new Cancelar();
		enviar.setOnAction(oyente);
		formCedula.addRow(0, criterio, campo, enviar);
	}
	
	public GridPane getCancelarReserva() {
		return formCedula;
	}
	
	class Cancelar implements EventHandler<ActionEvent> {
		Cliente clienteNuevo = null;
		public void handle(ActionEvent evento) {
			Long cedula = Long.parseLong(campo.getText().trim());
			boolean confirmacion = false;
			
			
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
				sinCliente.setContentText("Por favor ingrese una nueva cédula.");
				Optional<ButtonType> result = sinCliente.showAndWait();

				if (result.get() == ButtonType.OK) {
					campo.clear();
				}
			}else if (confirmacion == true) {
				if (clienteNuevo.isReserva() == true) {
					for (Reserva i : Hotel.getReservas()) {
						if (i.getCliente() == clienteNuevo) {
							GridPane infoReserva = new GridPane();
							Label titulo = new Label("Información de la reserva.");
							Label descripcion = new Label("Se registra la siguiente reserva para el cliente: " + clienteNuevo.getNombre());
							TextArea info = new TextArea();
							info.setWrapText(true);
							info.setText("Número de habitación: " + clienteNuevo.getHabitacion().getNumhabitacion() + "\n" + "Número de acompañantes: " +clienteNuevo.getNumAcompanantes() + "\n" + "Fecha de ingreso: " + i.getFecha_de_ingreso() + "\n" + "Fecha de salida: " + i.getFecha_de_salida());
							info.setDisable(true);
							Button eliminar = new Button("Cancelar reserva");
							//Button regresar = new Button("Regresar");
							infoReserva.addRow(0, titulo);
							infoReserva.addRow(1, descripcion);
							infoReserva.addRow(2, info);
							infoReserva.addRow(3, eliminar);
							Scene CancelarReserva = new Scene(infoReserva,800,550);
							Funcionalidades.ventanaF.setScene(CancelarReserva);
							eliminar.setOnAction(new EventHandler<ActionEvent>(){
							public void handle(ActionEvent e) {
									i.cancelar_reserva(clienteNuevo);
									Alert confirm = new Alert(AlertType.CONFIRMATION);
									confirm.setTitle("Confirmación.");
									confirm.setHeaderText("Proceso de cancelación.");
									confirm.setContentText("¿Está seguro que desea cancelar la reserva?");
									ButtonType si = new ButtonType("Sí", ButtonBar.ButtonData.YES);
									ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
									confirm.getButtonTypes().setAll(si, no);
									Optional<ButtonType> resultado = confirm.showAndWait();
									if (resultado.get().equals(confirm.getButtonTypes().get(1))) {
										titulo.setText("¡Gracias por seguir eligiéndonos!");
									}else if(resultado.get().equals(confirm.getButtonTypes().get(0))) {
										Alert eliminada = new Alert(AlertType.INFORMATION);
										eliminada.setTitle("Información");
										eliminada.setHeaderText("Reserva cancelada con éxito.");
										eliminada.setContentText("Esperamos que pronto disfrutes de nuestros servicios.");
										Optional<ButtonType> result = eliminada.showAndWait();
										if (result.get() == ButtonType.OK) {
											infoReserva.getChildren().removeAll(eliminar);
											descripcion.setText("No hay reservas por cancelar.");
											info.clear();
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
						
					}
				}
			}
		}
	}

}
