package gestorAplicacion.Funcionamiento;

import gestorAplicacion.*;
import java.util.Date;
import java.util.ArrayList;

public class Reserva {
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private  Date fecha_de_ingreso;
	private  Date fecha_de_salida;
	public boolean estado;//para pensar
	public Cliente cliente;
	public Habitacion habitacion;
	
	public Reserva(Date fecha_de_ingreso, Date fecha_de_salida, Cliente cliente) {
		this.fecha_de_ingreso = fecha_de_ingreso;
		this.fecha_de_salida = fecha_de_salida;
		this.cliente = cliente;
	}
	
	/// Setters y getters.
	
	public Date getFecha_de_ingreso() {
		return fecha_de_ingreso;
	}

	public void setFecha_de_ingreso(Date fecha_de_ingreso) {
		this.fecha_de_ingreso = fecha_de_ingreso;
	}

	public Date getFecha_de_salida() {
		return fecha_de_salida;
	}

	public void setFecha_de_salida(Date fecha_de_salida) {
		this.fecha_de_salida = fecha_de_salida;
	}
	
	
	/// Métodos.
	public void reasignar_reserva(Date nueva_fecha_ing, Date nueva_fecha_sal) {
		cliente.setFecha_entrada(nueva_fecha_ing);
		cliente.setFecha_salida(nueva_fecha_sal);
	}

	public void cancelar_reserva(Cliente cliente) {
		cliente.habitacion.setDisponibilidadHab(true);
		Habitacion.habitaciones.add(cliente.habitacion);
		int cap2 =Habitacion.getCapacidad2();
		int cap3 =Habitacion.getCapacidad3();
		int cap4 =Habitacion.getCapacidad4();
		int cap5 =Habitacion.getCapacidad5();
		int totalPersonas = 1 + cliente.getNumAcompanantes();
				
		if((totalPersonas == 1 || totalPersonas == 2) ) {
			Habitacion.setCapacidad2(cap2+1);
		}else if(totalPersonas == 3) {
			Habitacion.setCapacidad3(cap3+1);
		}else if(totalPersonas == 4) {
			Habitacion.setCapacidad4(cap4+1);
		}else if(totalPersonas == 5) {
			Habitacion.setCapacidad5(cap5+1);
		}
		cliente.setReserva(false);
		for(int i=0; i<reservas.size();i++) {
			if (reservas.get(i).cliente.equals(cliente)) {
				reservas.remove(reservas.get(i));
			}
		}
		
	}

}
