package gestorAplicacion.Funcionamiento;
import java.io.Serializable;

import gestorAplicacion.Cliente;

public class Servicio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int gastosServicios;
	private	Cliente cliente;
	
	public Servicio(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setGastosServicios(int valorGasto) {
		this.gastosServicios = valorGasto;
	}
	
	public int getGastosServicios() {
		return this.gastosServicios;
	}
	

	public  void gastosAcumulados(int valorTotalServicio) {
		this.gastosServicios =+ valorTotalServicio;
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
			 * 			+ "1. Espirales con setas y verduras. - $20000. \n" 
					 	+ "2. Ensala de espárragos y requesón - $18000. \n"
						+ "3. Lasaña vegetal - $15000. \n"
					 	+ "4. Alcachofas rellenas de quinoa - $22000. \n"
						+ "5. Hamburguesa vegetariana - $15000. \n);
				}else if(opcion == 2){
						System.out.println(Carta tradicional:
			 			+ "6. Alitas orientales - $15000. \n" 
					 	+ "7. Arroz atollado - $18000. \n"
						+ "8. Bandeja paisa - $25000. \n"
					 	+ "9. Crema de champiñones - $15000. \n"
						+ "10. Hígado encebollado - $20000.);
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
        	valorTotalServicio = valorTotalServicio + 20000;
        	cliente.getServicio().gastosAcumulados(valorTotalServicio);
        	break;

        case 2: 
       	valorTotalServicio = valorTotalServicio + 18000;
       	cliente.getServicio().gastosAcumulados(valorTotalServicio);
         	break;

        case 3:  
       	valorTotalServicio = valorTotalServicio + 15000;
       	cliente.getServicio().gastosAcumulados(valorTotalServicio);
         	break;
        	
        case 4:
       	valorTotalServicio = valorTotalServicio + 22000;
       	cliente.getServicio().gastosAcumulados(valorTotalServicio);
         	break;
        	
        case 5: 
       	valorTotalServicio = valorTotalServicio + 15000;
       	cliente.getServicio().gastosAcumulados(valorTotalServicio);
         	break;
         	
        case 6: 
        	valorTotalServicio = valorTotalServicio + 15000;
        	cliente.getServicio().gastosAcumulados(valorTotalServicio);
          	break; 	
          	
        case 7: 
         	valorTotalServicio = valorTotalServicio + 18000;
         	cliente.getServicio().gastosAcumulados(valorTotalServicio);
           	break; 
           	
        case 8: 
          	valorTotalServicio = valorTotalServicio + 25000;
          	cliente.getServicio().gastosAcumulados(valorTotalServicio);
            	break;  
        case 9: 
          	valorTotalServicio = valorTotalServicio + 15000;
          	cliente.getServicio().gastosAcumulados(valorTotalServicio);
            	break;
        case 10: 
          	valorTotalServicio = valorTotalServicio + 20000;
          	cliente.getServicio().gastosAcumulados(valorTotalServicio);
            	break;      	
        	
		 }
		 
				
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
         	cliente.getServicio().gastosAcumulados(valorTotalServicio);
         	break;

         case 2: 
        	valorTotalServicio = valorTotalServicio + 15000;
        	cliente.getServicio().gastosAcumulados(valorTotalServicio);
          	break;
 
         case 3:  
        	valorTotalServicio = valorTotalServicio + 10000;
        	cliente.getServicio().gastosAcumulados(valorTotalServicio);
          	break;
         	
         case 4:
        	valorTotalServicio = valorTotalServicio + 20000;
        	cliente.getServicio().gastosAcumulados(valorTotalServicio);
          	break;
         	
         case 5: 
        	valorTotalServicio = valorTotalServicio + 8000;
        	cliente.getServicio().gastosAcumulados(valorTotalServicio);
          	break;
          	
         case 6: 
         	valorTotalServicio = valorTotalServicio + 8000;
         	cliente.getServicio().gastosAcumulados(valorTotalServicio);
           	break; 	
           	
         case 7: 
          	valorTotalServicio = valorTotalServicio + 10000;
          	cliente.getServicio().gastosAcumulados(valorTotalServicio);
            	break; 
            	
         case 8: 
           	valorTotalServicio = valorTotalServicio + 15000;
           	cliente.getServicio().gastosAcumulados(valorTotalServicio);
             	break;   	
         	
		 }
		 
		
	}




}
