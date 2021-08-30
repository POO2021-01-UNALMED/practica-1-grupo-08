package uiMain;

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

public class Funcionalidades extends Application {
	public static VBox principal;
	public MenuBar barramenu;
	public static Stage ventanaF;
	public static Label titulo;
	public static Label descripcion;
	public static Scene estandar;
	
	 public void start(Stage ventanaF) throws Exception{
		 	Funcionalidades.ventanaF = ventanaF;
		 	ventanaF.setTitle("Servicios del hotel.");
		    principal = new VBox(); // Contendrá todas zonas de la ventana de funcionalidades.
		   	barramenu = new MenuBar();
		   	
		   	Menu inicio = new Menu("Inicio");
		   	//inicio.setOnAction(new Inicio());
		   	MenuItem regresar = new MenuItem("Regresar");
		   	regresar.setOnAction(new Inicio());
		   	inicio.getItems().add(regresar);
		   	
		   	Menu archivo = new Menu("Archivo");
		   	MenuItem aplicacion = new MenuItem("Aplicación");
		   	aplicacion.setOnAction(new Eventos());
		   	MenuItem salir = new MenuItem("Salir");
		   	archivo.getItems().addAll(aplicacion,salir);
		   	
		   	Menu procesos = new Menu("Procesos y consultas");
			MenuItem fun1 = new MenuItem("Tomar habitación");
			fun1.setOnAction(new Eventos());
			MenuItem fun2 = new MenuItem("Cancelar reserva");
			fun2.setOnAction(new Eventos());
			MenuItem fun3 = new MenuItem("Elegir menú del restaurante");
			fun3.setOnAction(new Eventos());
			MenuItem fun4 = new MenuItem("Elegir atracción");
			MenuItem fun5 = new MenuItem("Mostrar ganancias netas");
			fun5.setOnAction(new Eventos());
			MenuItem fun6 = new MenuItem("Dar salida a un cliente");
			fun6.setOnAction(new Eventos());
			MenuItem fun7 = new MenuItem("Mostrar clientes");
			procesos.getItems().addAll(fun1,fun2,fun3,fun4,fun5,fun6,fun7);
			
			Menu ayuda = new Menu("Ayuda");
			MenuItem acerca = new MenuItem("Acerca de");
			ayuda.getItems().add(acerca);
			
			barramenu.getMenus().addAll(inicio,archivo,procesos,ayuda);
			
			principal.getChildren().addAll(barramenu);
							
			titulo = new Label("Bienvenido al hotel.");
			descripcion = new Label("En la barra superior encontrarás los servicios que tenemos disponibles,esperamos que sean de tu agrado.");
			Image imagen = new Image(getClass().getResourceAsStream("./Imagenes/images.jpg"),350,250,false,false);
		   	Label label = new Label("", new ImageView(imagen));
		   	principal.getChildren().addAll(titulo,descripcion,label);
		   	principal.setAlignment(Pos.TOP_CENTER);
		   			   	
		   	//TomarHabitacion ensayo = new TomarHabitacion();
		   	//principal.getChildren().add(ensayo.getTomarHabitacion());
		   	//Tomarhabitación
	
			estandar = new Scene(principal,800,550);
			ventanaF.setResizable(false);
			ventanaF.setScene(estandar);
			ventanaF.show();
	 }
	 
