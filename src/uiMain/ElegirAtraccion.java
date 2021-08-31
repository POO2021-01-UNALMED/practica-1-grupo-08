package uiMain;

import gestorAplicacion.Cliente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import uiMain.ElegirMenu.ElegirM;

public class ElegirAtraccion {
		Label criterio = new Label("Cédula: ");
		TextField campo = new TextField();
		Button enviar = new Button("Enviar");
		GridPane infoCed = new GridPane();

		public ElegirAtraccion() {
			ElegirA oyente = new ElegirA(campo);// Se le ingresa como parámetro el TextField campo(donde se le ingresa la
			// cedula)
			enviar.setOnAction(oyente);
			infoCed.addRow(0, criterio, campo, enviar);
		}

		public GridPane getElegirAtraccion() {
			return infoCed;
		}
		
		class ElegirA implements EventHandler<ActionEvent> {
			TextField campo;
			public ElegirM(TextField c) {
				campo = c;
			}
			
			public void handle(ActionEvent evento) { 
				BuscarCliente oidor = new BuscarCliente(campo);
				oidor.handle();
				Cliente clienteNuevo = oidor.getBuscarCliente();
				if (clienteNuevo == null) {
					return;
				}
				
				
			}
			
			
			
			
		}
			


}
}
