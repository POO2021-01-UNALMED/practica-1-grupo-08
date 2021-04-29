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
	
	
	public static void tipoMenu(int opcionCarta,int eleccion, Cliente cliente) {
		 int valorTotalServicio = 0;

		 if(opcionCarta == 1) {
			 switch (eleccion) {
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
			 }    	
		 }else if(opcionCarta == 2) {
			 switch (eleccion) {
			 case 1: 
		        	valorTotalServicio = valorTotalServicio + 15000;
		        	cliente.getServicio().gastosAcumulados(valorTotalServicio);
		          	break; 	
		          	
		        case 2: 
		         	valorTotalServicio = valorTotalServicio + 18000;
		         	cliente.getServicio().gastosAcumulados(valorTotalServicio);
		           	break; 
		           	
		        case 3: 
		          	valorTotalServicio = valorTotalServicio + 25000;
		          	cliente.getServicio().gastosAcumulados(valorTotalServicio);
		            	break;  
		        case 4: 
		          	valorTotalServicio = valorTotalServicio + 15000;
		          	cliente.getServicio().gastosAcumulados(valorTotalServicio);
		            	break;
		        case 5: 
		          	valorTotalServicio = valorTotalServicio + 20000;
		          	cliente.getServicio().gastosAcumulados(valorTotalServicio);
		            	break;      
			 }
		 }	
	}
	
	public static void tipoAtraccion(int eleccion, Cliente cliente) {
		 int valorTotalServicio = 0;
			 	
		 switch (eleccion) {
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
