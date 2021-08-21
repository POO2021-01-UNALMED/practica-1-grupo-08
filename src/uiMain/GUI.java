package uiMain;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
	
	 public void start(Stage ventana) throws Exception{
		   	ventana.setTitle("Hotel.");
		   			   	
		   	//Panel vertical para almacenar saludo e imagenes del hotel.
		   	VBox p1 = new VBox();
		   	Label saludo = new Label("Bienvenidos al hotel, deseamos disfrute su estadía. Cualquier inquietud no dude en contactarse con nosotros.");
		   	saludo.setWrapText(true);
		   	
		   	//Panel para imagenes hotal y boton para ventana principal
		   	BorderPane pimagenes = new BorderPane();
		   	Button botonprincipal = new Button("Menú principal.");
		   	
		   	//Etiqueta para agregar imagenes
		   	Image imagen1 = new Image(getClass().getResourceAsStream("./Imagenes/images.jpg"));
		   	Label label1 = new Label("", new ImageView(imagen1));
		   	   	
		   			   		   	
		   	pimagenes.setBottom(botonprincipal);
		   	pimagenes.setCenter(label1);
		   	p1.getChildren().addAll(pimagenes);
		   	
		   	
		   	
		   	//Panel vertical para almacenar hoja de vida y fotos.
		   	VBox p2 = new VBox();
		   	
		   	//Panel principal.
		   	BorderPane principal = new BorderPane();
		   	principal.setLeft(p1);
		   	principal.setRight(p2);
		   	
		   	
		   	
		   	
		   	//Escena 1: Ventana de incio.
		   	Scene escena1 = new Scene(principal,800,600);
		   	
		   	ventana.setScene(escena1);
	        ventana.show();
	    }
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
