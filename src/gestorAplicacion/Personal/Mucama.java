package gestorAplicacion.Personal;
import java.util.ArrayList;

import gestorAplicacion.Funcionamiento.*;

public class Mucama extends Empleado {
	private static ArrayList<Mucama> mucamas = new ArrayList<Mucama>();
	//public Hotel hotel;
	private int numHabitacion;
	//private Habitacion habitacion;

	public Mucama(String nombre,long id, HorasExtras horasextras) {
		super(nombre,id,"Mucama",horasextras);
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
	//Hacer prueba :)
	public void limpiarHabitacion(int numHabitacion) {
		for(int i=0; i< Habitacion.getHabitaciones().size();i++) {
			if (this.numHabitacion==Habitacion.getHabitaciones().get(i).getNumhabitacion()) {
				Habitacion.getHabitaciones().get(i).setDisponibilidadHab(true);
				if (Habitacion.getHabitaciones().get(i).getTipoCapacidad()==2) {
					Habitacion.getHabitaciones().get(i).setCapacidad2(Habitacion.getHabitaciones().get(i).getCapacidad2()+1);					
				    break;
				}else if(Habitacion.getHabitaciones().get(i).getTipoCapacidad()==3) {
					Habitacion.getHabitaciones().get(i).setCapacidad3(Habitacion.getHabitaciones().get(i).getCapacidad3()+1);
					break ;
				}else if(Habitacion.getHabitaciones().get(i).getTipoCapacidad()==4) {
					Habitacion.getHabitaciones().get(i).setCapacidad4(Habitacion.getHabitaciones().get(i).getCapacidad4()+1);
					break;
				}else if(Habitacion.getHabitaciones().get(i).getTipoCapacidad()==5) {
					Habitacion.getHabitaciones().get(i).setCapacidad5(Habitacion.getHabitaciones().get(i).getCapacidad5()+1);
					break;
				}
				
			}
		}
	
	}    
}
