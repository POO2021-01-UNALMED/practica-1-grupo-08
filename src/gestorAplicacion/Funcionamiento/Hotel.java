package gestorAplicacion.Funcionamiento;
import gestorAplicacion.*;

public class Hotel {
	public Cliente cliente;
	public Habitacion habitacion;
	
	// habitaciones con capacidad dos[[103,104,105,106,107],[103,104,105,106,107]]
	public void asignarHabitacion(Cliente cliente) {
		int cap2 =Habitacion.getCapacidad2();
		int cap3 =Habitacion.getCapacidad3();
		int cap4 =Habitacion.getCapacidad4();
		int cap5 =Habitacion.getCapacidad5();
		if (Habitacion.disponibilidad(cliente.getNumAcompa�antes())==true) {//va a disponibilidad con el parametro de num de clientes
			if((cliente.getNumAcompa�antes()+1==1)||(cliente.getNumAcompa�antes()+1==2)) {				
				Habitacion.setCapacidad2(cap2-1);
				
			}else if ((cliente.getNumAcompa�antes()+1==3)) {
				Habitacion.setCapacidad3(cap3-1);
				
			}else if ((cliente.getNumAcompa�antes()+1==4)) {
				Habitacion.setCapacidad4(cap4-1);
				
		    }else if ((cliente.getNumAcompa�antes()+1==5)) {
				Habitacion.setCapacidad5(cap5-1);
			}  
		for(int i=0; i< Habitacion.habitaciones.size();i++) {
			if(Habitacion.habitaciones.get(i).getTipoCapacidad()==cliente.getNumAcompa�antes()+1) {
				cliente.setHabitacion(Habitacion.habitaciones.get(i));
				Habitacion.habitaciones.get(i).setCliente(cliente);	
			}			
		}
		return;	
		}
		
		//�desea hacer reserva?
		
	
	}

}