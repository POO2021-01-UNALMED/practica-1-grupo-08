package gestorAplicacion.Funcionamiento;
import gestorAplicacion.*;

public class Hotel {
	public Cliente cliente;
	public Habitacion habitacion;
	
	public void asignarHabitacion(Cliente cliente) {
		if (Habitacion.disponibilidad(cliente.getNumAcompaņantes())==true) {//va a disponibilidad con el parametro de num de clientes
			if((cliente.getNumAcompaņantes()+1==1)||(cliente.getNumAcompaņantes()+1==2)) {
				Habitacion.setCapacidad2(Habitacion.getCapacidad2());
				
			}
		} 
		
	}
}
