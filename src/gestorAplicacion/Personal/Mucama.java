package gestorAplicacion.Personal;
import java.util.ArrayList;

import gestorAplicacion.Funcionamiento.*;

public class Mucama extends Empleado {
	private static ArrayList<Mucama> mucamas = new ArrayList<Mucama>();
	//public Hotel hotel;

	public Mucama(String nombre,long id, HorasExtras horasextras, int cantidadHoras) {
		super(nombre,id,"Mucama",horasextras, cantidadHoras);
		asignarSalario();
		super.pagoHorasExtras();
		mucamas.add(this);
	}
	public Mucama(String nombre,long id) {
		super(nombre,id,"Mucama");
		asignarSalario();
		mucamas.add(this);
	}
	public static ArrayList<Mucama> getMucamas() {
		return mucamas;
	}
	public static void setMucamas(ArrayList<Mucama> mucamas) {
		Mucama.mucamas = mucamas;
	}

	@Override
	public void asignarSalario() {
		super.setSalario(915000);
	}
	
	public void asignarHab(Habitacion habitacion) {
		
	}
	
	public void limpiarHabitacion(int num) {
		
		for(int i=0; i< Habitacion.getHabitaciones().size();i++) {
			int cap2 =Habitacion.getCapacidad2();
			int cap3 =Habitacion.getCapacidad3();
			int cap4 =Habitacion.getCapacidad4();
			int cap5 =Habitacion.getCapacidad5();
			if (num==Habitacion.getHabitaciones().get(i).getNumhabitacion()) {
				Habitacion.getHabitaciones().get(i).setDisponibilidadHab(true);//cambio la disponibilidad de la habitacion
				if (Habitacion.getHabitaciones().get(i).getTipoCapacidad()==2) {
					Habitacion.setCapacidad2(cap2+1);	//si la cap es de 2, aumento en habitacion esa capacidad
				    break;
				}else if(Habitacion.getHabitaciones().get(i).getTipoCapacidad()==3) {
					Habitacion.setCapacidad3(cap3+1);
					break ;
				}else if(Habitacion.getHabitaciones().get(i).getTipoCapacidad()==4) {
					Habitacion.setCapacidad4(cap4+1);
					break;
				}else if(Habitacion.getHabitaciones().get(i).getTipoCapacidad()==5) {
					Habitacion.setCapacidad5(cap5+1);
					break;
				}
				
			}
		}
	}    
}
