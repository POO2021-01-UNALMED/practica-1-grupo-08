package uiMain;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GUI extends Application {
	
	 public void start(Stage ventana) throws Exception{
		   	ventana.setTitle("Hotel.");
		   			   	
		   	//Panel vertical para almacenar saludo e imagenes del hotel.
		   	VBox p1 = new VBox();
		   	Label saludo = new Label("Bienvenidos al hotel, deseamos disfrute su estadía.\n Cualquier inquietud no dude en contactarse con nosotros.");
		   	saludo.setWrapText(true);
		   	saludo.setPrefSize(300, 200);
		   	Font tipoletra = new Font("Times New Roman", 25);
		   	saludo.setFont(tipoletra);
		   	saludo.setTextAlignment(TextAlignment.CENTER);
		   	p1.setPadding(new Insets(10,10,10,30));
		   	p1.setSpacing(10);
		   	saludo.setStyle("-fx-background-color: #ECD1CC ;");
		   	
				   	
		   	//Panel para imagenes hotal y boton para ventana principal
		   	BorderPane pimagenes = new BorderPane();
		   	Button botonprincipal = new Button("Menú principal.");
		   	pimagenes.setPrefSize(300, 300);
		   	//Etiqueta para agregar imagenes
		   	Image imagen1 = new Image(getClass().getResourceAsStream("./Imagenes/images.jpg"),300,250,false,false);
		   	Label label1 = new Label("", new ImageView(imagen1));
		   	pimagenes.setStyle("-fx-background-color: #ECD1CC ;");
		   	BorderPane.setAlignment(label1, Pos.TOP_CENTER);
		   	pimagenes.setTop(label1);
		   	
		   //	label1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		   	   	
		   			   		   	
		   	pimagenes.setBottom(botonprincipal);
		   	//pimagenes.setCenter(label1);
		   	p1.getChildren().addAll(saludo,pimagenes);
		   	
		   			   	
		   	//Panel vertical para almacenar hoja de vida y fotos.
		   	VBox p2 = new VBox();
		   	
		   	
		   	//Panel principal.
		   	BorderPane principal = new BorderPane();
		   	principal.setLeft(p1);
		   	principal.setRight(p2);
		   	MenuBar barramenu = new MenuBar();
		   	Menu inicio = new Menu("Inicio");
		   	barramenu.getMenus().add(inicio);
		   	principal.setTop(barramenu);
		   	
		   	
		   	
		   	
		   	//Escena 1: Ventana de incio.
		   	Scene escena1 = new Scene(principal,800,600);
		   	
		   	ventana.setScene(escena1);
	        ventana.show();
	    }
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
