package gestorAplicacion.Funcionamiento;
import gestorAplicacion.*;

public class Hotel {
	public Cliente cliente;
	public Habitacion habitacion;
	
	public void asignarHabitacion(Cliente cliente) {
		if (Habitacion.disponibilidad(cliente.getNumAcompa�antes())==true) {//va a disponibilidad con el parametro de num de clientes
			if((cliente.getNumAcompa�antes()+1==1)||(cliente.getNumAcompa�antes()+1==2)) {
				Habitacion.setCapacidad2(Habitacion.getCapacidad2());
				
			}
		} 
		
	}
}
