package uiMain;
import baseDatos.Deserializacion;
import baseDatos.Serializacion;
import gestorAplicacion.Funcionamiento.Habitacion;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GUI extends Application {
	public static Stage ventana;
	public static Scene escena1;
	Scene  escenaFun = new Funcionalidades().getEscenaFun();
	public static Label label;
	
	
	 public void start(Stage ventana) throws Exception{
		 	GUI.ventana = ventana;
		   	ventana.setTitle("Hotel");
		   			   	
		   	//Panel vertical para almacenar saludo e imagenes del hotel.
		   	VBox p1 = new VBox();
		   	Label saludo = new Label("Bienvenidos al hotel, deseamos disfrute su estadía.\n Cualquier inquietud no dude en contactarse con nosotros.");
		   	saludo.setWrapText(true);
		   	saludo.setPrefSize(400, 200);
		   	Font tipoletra = new Font("Times New Roman", 25);
		   	saludo.setFont(tipoletra);
		   	saludo.setTextFill(Color.web("#873600"));
		   	saludo.setTextAlignment(TextAlignment.CENTER);
		   	saludo.setStyle("-fx-background-color: #FCF3CF ;");
		   	p1.setPadding(new Insets(10,15,10,15));
		   	p1.setSpacing(10);
		   	p1.setPrefSize(400, 550);
		   		   	
		   	//Panel para imagenes hotal y boton para ventana principal
		   	BorderPane pimagenes = new BorderPane();
		   	Button botonprincipal = new Button("Menú principal.");
		   	botonprincipal.setOnAction(new Eventos());
		   	
		   	pimagenes.setPrefSize(300, 300);
		   	//Etiqueta para agregar imagenes
		   	Image imagen = new Image(getClass().getResourceAsStream("./Imagenes/images.jpg"),350,250,false,false);
		   	label = new Label("", new ImageView(imagen));
		   	BorderPane.setAlignment(label, Pos.TOP_CENTER);
		   	pimagenes.setTop(label);
		   	p1.setStyle("-fx-background-color: #FCF3CF ;");
		   	pimagenes.setStyle("-fx-background-color:#FCF3CF ;");	   		   	
		   	pimagenes.setBottom(botonprincipal);
		   	p1.getChildren().addAll(saludo,pimagenes);
		   			   	
		   	//Panel vertical para almacenar hoja de vida y fotos.
		   	VBox p2 = new VBox();
		   	p2.setSpacing(5);
		   	p2.setPadding(new Insets(10,0,0,0));
		   	
		   	Label hojaVida = new Label();
		   	hojaVida.setText("Hojas de vida de los colaboradores.");
		   	hojaVida.setPrefSize(380, 200);
		   	hojaVida.setWrapText(true);
		   	hojaVida.setFont(new Font("Times New Roman", 25));		   	
		   	hojaVida.setStyle("-fx-font-alignment: center");
		   	hojaVida.setPadding(new Insets(0,0,0,10));
		   	hojaVida.setStyle("-fx-border-color: white;"); //Color del borde del label  	
		   	hojaVida.setTextFill(Color.web("#873600"));
		   	p2.getChildren().add(hojaVida);
		    p2.setStyle("-fx-background-color: #FCF3CF ;");
		   	p2.setPrefSize(400,550);
		   	
		   	//Grid para las imágenes
		   	GridPane fotos = new GridPane();
		   	fotos.setPrefSize(380, 200);
		   	fotos.setStyle("-fx-background-color:#FCF3CF ;");
		   	fotos.setVgap(5);
		   	fotos.setHgap(5);
		   	Image imagen1 = new Image(getClass().getResourceAsStream("./Imagenes/imagen1.jpg"), 187.5, 150, false, false);
		   	Label label1 = new Label("", new ImageView(imagen1)); 	
		   	Image imagen2 = new Image(getClass().getResourceAsStream("./Imagenes/imagen2.jpg"), 187.5, 150, false, false);
		   	Label label2= new Label("", new ImageView(imagen2));   	
		   	Image imagen3= new Image(getClass().getResourceAsStream("./Imagenes/imagen3.jpg"), 187.5, 150, false, false);
		   	Label label3 = new Label("", new ImageView(imagen3));	
		   	Image imagen4 = new Image(getClass().getResourceAsStream("./Imagenes/imagen4.jpg"), 187.5, 150, false, false);
		   	Label label4 = new Label("", new ImageView(imagen4));
		   	fotos.add(label1, 0, 0);
		   	fotos.add(label2, 1, 0);
		   	fotos.add(label3, 0, 1);
		   	fotos.add(label4, 1, 1);  	
		   	p2.getChildren().add(fotos);
		   
		   	//Panel principal.
		   	BorderPane principal = new BorderPane();
		   	principal.setLeft(p1);
		   	principal.setRight(p2);
		   	MenuBar barramenu = new MenuBar();
		   	Menu inicio = new Menu("Inicio");
		   	barramenu.getMenus().add(inicio);
		   	principal.setTop(barramenu);
		   	principal.setStyle("-fx-background-color:#FCF3CF ;");
		   	MenuItem salir = new MenuItem("Salir");
		   	salir.setOnAction(new Eventos());
			MenuItem descripcion = new MenuItem("Descripción");
			descripcion.setOnAction(new Eventos());
			
			SeparatorMenuItem separador = new SeparatorMenuItem();
			inicio.getItems().addAll(salir,separador,descripcion);
		   		
		   	//Escena 1: Ventana de incio.
		   	escena1 = new Scene(principal,800,550);
		   	ventana.setResizable(false);
		   	ventana.setScene(escena1);
	        ventana.show();
	    }
	
	
	public static void main(String[] args) {
		Deserializacion.deserializar();
		Habitacion.aumentarCapacidad();
		launch(args);
	
	}
	
	public Scene getEscenaGUI() {
		return escena1;
	}
	
	class Eventos implements EventHandler<ActionEvent>{
		
			public void handle(ActionEvent e) {
				Object control = e.getSource();
				if (control instanceof MenuItem) { 
					if(((MenuItem) control).getText().equals("Salir")) {
						//Serializacion.serializacion();
						Platform.exit();
						}
					else if(((MenuItem) control).getText().equals("Descripción")) {
						label.setText("La aplicación permite realizar las diferentes funciones que se presentan en el hotel,"
					+ "tales como el ingreso de los clientes, la selección de la habitación que se acomode a sus necesidades,"
					+ "la variedad de menús que pueden elegir y las atracciones disponibles para disfrutar de la estadía. "
					+ "\n"
					+ "Además permite el acceso del personal encargado de estos procesos para un correcto funcionamiento del "
					+ "hotel, entre ellos se destacan al administrador, encargado de pagar el salario de los empleados incluyendo "
					+ "las horas extras que estos validen, las mucamas encargadas de mantener las habitaciones en orden y disponibles "
					+ "cuando se requiera  y el recepcionista quien tiene el control de la entrada y salida de los clientes y del hotel "
					+ "en general.");
						label.setGraphic(null);
						label.setWrapText(true);
					}
					}
				else if(control instanceof Button) {
					if(((Button) control).getText().equals("Menú principal.")) {
							GUI.ventana.setScene(escenaFun);
						}
					}
				
	}
			
	
}
	
}
