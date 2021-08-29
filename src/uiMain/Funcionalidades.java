package uiMain;

import baseDatos.Deserializacion;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Habitacion;
import gestorAplicacion.Funcionamiento.Hotel;
import gestorAplicacion.Funcionamiento.Reserva;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Funcionalidades extends Application {
	public static VBox principal;
	public static MenuBar barramenu;
	public static Stage ventanaF;
	public static Label titulo;
	public static Label descripcion;
	public static Scene estandar;
	
	 public void start(Stage ventanaF) throws Exception{
		 	Funcionalidades.ventanaF = ventanaF;
		 	ventanaF.setTitle("Servicios del hotel.");
		    principal = new VBox(); // Contendrá todas zonas de la ventana de funcionalidades.
		   	barramenu = new MenuBar();
		   	
		   	
		   	Menu archivo = new Menu("Archivo");
		   	MenuItem aplicacion = new MenuItem("Aplicación");
		   	MenuItem salir = new MenuItem("Salir");
		   	archivo.getItems().addAll(aplicacion,salir);
		   	
		   	Menu procesos = new Menu("Procesos y consultas");
			MenuItem fun1 = new MenuItem("Tomar habitación");
			fun1.setOnAction(new Eventos());
			MenuItem fun2 = new MenuItem("Cancelar reserva");
			fun2.setOnAction(new Eventos());
			MenuItem fun3 = new MenuItem("Elegir menú del restaurante");
			MenuItem fun4 = new MenuItem("Elegir atracción");
			MenuItem fun5 = new MenuItem("Mostrar ganancias netas");
			MenuItem fun6 = new MenuItem("Dar salida a un cliente");
			MenuItem fun7 = new MenuItem("Mostrar clientes");
			procesos.getItems().addAll(fun1,fun2,fun3,fun4,fun5,fun6,fun7);
			
			Menu ayuda = new Menu("Ayuda");
			MenuItem acerca = new MenuItem("Acerca de");
			ayuda.getItems().add(acerca);
			
			barramenu.getMenus().addAll(archivo,procesos,ayuda);
			
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
				for (Cliente i : Hotel.getClientes()) {
					i.setHabitacion(Hotel.getHabitaciones().get(0));
					if (38836489 == i.getId()) {
						Reserva re = new Reserva("2021-02-10","2021-02-15",i);
						break;
					}
				}
				GridPane reserva = new CancelarReserva().getCancelarReserva();
				Funcionalidades.titulo.setText(("Cancelar una reserva."));
				Funcionalidades.descripcion.setText("Para cancelar su reserva por favor ingrese su número de cédula.");
				Funcionalidades.principal.getChildren().add(reserva);
				//Siempre remover el 3 porque es el último nodo que se agrega, y es el único que cambia.
				Funcionalidades.principal.getChildren().remove(3);
			}
		}
	}
	

