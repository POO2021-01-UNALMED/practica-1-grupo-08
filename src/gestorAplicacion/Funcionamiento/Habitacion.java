package gestorAplicacion.Funcionamiento;
import gestorAplicacion.Cliente;

public class Habitacion {
	public int numHabitacion;
	public boolean disponibilidad;
	private static int capacidad2 = 10;
	private static int capacidad3 = 10;
	private static int capacidad4 = 10;
	private static int capacidad5 = 10;
	private Cliente cliente;
	private Reserva reserva;

	
	public Habitacion(int numHabitacion){
		this.numHabitacion = numHabitacion;
		this.disponibilidad = true;
	}
	
	
	public void setNumHabitacion(int num) {
		this.numHabitacion = num;
	}
	
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	public void setCapacidad2(int capacidad2) {
		Habitacion.capacidad2 = capacidad2;
	}
	
	public void setCapacidad3(int capacidad3) {
		Habitacion.capacidad3 = capacidad3;
	}
	
	public void setCapacidad4(int capacidad4) {
		Habitacion.capacidad4 = capacidad4;
	}
	
	public void setCapacidad5(int capacidad5) {
		Habitacion.capacidad5 = capacidad5;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
	
	public int getNumhabitacion() {
		return this.numHabitacion;
		
	}
	
	public boolean getDisponibilidad() {
		return this.disponibilidad;
		
	}
	
	public static int getCapacidad2() {
		return capacidad2;
	}
	
	public static int getCapacidad3() {
		return capacidad3;
	}
	
	public static int getCapacidad4() {
		return capacidad4;
	}
	
	public static int getCapacidad5() {
		return capacidad5;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public Reserva getReserva() {
		return this.reserva;
	}


	public static boolean disponibilidad(int numAcompanantes) {
		//validar que todas las cantidades sean positivas. ¿static?
		// Validar el número de acompañantes ¿Desde el constructor?
		int totalPersonas = 1 + numAcompanantes;
		boolean confirmacion = true;
				
		if((totalPersonas == 1 | totalPersonas == 2) && capacidad2 == 0) {
			confirmacion = false;
		}else if(totalPersonas == 3 && capacidad3 == 0) {
			confirmacion = false;
		}else if(totalPersonas == 4 && capacidad4 == 0) {
			confirmacion = false;
		}else if(totalPersonas == 5 && capacidad5 == 0) {
			confirmacion = false;
		}
		
		return confirmacion;
		
		/*Aqui boolean confirmacion = false;
		 * switch (totalPersonas) {
            case 1: 
            	if(capacidad2 > 0) {
            		confirmacion = true;
            	}
            	return confirmacion;
		case 2: 
            	if(capacidad2 > 0) {
            		confirmacion = true;
            	}
            	return confirmacion;
            	
            case 3:  
            	if(capacidad3 > 0) {
            		confirmacion = true;
            	}
            	return confirmacion;
            	
            case 4:
            	if(capacidad4 > 0) {
            		confirmacion = true;
            	}
            	return confirmacion;
            	
            case 5: 
            	if(capacidad5 > 0) {
            		confirmacion = true;
            	}
            	return confirmacion;
            	
            default: 
            	return confirmacion;
        }*/
		
		
	}





}
