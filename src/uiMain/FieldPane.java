package uiMain;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Optional;

import Errores.ExcepcionFechas;
import Errores.ExcepcionNulos;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Habitacion;
import gestorAplicacion.Funcionamiento.Hotel;
import gestorAplicacion.Funcionamiento.Reserva;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

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
		Font tipoletraTit = new Font("Times New Roman", 18);
		criterio.setFont(tipoletraTit);
		criterio.setTextFill(Color.web("#873600"));
		criterio.setTextAlignment(TextAlignment.CENTER);
		valor.setFont(tipoletraTit);
		valor.setTextFill(Color.web("#873600"));
		valor.setTextAlignment(TextAlignment.CENTER);
		
		
		grid.addRow(0,criterio, valor);
		
		for(int i = 0; i<criterios.length; i++) {
			Label label = new Label(criterios[i]);
			label.setFont(tipoletraTit);
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
		
		grid.setPadding(new Insets(15,15,15,15) );
		grid.setHgap(15);
		grid.setVgap(10);
		grid.setAlignment(Pos.CENTER);
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
			throw new ExcepcionFechas(tipoError);
			
		}else if(fechanuevaEntrada.isAfter(fechanuevaSalida)) {
			tipoError = "Ingrese una fecha de salida superior a la fecha de entrada " + fechanuevaEntrada;
			throw new ExcepcionFechas(tipoError);
		}
	}
	
	public void nulos() throws ExcepcionNulos{
		if((limpiar.get(0).getText() == null) || (limpiar.get(1).getText() == null) || (limpiar.get(2).getText() == null) ) {
			throw new ExcepcionNulos();
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
			Image imagen = new Image(getClass().getResourceAsStream("./Imagenes/images.jpg"), 450, 350, false, false);
			Label label = new Label("", new ImageView(imagen));
			Funcionalidades.principal.getChildren().addAll(label);
		}
	}
	
	// Control de fechas. Una superior a otra.
	class oyenteConfirmar implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent e){						
			try {
				nulos();
			}catch(ExcepcionNulos e3) {
				Alert sinCliente = new Alert(AlertType.ERROR);
				sinCliente.setTitle("Error");
				sinCliente.setHeaderText("Falta que ingreses el campo: ");
				for(int i = 0; i<3; i++) {
					if(limpiar.get(i).getText() == null) {
						sinCliente.setHeaderText(sinCliente.getHeaderText() + "\n * "+ criterios[i+2]);
					}
				}
				sinCliente.setContentText(e3.getMessage());
				Optional<ButtonType> result = sinCliente.showAndWait();
				if (!result.isPresent()) {
					limpiar.get(0).clear();
					limpiar.get(1).clear();
					limpiar.get(2).clear();
					}
				else if (result.get() == ButtonType.OK) {
					limpiar.get(0).clear();
					limpiar.get(1).clear();
					limpiar.get(2).clear();
				}
				return;
			}
			
			try {
				fechas();
				LocalDate fechanuevaEntrada = LocalDate.parse(limpiar.get(0).getText());
				LocalDate fechanuevaSalida = LocalDate.parse(limpiar.get(1).getText());
			} catch (ExcepcionFechas e1) {
				Alert sinCliente = new Alert(AlertType.ERROR);
				sinCliente.setTitle("Error");
				sinCliente.setHeaderText(e1.getError());
				sinCliente.setContentText(e1.getMessage());
				Optional<ButtonType> result = sinCliente.showAndWait();
				if (!result.isPresent()) {
					limpiar.get(0).clear();
					limpiar.get(1).clear();
					limpiar.get(2).clear();
					}
				else if (result.get() == ButtonType.OK) {
					limpiar.get(0).clear();
					limpiar.get(1).clear();
					limpiar.get(2).clear();
				}
				return;
			}catch(DateTimeParseException e2) {
				Alert sinCliente = new Alert(AlertType.ERROR);
				sinCliente.setTitle("Error");
				sinCliente.setHeaderText("Ingrese las fechas en formato yyyy-mm-dd");
				Optional<ButtonType> result = sinCliente.showAndWait();
				if (!result.isPresent()) {
					limpiar.get(0).clear();
					limpiar.get(1).clear();
					limpiar.get(2).clear();
					}
				else if (result.get() == ButtonType.OK) {
					limpiar.get(0).clear();
					limpiar.get(1).clear();
					limpiar.get(2).clear();
				}
				return;
			}
			
			Habitacion habauxiliar = new Habitacion();
			Cliente cliente = null;
			for(Cliente i: Hotel.getClientes()) {
				if(Long.parseLong(valores[0]) == i.getId()) {
					cliente = i;
				}
			}
			cliente.setNumAcompanantes((int) Integer.parseInt(limpiar.get(2).getText()));
			cliente.setFecha_entrada(limpiar.get(0).getText());
			cliente.setFecha_salida(limpiar.get(1).getText());
			
			for (Habitacion i : Hotel.getHabitaciones()) {
				int conta = 0;
				if (i.getTipoCapacidad() == cliente.getNumAcompanantes() + 1) {
					if (conta > 0) {
						if (habauxiliar.getClientes().size() > i.getClientes().size()) {
							habauxiliar = i;
						}
					} else {
						habauxiliar = i;
						conta += 1;
					}
				}
			}
			
			if(habauxiliar.getClientes().size() == 0) {				
				Reserva reserva1 = new Reserva(cliente.getFecha_entrada().toString(), cliente.getFecha_salida().toString(), cliente);
				habauxiliar.setClientes(cliente);
				cliente.setHabitacion(habauxiliar);
				habauxiliar.setDisponibilidadHab(true);
				//Hotel.asignarHabitacion(cliente);
				Alert sinCliente = new Alert(AlertType.INFORMATION);
				sinCliente.setTitle("Información.");
				sinCliente.setHeaderText("Reserva asignada con éxito.");
				sinCliente.setContentText("Se le ha asignado la habitación " + cliente.getHabitacion().getNumhabitacion());
				Optional<ButtonType> result = sinCliente.showAndWait();
				if (!result.isPresent()) {
					limpiar.get(0).clear();
					limpiar.get(1).clear();
					limpiar.get(2).clear();
				}
				else if (result.get() == ButtonType.OK) {
					limpiar.get(0).clear();
					limpiar.get(1).clear();
					limpiar.get(2).clear();
				}
				
				
				return;
			}

			else if (cliente.getFecha_entrada().isAfter(habauxiliar.getClientes().get(habauxiliar.getClientes().size()-1).getFecha_salida())) {
				
				Reserva reserva1 = new Reserva(cliente.getFecha_entrada().toString(), cliente.getFecha_salida().toString(), cliente);
				
				habauxiliar.setClientes(cliente);
				cliente.setHabitacion(habauxiliar);
				habauxiliar.setDisponibilidadHab(false);
				Alert sinCliente = new Alert(AlertType.INFORMATION);
				sinCliente.setTitle("Información.");
				sinCliente.setHeaderText("Reserva asignada con éxito.");
				sinCliente.setContentText("Se le ha asignado la habitación " + cliente.getHabitacion().getNumhabitacion());
				Optional<ButtonType> result = sinCliente.showAndWait();
				if (!result.isPresent()) {
				}
				else if (result.get() == ButtonType.OK) {
					limpiar.get(0).clear();
					limpiar.get(1).clear();
					limpiar.get(2).clear();
				}
			} else {
				Alert adios = new Alert(AlertType.INFORMATION);
				adios.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("./Imagenes/triste.png"),50,50,false,false)));
				adios.setHeaderText("No se encuentran habitaciones disponibles para asignar tu reserva.");
				adios.setContentText("¡Gracias por elegirnos, esperamos tener disponibilidad la próxima ocasión!");
				Optional<ButtonType> result = adios.showAndWait();
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
