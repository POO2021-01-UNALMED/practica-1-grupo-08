package uiMain;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
			
			//Formulario Reserva
			/*VBox formulario = new VBox();
			Label titulo = new Label("Titulo ensayo");
			Label descripcion = new Label("Ensayo descripcion");
			
			String[] criterios = {"Cedula","Nombre","Fecha de entrada","Fecha de salida","Número de acompañantes"};
			String[] valores = {"3254654","Luisa",null,null,null};
			Boolean[] habilitados = {false,false,true,true,true};
			FieldPane campos = new FieldPane("Criterio",criterios,"Valor",valores, habilitados );
			
			formulario.getChildren().addAll(titulo,descripcion,campos.getFieldPane());
			principal.getChildren().add(formulario);*/
			
			Label titulo = new Label("Bienvenido al hotel.");
			Label descripcion = new Label("En la barra superior encontrarás los servicios que tenemos disponibles,esperamos que sean de tu agrado.");
			Image imagen = new Image(getClass().getResourceAsStream("./Imagenes/images.jpg"),350,250,false,false);
		   	Label label = new Label("", new ImageView(imagen));
		   	principal.getChildren().addAll(titulo,descripcion,label);
		   	principal.setAlignment(Pos.TOP_CENTER);
			
			Scene estandar = new Scene(principal,800,550);
			ventanaF.setResizable(false);
			ventanaF.setScene(estandar);
			ventanaF.show();

	 }

	public static void main(String[] args) {
		launch(args);
	}
	
}
