package uiMain;

import java.util.Optional;

import baseDatos.Deserializacion;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.*;
import gestorAplicacion.Personal.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Funcionalidades {
	public static VBox principal = new VBox();
	public MenuBar barramenu = new MenuBar();;
	// public static Stage ventanaF;
	public static Label titulo;
	public static Label descripcion;
	public static Scene estandar = new Scene(principal, 800, 550);
	// principal=new VBox(); // Contendrá todas zonas de la ventana de
	// funcionalidades.

	public void crearScene() {

		Menu inicio = new Menu("Inicio");
		// inicio.setOnAction(new Inicio());
		MenuItem regresar = new MenuItem("Regresar");
		regresar.setOnAction(new Inicio());
		inicio.getItems().add(regresar);

		Menu archivo = new Menu("Archivo");
		MenuItem aplicacion = new MenuItem("Aplicación");
		aplicacion.setOnAction(new Eventos());
		MenuItem salir = new MenuItem("Salir");
		salir.setOnAction(new Eventos());
		archivo.getItems().addAll(aplicacion, salir);

		Menu procesos = new Menu("Procesos y consultas");
		MenuItem fun1 = new MenuItem("Tomar habitación");
		fun1.setOnAction(new Eventos());
		MenuItem fun2 = new MenuItem("Cancelar reserva");
		fun2.setOnAction(new Eventos());
		MenuItem fun3 = new MenuItem("Elegir menú del restaurante");
		fun3.setOnAction(new Eventos());
		MenuItem fun4 = new MenuItem("Elegir atracción");
		fun4.setOnAction(new Eventos());
		MenuItem fun5 = new MenuItem("Mostrar ganancias netas");
		fun5.setOnAction(new Eventos());
		MenuItem fun6 = new MenuItem("Dar salida a un cliente");
		fun6.setOnAction(new Eventos());
		MenuItem fun7 = new MenuItem("Mostrar clientes");
		fun7.setOnAction(new Eventos());
		procesos.getItems().addAll(fun1, fun2, fun3, fun4, fun5, fun6, fun7);

		Menu ayuda = new Menu("Ayuda");
		MenuItem acerca = new MenuItem("Acerca de");
		acerca.setOnAction(new Eventos());
		ayuda.getItems().add(acerca);

		barramenu.getMenus().addAll(inicio, archivo, procesos, ayuda);

		principal.getChildren().addAll(barramenu);

		titulo = new Label("Bienvenido al hotel.");
		descripcion = new Label(
				"En la barra superior encontrarás los servicios que tenemos disponibles,esperamos que sean de tu agrado.");
		Image imagen = new Image(getClass().getResourceAsStream("./Imagenes/images.jpg"), 350, 250, false, false);
		Label label = new Label("", new ImageView(imagen));
		principal.getChildren().addAll(titulo, descripcion, label);
		principal.setAlignment(Pos.TOP_CENTER);

		// TomarHabitacion ensayo = new TomarHabitacion();
		// principal.getChildren().add(ensayo.getTomarHabitacion());
		// Tomarhabitación

		//estandar = new Scene(principal, 800, 550);
	}


	public Scene getEscenaFun() {
		crearScene();
		return estandar;
	}

}
class Eventos implements EventHandler<ActionEvent> {
	public void handle(ActionEvent e) {
		MenuItem opcion = (MenuItem) e.getSource();
		if (opcion.getText().equals("Tomar habitación")) {
			GridPane hab = new TomarHabitacion().getTomarHabitacion();
			Funcionalidades.titulo.setText(("Tomar una habitación."));
			Funcionalidades.descripcion
					.setText("Para que le sea asignada una habitación por favor ingrese su número de cédula.");
			Funcionalidades.principal.getChildren().add(hab);
			Funcionalidades.principal.getChildren().remove(3);

		} else if (opcion.getText().equals("Cancelar reserva")) {
			// PARA ENSAYAR EL MÉTODO CANCELAR
			/*
			 * for (Cliente i : Hotel.getClientes()) {
			 * i.setHabitacion(Hotel.getHabitaciones().get(0)); if (38836489 == i.getId()) {
			 * Reserva re = new Reserva("2021-02-10","2021-02-15",i); break; } }
			 */
			GridPane reserva = new CancelarReserva().getCancelarReserva();
			Funcionalidades.titulo.setText(("Cancelar una reserva."));
			Funcionalidades.descripcion.setText("Para cancelar su reserva por favor ingrese su número de cédula.");
			Funcionalidades.principal.getChildren().add(reserva);
			Funcionalidades.principal.getChildren().remove(3);
		} else if (opcion.getText().equals("Dar salida a un cliente")) {
			GridPane salida = new DarSalida().getDarSalida();
			Funcionalidades.titulo.setText(("Salida del hotel"));
			Funcionalidades.descripcion.setText("Para retirarse del hotel, por favor ingrese su cédula.");
			Funcionalidades.principal.getChildren().add(salida);
			Funcionalidades.principal.getChildren().remove(3);
		} else if (opcion.getText().equals("Elegir menú del restaurante")) {
			GridPane elemenu = new ElegirMenu().getElegirMenu();
			Funcionalidades.titulo.setText(("Elegir menú del restaurante"));
			Funcionalidades.descripcion.setText("Para elegir el menú que desea, por favor ingrese su cédula.");
			Funcionalidades.principal.getChildren().remove(3);
			Funcionalidades.principal.getChildren().add(elemenu);
		} else if(opcion.getText().equals("Elegir atracción")){
			GridPane eleatraccion = new ElegirAtraccion().getElegirAtraccion();
			Funcionalidades.titulo.setText(("Elegir atracción"));
			Funcionalidades.descripcion.setText("Para elegir la atracción que desea, por favor ingrese su cédula.");
			Funcionalidades.principal.getChildren().remove(3);
			Funcionalidades.principal.getChildren().add(eleatraccion);
		}else if (opcion.getText().equals("Mostrar ganancias netas")) {
			int total = 0;
			for (Cliente i : Hotel.getClientes()) {
				total += i.getCuentaFinal();
			}
			Funcionalidades.titulo.setText(("Informe de ganancias netas."));
			Funcionalidades.descripcion.setText("Administrador " + Hotel.getAd1().getNombre()
					+ ", a continuación se detalla los egresos e ingresos del hotel hasta el momento: ");
			TextArea info = new TextArea();
			info.setWrapText(true);
			info.setText("- Ingresos por cuentas finales de clientes: " + total + "\n" + "\n"
					+ "- Egresos por pago de salarios a empleados: " + Hotel.getAd1().pagarSalario() + "\n" + "\n"
					+ "- Ganancias netas: " + Hotel.gananciaNeta());
			info.setEditable(false);
			Funcionalidades.principal.getChildren().add(info);
			Funcionalidades.principal.getChildren().remove(3);
			// text.setStyle("-fx-font-weight:bold");
		} else if (opcion.getText().equals("Mostrar clientes")) {
			Funcionalidades.titulo.setText("Mostrar clientes");
			Funcionalidades.descripcion.setText("A continuación se presenta la lista de clientes activos en el hotel");
			int cont = 0;
			for (Cliente i : Hotel.getClientes()) {
				if (i.getHabitacion() != null && i.isReserva() == false) {
					cont++;
				}
			}
			if (cont == 0) {
				Alert nulo = new Alert(AlertType.INFORMATION);
				nulo.setTitle("Información");
				nulo.setHeaderText("En el momento no se encuentran clientes hospedados en el hotel.");
				Optional<ButtonType> resulta = nulo.showAndWait();
				if (!resulta.isPresent()) {
				}
				if (resulta.get() == ButtonType.OK) {
					GUI.ventana.setScene(Funcionalidades.estandar);
					Funcionalidades.titulo.setText("Bienvenido al hotel.");
					Funcionalidades.descripcion.setText(
							"En la barra superior encontrarás los servicios que tenemos disponibles,esperamos que sean de tu agrado.");
				}
			 }else {
				Funcionalidades.principal.getChildren().remove(3);
				ListView<String> clientes = new ListView<String>();
				for (Cliente i : Hotel.getClientes()) {
					if (i.getHabitacion() != null && i.isReserva() == false) {
						clientes.getItems().add("Cliente identificado con " + i.getId() + ", hospedado en la habitación " + i.getHabitacion().getNumhabitacion() + ".");
					}
				}
				Funcionalidades.principal.getChildren().add(clientes);
			}
		}

		else if (opcion.getText().equals("Aplicación")) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Descripción de la aplicación.");
			alert.setHeaderText("Información hotel.");
			alert.setContentText("La aplicación permite realizar las diferentes funciones que se presentan en el hotel,"
					+ "tales como el ingreso de los clientes, la selección de la habitación que se acomode a sus necesidades,"
					+ "la variedad de menús que pueden elegir y las atracciones disponibles para disfrutar de la estadía. "
					+ "\n"
					+ "Además permite el acceso del personal encargado de estos procesos para un correcto funcionamiento del "
					+ "hotel, entre ellos se destacan al administrador, encargado de pagar el salario de los empleados incluyendo "
					+ "las horas extras que estos validen, las mucamas encargadas de mantener las habitaciones en orden y disponibles "
					+ "cuando se requiera  y el recepcionista quien tiene el control de la entrada y salida de los clientes y del hotel "
					+ "en general.");
			alert.show();
		} else if (opcion.getText().equals("Acerca de")) {
			Alert nombres = new Alert(AlertType.INFORMATION);
			nombres.setTitle("Creadores");
			nombres.setHeaderText("Ximena Castañeda Ochoa \nYojan Andrés Alcaráz Pérez \nVerónica Seguro Varela");
			nombres.setGraphic(new ImageView(
					new Image(getClass().getResourceAsStream("./Imagenes/equipo.png"), 50, 50, false, false)));
			Optional<ButtonType> resulta = nombres.showAndWait();
			if (!resulta.isPresent()) {
			} else if (resulta.get() == ButtonType.OK) {
				GUI.ventana.setScene(Funcionalidades.estandar);
				Funcionalidades.titulo.setText("Bienvenido al hotel.");
				Funcionalidades.descripcion.setText(
						"En la barra superior encontrarás los servicios que tenemos disponibles,esperamos que sean de tu agrado.");
			}

		}

		else if (opcion.getText().equals("Salir")) {			
			Image imagen = new Image(getClass().getResourceAsStream("./Imagenes/images.jpg"),350,250,false,false);
			GUI.label.setGraphic( new ImageView(imagen));
			GUI.label.setText("");
			GUI.ventana.setScene(GUI.escena1);
		}
	}
}

class Inicio implements EventHandler<ActionEvent> {
	public void handle(ActionEvent e) {
		GUI.ventana.setScene(Funcionalidades.estandar);
		Funcionalidades.titulo.setText("Bienvenido al hotel.");
		Funcionalidades.descripcion.setText(
				"En la barra superior encontrarás los servicios que tenemos disponibles,esperamos que sean de tu agrado.");
		Funcionalidades.principal.getChildren().remove(3);
		Image imagen = new Image(getClass().getResourceAsStream("./Imagenes/images.jpg"), 350, 250, false, false);
		Label label = new Label("", new ImageView(imagen));
		Funcionalidades.principal.getChildren().addAll(label);
	}
}

