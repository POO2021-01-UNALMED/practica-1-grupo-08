package uiMain;

import java.util.ArrayList;

import javafx.scene.control.*;
import javafx.scene.layout.*;

public class FieldPane extends Pane{
	private String tituloCriterios;
	private ArrayList<String> criterios = new ArrayList<String>();
	private String tituloValores;
	private ArrayList<String> valores = new  ArrayList<String>();
	private ArrayList<Boolean> habilitado = new ArrayList<Boolean>(); 
	
	public FieldPane(String tituloCriterios, ArrayList<String> criterios, String tituloValores, ArrayList<String> valores, ArrayList<Boolean> habilitado) {
		this.tituloCriterios = tituloCriterios;	
		this.criterios = criterios;
		this.tituloValores = tituloValores;
		this.valores = valores;
		this.habilitado = habilitado;
		
		GridPane grid = new GridPane();
		Label criterio = new Label("Criterio");
		Label valor = new Label ("Valor"); 
		grid.addRow(0,criterio, valor);
		
		for(int i = 0; i<criterios.size(); i++) {
			Label label = new Label(criterios.get(i));
			TextField tx  = new TextField(valores.get(i));
			if(!habilitado.get(i)){
				tx.setDisable(false);
				grid.addRow(i+1, label, tx);	
			}else {
			grid.addRow(i+1, label, tx);}	
		}
			
		Button aceptar = new Button("Aceptar");
		Button borrar = new Button("Borrar");
		grid.addRow(grid.getRowCount()+1, aceptar, borrar);
	}
	
	public String getValue(String criterio) {
		String aux = null;
		for(int i = 0; i< criterios.size(); i++) {
			if(criterios.get(i).equals(criterio)) {
				aux = valores.get(i);				
			} 
		}
		return aux; //Crear excepción si retorna un null
		}
	
	
	
}
