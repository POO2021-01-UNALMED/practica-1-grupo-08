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
		//Se cambi� a que recibiera el cliente tambi�n para poder hacer registro del gasto
		 int valorTotalServicio = 0;
		/* EN RECEPCI�N. 
		 int confirmar; 
		 do {
			 System.out.println("Bienvenido al restaurante, por favor responda �Desea ver la carta vegetariana o tradicional?: \n"
						+ "1. Carta vegetariana. \n" 
					 	+ "2. Carta tradicional.);
			// se lee la opcion.
			 * if(opcion == 1){
			 * 		System.out.println(Carta vegetariana:
			 * 			+ "1. Espirales con setas y verduras. - $15000. \n" 
					 	+ "2. Ensala de esp�rragos y reques�n - $15000. \n"
						+ "3. Lasa�a vegetal - $10000. \n"
					 	+ "4. Alcachofas rellenas de quinoa - $20000. \n"
						+ "5. Hamburguesa vegetariana - $8000. \n);
				}else if(opcion == 2){
						System.out.println(Carta tradicional:
			 			+ "1. Monta�a rusa - $15000. \n" 
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
								 
			//Volver a preguntar si quiere elegir otra atracci�n
			 System.out.println("�Desea elegir otro platillo? Escoja una opci�n: \n"
			 		+ "1. S�. \n"
					+ "2. No. " );
			 // Se lee la elecci�n
			 //se verifica que se un numero del 1 al 8
			  *if(opcion < 0 || opcion > 8){
			  *System.out.println("Valor ingresado inv�lido")
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
		//Se cambi� a que recibiera el cliente tambi�n para poder hacer registro del gasto
		 int valorTotalServicio = 0;
		/* EN RECEPCI�N. 
		 int confirmar; 
		 do {
			 System.out.println("Bienvenido al parque de diversiones, por favor escoja una opci�n: \n"
						+ "1. Monta�a rusa - $15000. \n" 
					 	+ "2. Paseo oscuro - $15000. \n"
						+ "3. Carritos chocones - $10000. \n"
					 	+ "4. Piscina - $20000. \n"
						+ "5. Piscina de pelotas - $8000. \n"
					 	+ "6. Carrusel - $8000. \n"
						+ "7. Bungy - $10000. \n"
						+ "8. Barco pirata - $15000. \n");
				// Se lee un n�mero entero.
			 	// Se llama el m�todo tipoAtraccion y se envia el valor le�do
			 
			//Volver a preguntar si quiere elegir otra atracci�n
			 System.out.println("�Desea elegir otra atracci�n? Escoja una opci�n: \n"
			 		+ "1. S�. \n"
					+ "2. No. " );
			 // Se lee la elecci�n
			 //se verifica que se un numero del 1 al 8
			  *if(opcion < 0 || opcion > 8){
			  *System.out.println("Valor ingresado inv�lido")
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
