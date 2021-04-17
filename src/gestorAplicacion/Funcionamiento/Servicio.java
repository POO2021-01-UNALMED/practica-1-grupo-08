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
	
	static void tipoMenu(int opcion, Cliente cliente) {
		//Se cambió a que recibiera el cliente también para poder hacer registro del gasto
		 int valorTotalServicio = 0;
		/* EN RECEPCIÓN. 
		 int confirmar; 
		 do {
			 System.out.println("Bienvenido al restaurante, por favor responda ¿Desea ver la carta vegetariana o tradicional?: \n"
						+ "1. Carta vegetariana. \n" 
					 	+ "2. Carta tradicional.);
			// se lee la opcion.
			 * if(opcion == 1){
			 * 		System.out.println(Carta vegetariana:
			 * 			+ "1. Espirales con setas y verduras. - $15000. \n" 
					 	+ "2. Ensala de espárragos y requesón - $15000. \n"
						+ "3. Lasaña vegetal - $10000. \n"
					 	+ "4. Alcachofas rellenas de quinoa - $20000. \n"
						+ "5. Hamburguesa vegetariana - $8000. \n);
				}else if(opcion == 2){
						System.out.println(Carta tradicional:
			 			+ "1. Montaña rusa - $15000. \n" 
					 	+ "2. Paseo oscuro - $15000. \n"
						+ "3. Carritos chocones - $10000. \n"
					 	+ "4. Piscina - $20000. \n"
						+ "5. Piscina de pelotas - $8000. \n"
					 	+ "6. Carrusel - $8000. \n"
						+ "7. Bungy - $10000. \n"
						+ "8. Barco pirata - $15000. \n");
				}else{
					System.out.println("Valor ingresado incorrecto.");
				}
				leer eleccion y llamar metodo
								 
			//Volver a preguntar si quiere elegir otra atracción
			 System.out.println("¿Desea elegir otro platillo? Escoja una opción: \n"
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
		 
		//cliente.getServicio.getGastosServicios().add(valorTotalServicio);
		 
		
		
	}
	
	static void tipoAtraccion(int opcion, Cliente cliente) {
		//Se cambió a que recibiera el cliente también para poder hacer registro del gasto
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
		 
		//cliente.getServicio.getGastosServicios().add(valorTotalServicio);
		 
		
	}




}
