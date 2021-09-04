package uiMain;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import Errores.ExcepcionFechas;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class FieldPane extends Pane{
	private String tituloCriterios;
	private String[] criterios;
	private String tituloValores;
	private String[] valores;
	private Boolean[] habilitado; 
	ArrayList<TextField> limpiar = new ArrayList<TextField>();
	
	GridPane grid = new GridPane();
	//Organizar fechas que indiquen el formato
	public FieldPane(String tituloCriterios, String criterios [], String tituloValores, String valores [], Boolean habilitado[]) {
		this.tituloCriterios = tituloCriterios;	
		this.criterios = criterios;
		this.tituloValores = tituloValores;
		this.valores = valores;
		this.habilitado = habilitado;
		
	
		Label criterio = new Label(tituloCriterios);
		Label valor = new Label (tituloValores); 
		grid.addRow(0,criterio, valor);
		
		for(int i = 0; i<criterios.length; i++) {
			Label label = new Label(criterios[i]);
			TextField tx  = new TextField(valores[i]);
			if(!habilitado[i]){
				tx.setDisable(true);
				grid.addRow(i+1, label, tx);	
			}else {
				limpiar.add(tx);
				grid.addRow(i+1, label, tx);}	
		}
			
		Button aceptar = new Button("Aceptar");
		aceptar.setOnAction(new oyenteConfirmar());
		Button borrar = new Button("Borrar");
		borrar.setOnAction(new oyenteBorrar());
		Button regresar = new Button("Regresar");
		regresar.setOnAction(new oyenteRegresar());
		grid.addRow(grid.getRowCount()+1, aceptar, borrar, regresar);
	}
	
		
	public String getValue(String criterio) {
		String aux = null;
		for(int i = 0; i< criterios.length; i++) {
			if(criterios[i].equals(criterio)) {
				aux = valores[i];				
			} 
	}
		return aux; //Crear excepción si retorna un null
		}
	
	public GridPane getFieldPane() {
		return grid;
	}
	
	public void fechas() throws ExcepcionFechas{
		String tipoError = null;
		System.out.println(limpiar.get(0).getText());
		System.out.println(limpiar.get(1).getText());
		LocalDate fechanuevaEntrada = LocalDate.parse(limpiar.get(0).getText());
		LocalDate fechanuevaSalida = LocalDate.parse(limpiar.get(1).getText());
		
		Cliente cliente = null;
		for(Cliente i: Hotel.getClientes()) {
			if(Long.parseLong(valores[0]) == i.getId()) {
				cliente = i;
			}
		}
		
		//Comparación salida cliente con entrada nueva
		if(cliente.getFecha_salida().isAfter(fechanuevaEntrada)) {
			tipoError = "Ingrese una fecha de entrada superior a " + cliente.getFecha_salida();
			throw new ExcepcionFechas();
			
		}else if(fechanuevaSalida.isAfter(fechanuevaEntrada)) {
			tipoError = "Ingrese una fecha de salida superior a la fecha de entrada " + fechanuevaEntrada;
			throw new ExcepcionFechas();
		}
	}
	
	class oyenteBorrar implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			for(TextField i: limpiar) {
				i.setText("");
			}
		}
	}
	
	class oyenteRegresar implements EventHandler<ActionEvent>{
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
	
	// Control de fechas. Una superior a otra.
	class oyenteConfirmar implements EventHandler<ActionEvent>{
		String error;
		public void handle(ActionEvent e){
			try {
				error = fechas();
			} catch (ExcepcionFechas e1) {
				Alert sinCliente = new Alert(AlertType.ERROR);
				sinCliente.setTitle("Error");
				sinCliente.setHeaderText(e1.getMessage());
				sinCliente.setContentText(error);
				Optional<ButtonType> result = sinCliente.showAndWait();
				if (!result.isPresent()) {
					}
				else if (result.get() == ButtonType.OK) {
					limpiar.get(0).clear();
					limpiar.get(1).clear();
					limpiar.get(2).clear();
				}
			}
		}
	}
	
}
