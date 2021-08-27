package uiMain;

import java.util.ArrayList;

import baseDatos.Deserializacion;
import gestorAplicacion.Funcionamiento.Habitacion;
import javafx.application.Application;
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
			MenuItem fun2 = new MenuItem("Cancelar reserva");
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
			
						
			Label titulo = new Label("Bienvenido al hotel.");
			Label descripcion = new Label("En la barra superior encontrarás los servicios que tenemos disponibles,esperamos que sean de tu agrado.");
			Image imagen = new Image(getClass().getResourceAsStream("./Imagenes/images.jpg"),350,250,false,false);
		   	Label label = new Label("", new ImageView(imagen));
		   	principal.getChildren().addAll(titulo,descripcion,label);
		   	principal.setAlignment(Pos.TOP_CENTER);
		   			   	
			
		   	TomarHabitacion ensayo = new TomarHabitacion();
		   	principal.getChildren().add(ensayo.getTomarHabitacion());
		   	
		   
		   	
			Scene estandar = new Scene(principal,800,550);
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
