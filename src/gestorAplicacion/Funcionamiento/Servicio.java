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
		System.out.println("Bienvenido al men� del restaurante, por favor escoja una opci�n:\n"
				+ "1.");
		//Se lee un n�mero entero.
		
	}
	
	 void tipoAtraccion(int opcion) {
		 int valorTotalServicio = 0;
		/* EN RECEPCI�N. 
		 int confirmar; 
		 do {
			 System.out.println("Bienvenido al parque de diversiones, por favor escoja una opci�n: \n"
						+ "1. Monta�a rusa. \n" 
					 	+ "2. Paseo oscuro. \n"
						+ "3. Carritos chocones. \n"
					 	+ "4. Piscina. \n"
						+ "5. Piscina de pelotas. \n"
					 	+ "6. Carrusel. \n"
						+ "7. Bungy. \n"
						+ "8. Barco pirata. \n");
				// Se lee un n�mero entero.
			 	// Se llama el m�todo tipoAtraccion y se envia el valor le�do
			 
			//Volver a preguntar si quiere elegir otra atracci�n
			 System.out.println("�Desea elegir otra atracci�n? Escoja una opci�n: \n"
			 		+ "1. S�. \n"
					+ "2. No. " );
			 // Se lee la elecci�n
		 }while(confirmar == 1);*/
		 
		 	
		 switch (opcion) {
         case 1: 
         	valorTotalServicio = valorTotalServicio + 12000;
         	break;

         case 2: 
        	 valorTotalServicio = 12000;
          	break;
 
         case 3:  
         	if(capacidad3 > 0) {
         		confirmacion = true;
         	}
         	break;
         	
         case 4:
         	if(capacidad4 > 0) {
         		confirmacion = true;
         	}
         	break;
         	
         case 5: 
         	if(capacidad5 > 0) {
         		confirmacion = true;
         	}
         	break;
         	//default
		 }
		 
		 
		 
		
	}




}
