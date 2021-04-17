package gestorAplicacion.Funcionamiento;
import java.util.ArrayList;
import gestorAplicacion.Cliente;

public class Servicio {
	public ArrayList<Integer> gastosServicios;
	public 	Cliente cliente;
	
	public Servicio(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public ArrayList<Integer> getGastosServicios() {
		return this.gastosServicios;
	}
	
	
	public int reportarGasto() {
		int reporteGasto = 0;
		return reporteGasto;
	}
	
	void tipoMenu() {
		System.out.println("Bienvenido al menú del restaurante, por favor escoja una opción:\n"
				+ "1.");
		//Se lee un número entero.
		
	}
	
	 void tipoAtraccion(int opcion) {
		 int valorTotalServicio = 0;
		/* EN RECEPCIÓN. 
		 int confirmar; 
		 do {
			 System.out.println("Bienvenido al parque de diversiones, por favor escoja una opción: \n"
						+ "1. Montaña rusa - $15000. \n" 
					 	+ "2. Paseo oscuro - $15000. \n"
						+ "3. Carritos chocones - $10000. \n"
					 	+ "4. Piscina - $20000. \n"
						+ "5. Piscina de pelotas - $8000. \n"
					 	+ "6. Carrusel - $8000. \n"
						+ "7. Bungy - $10000. \n"
						+ "8. Barco pirata - $15000. \n");
				// Se lee un número entero.
			 	// Se llama el método tipoAtraccion y se envia el valor leído
			 
			//Volver a preguntar si quiere elegir otra atracción
			 System.out.println("¿Desea elegir otra atracción? Escoja una opción: \n"
			 		+ "1. Sí. \n"
					+ "2. No. " );
			 // Se lee la elección
			 //se verifica que se un numero del 1 al 8
			  *if(opcion < 0 || opcion > 8){
			  *System.out.println("Valor ingresado inválido")
			 return;
			  *}
		 }while(confirmar == 1);*/
		 
		 	
		 switch (opcion) {
         case 1: 
         	valorTotalServicio = valorTotalServicio + 15000;
         	break;

         case 2: 
        	valorTotalServicio = valorTotalServicio + 15000;
          	break;
 
         case 3:  
        	valorTotalServicio = valorTotalServicio + 10000;
          	break;
         	
         case 4:
        	valorTotalServicio = valorTotalServicio + 20000;
          	break;
         	
         case 5: 
        	valorTotalServicio = valorTotalServicio + 8000;
          	break;
          	
         case 6: 
         	valorTotalServicio = valorTotalServicio + 8000;
           	break; 	
           	
         case 7: 
          	valorTotalServicio = valorTotalServicio + 10000;
            	break; 
            	
         case 8: 
           	valorTotalServicio = valorTotalServicio + 15000;
             	break;   	
         	
		 }
		 
		 
		 
		
	}




}
