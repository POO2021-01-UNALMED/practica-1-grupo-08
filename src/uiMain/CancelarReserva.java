package uiMain;

import java.util.Optional;
import Errores.ExcepcionNoCliente;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import gestorAplicacion.Funcionamiento.Reserva;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
//Clase CancelarReserva:
/* Funcionalidad: Esta clase permite que al ser seleccionado en la barra de men� el item cancelar reserva, un 
 * cliente pueda ingresar su c�dula y cancelar una reserva previamente realizada. Se controlan varios aspectos
 * como que el cliente si se encuentre registrado y que si tenga una reserva realizada, en todos estos casos 
 * saldr�n cuadros de di�logos informando si se pudo realizar la transacci�n o no.
 * */
public class CancelarReserva {
	Label criterio = new Label("C�dula: ");
	TextField campo = new TextField();
	Button enviar = new Button("Enviar");
	GridPane formCedula = new GridPane();
		
	public CancelarReserva(){
		formCedula.setHgap(10);
		formCedula.setVgap(15);
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
			catch(ExcepcionNoCliente e) {
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
			cliente = oidor.getBuscarCliente();
				if (cliente == null){
					return;
				}
			//Cuadros de di�logos en caso de que el cliente si pueda cancelar una reserva
			if (cliente.isReserva() == true) {
				for (Reserva i : Hotel.getReservas()) {
					if (i.getCliente() == cliente) {
						formCedula.getChildren().removeAll(criterio,campo,enviar);
						Funcionalidades.titulo.setText(("Informaci�n de la reserva."));
						Funcionalidades.descripcion.setText("Se registra la siguiente reserva para el cliente: " + cliente.getNombre());
						info = new TextArea();
						info.setWrapText(true);
						info.setText("N�mero de habitaci�n: " + cliente.getHabitacion().getNumhabitacion() + "\n" + "N�mero de acompa�antes: " +cliente.getNumAcompanantes() + "\n" + "Fecha de ingreso: " + i.getFecha_de_ingreso() + "\n" + "Fecha de salida: " + i.getFecha_de_salida());
						info.setEditable(false);
						eliminar = new Button("Cancelar reserva");
						formCedula.addRow(0, info);
						formCedula.addRow(1, eliminar);
						eliminar.setOnAction(new EventHandler<ActionEvent>(){
							public void handle(ActionEvent e) {
								Alert confirm = new Alert(AlertType.CONFIRMATION);
								confirm.setTitle("Confirmaci�n.");
								confirm.setHeaderText("Proceso de cancelaci�n.");
								confirm.setContentText("�Est� seguro que desea cancelar la reserva?");
								ButtonType si = new ButtonType("S�", ButtonBar.ButtonData.YES);
								ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
								confirm.getButtonTypes().setAll(si, no);
								Optional<ButtonType> resultado = confirm.showAndWait();
								if (!resultado.isPresent()) {
									return;
								}
								else if (resultado.get().equals(confirm.getButtonTypes().get(1))) {
										Funcionalidades.titulo.setText(("Cancelar una reserva."));
										Funcionalidades.descripcion.setText("Para cancelar su reserva por favor ingrese su n�mero de c�dula.");
										formCedula.getChildren().removeAll(info,eliminar);
										campo.clear();
										formCedula.getChildren().addAll(criterio,campo,enviar);
								}else if(resultado.get().equals(confirm.getButtonTypes().get(0))) {
										i.cancelar_reserva(cliente);
										Alert eliminada = new Alert(AlertType.INFORMATION);
										eliminada.setTitle("Informaci�n");
										eliminada.setHeaderText("Reserva cancelada con �xito.");
										eliminada.setContentText("Esperamos que pronto disfrutes de nuestros servicios.");
										Optional<ButtonType> result = eliminada.showAndWait();
										if (!result.isPresent()) {
											Funcionalidades.principal.getChildren().remove(3);
											GUI.ventana.setScene(Funcionalidades.estandar);
											Funcionalidades.titulo.setText("Bienvenido al hotel.");
											Funcionalidades.descripcion.setText(
													"En la barra superior encontrar�s los servicios que tenemos disponibles,esperamos que sean de tu agrado.");
											Image imagen = new Image(getClass().getResourceAsStream("images.jpg"), 350, 250, false,
													false);
											Label label = new Label("", new ImageView(imagen));
											Funcionalidades.principal.getChildren().addAll(label);
										}
										else if (result.get() == ButtonType.OK) {
											Funcionalidades.titulo.setText(("Cancelar una reserva."));
											Funcionalidades.descripcion.setText("Para cancelar su reserva por favor ingrese su n�mero de c�dula.");
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
				//Cuadro de di�logo en el caso en que el cliente no tenga reservas	
			} else {
				Alert noReserva = new Alert(AlertType.INFORMATION);
				noReserva.setTitle("Informaci�n");
				noReserva.setHeaderText("Reserva no encontrada.");
				noReserva.setContentText("Usted no tiene reservas para cancelar.");
				Optional<ButtonType> result = noReserva.showAndWait();
				if (!result.isPresent()) {
					campo.clear();
				}
				else if (result.get() == ButtonType.OK) {
						campo.clear();
					}
				}
		}
	}
}



