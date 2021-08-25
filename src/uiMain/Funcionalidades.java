package uiMain;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Funcionalidades extends Application {
	
	 public void start(Stage ventanaF) throws Exception{
		   	ventanaF.setTitle("Hotel");
		   	
		   	VBox principal = new VBox(); // Contendrá todas zonas de la ventana de funcionalidades.
		   	Label nombre = new Label("Servicios del hotel");
		   	
		   	MenuBar barramenu = new MenuBar();
		   	
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
			
			principal.getChildren().addAll(nombre,barramenu);
			
			Scene estandar = new Scene(principal,800,550);
			ventanaF.setResizable(false);
			ventanaF.setScene(estandar);
			ventanaF.show();

	 }

	public static void main(String[] args) {
		launch(args);
	}
	
}
