package uiMain;


import javafx.scene.control.*;
import javafx.scene.layout.*;

public class FieldPane extends Pane{
	private String tituloCriterios;
	private String[] criterios;
	private String tituloValores;
	private String[] valores;
	private Boolean[] habilitado; 
	
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
			grid.addRow(i+1, label, tx);}	
		}
			
		Button aceptar = new Button("Aceptar");
		Button borrar = new Button("Borrar");
		grid.addRow(grid.getRowCount()+1, aceptar, borrar);
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
	
	
	
}