	public static void main(String[] args) {
		Deserializacion.deserializar();
		Habitacion.aumentarCapacidad();
		launch(args);
	}
}	
	class Eventos implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			MenuItem opcion = (MenuItem) e.getSource();
			if(opcion.getText().equals("Tomar habitación")) {
				GridPane hab = new TomarHabitacion().getTomarHabitacion();
				Funcionalidades.titulo.setText(("Tomar una habitación."));
				Funcionalidades.descripcion.setText("Para que le sea asignada una habitación por favor ingrese su número de cédula.");
				Funcionalidades.principal.getChildren().add(hab);
				Funcionalidades.principal.getChildren().remove(3);
				
			}else if(opcion.getText().equals("Cancelar reserva")) {
				//PARA ENSAYAR EL MÉTODO CANCELAR
				/*for (Cliente i : Hotel.getClientes()) {
					i.setHabitacion(Hotel.getHabitaciones().get(0));
					if (38836489 == i.getId()) {
						Reserva re = new Reserva("2021-02-10","2021-02-15",i);
						break;
					}
				}*/
				GridPane reserva = new CancelarReserva().getCancelarReserva();
				Funcionalidades.titulo.setText(("Cancelar una reserva."));
				Funcionalidades.descripcion.setText("Para cancelar su reserva por favor ingrese su número de cédula.");
				Funcionalidades.principal.getChildren().add(reserva);
				Funcionalidades.principal.getChildren().remove(3);
			}else if(opcion.getText().equals("Dar salida a un cliente")) {
				GridPane salida = new DarSalida().getDarSalida();
				Funcionalidades.titulo.setText(("Salida del hotel"));
				Funcionalidades.descripcion.setText("Para retirarse del hotel, por favor ingrese su cédula.");
				Funcionalidades.principal.getChildren().add(salida);
				Funcionalidades.principal.getChildren().remove(3);
			}else if (opcion.getText().equals("Elegir menú del restaurante")) {
				GridPane elemenu = new ElegirMenu().getElegirMenu();
				Funcionalidades.titulo.setText(("Elegir menú del restaurante"));
				Funcionalidades.descripcion.setText("Para elegir el menú que desea, por favor ingrese su cédula.");
				Funcionalidades.principal.getChildren().add(elemenu);
				Funcionalidades.principal.getChildren().remove(3);
			}else if(opcion.getText().equals("Mostrar ganancias netas")) {
					int total = 0;
										
					for (Cliente i : Hotel.getClientes()) {
						total += i.getCuentaFinal();
					}
					Funcionalidades.titulo.setText(("Informe de ganancias netas."));
					Funcionalidades.descripcion.setText("Administrador(a) " + Hotel.getAd1().getNombre() + ", a continuación se detalla los egresos e ingresos del hotel hasta el momento: ");
					TextArea info = new TextArea();
					info.setWrapText(true);
					info.setText("- Ingresos por cuentas finales de clientes: " + total + "\n" + "\n" +
							"- Egresos por pago de salarios a empleados: " + Hotel.getAd1().pagarSalario() + "\n" + "\n" +
							"- Ganancias netas: " + Hotel.gananciaNeta());
					info.setEditable(false);
					Funcionalidades.principal.getChildren().add(info);
					Funcionalidades.principal.getChildren().remove(3);
					//text.setStyle("-fx-font-weight:bold");
					//CON LIST VIEW
					/*ListView<String> info2 = new ListView<String>();
					info2.getItems().addAll("Ingresos por cuentas finales de clientes: " + total);
					info2.getItems().addAll("Egresos por pago de salarios a empleados: " + Hotel.getAd1().pagarSalario());
					info2.getItems().addAll("Ganancias netas: " + Hotel.gananciaNeta());
					Funcionalidades.principal.getChildren().add(info2);*/
			}
			
			
			if(opcion.getText().equals("Aplicación")) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Descripción de la aplicación.");
				alert.setHeaderText("¿O null? ¿O Sitema de información hotel?");
				alert.setContentText("La aplicación permite realizar las diferentes funciones que se presentan en un hotel,"
						+ "tales como el ingreso de los clientes, la selección de la habitación que se acomode a sus necesidades,"
						+ "la variedad de menús que pueden elegir y las atracciones disponibles para disfrutar de la estadía. "
						+ "\n" + "Además permite el acceso del personal encargado de estos procesos para un correcto funcionamiento del "
						+ "hotel, entre ellos se destacan al administrador, encargado de pagar el salario de los empleados incluyendo "
						+ "las horas extras que estos validen, las mucamas encargadas de mantener las habitaciones en orden y disponibles "
						+ "cuando se requiera  y el recepcionista quien tiene el control de la entrada y salida de los clientes y del hotel "
						+ "en general.");
				alert.show();
			}
		}
	}
	
	class Inicio implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
				System.out.println("Paso por aquí");
				Funcionalidades.ventanaF.setScene(Funcionalidades.estandar);
				Funcionalidades.titulo.setText("Bienvenido al hotel.");
				Funcionalidades.descripcion.setText("En la barra superior encontrarás los servicios que tenemos disponibles,esperamos que sean de tu agrado.");
				Funcionalidades.principal.getChildren().remove(3);
				Image imagen = new Image(getClass().getResourceAsStream("./Imagenes/images.jpg"),350,250,false,false);
			   	Label label = new Label("", new ImageView(imagen));
			   	Funcionalidades.principal.getChildren().addAll(label);
		}
	}
