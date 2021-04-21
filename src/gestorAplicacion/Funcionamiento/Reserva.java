package gestorAplicacion.Funcionamiento;

import gestorAplicacion.*;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Reserva {
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private  LocalDate fecha_de_ingreso;
	private  LocalDate fecha_de_salida;
	public boolean estado;//para pensar
	public Cliente cliente;
	public Habitacion habitacion;
	public static DateTimeFormatter convertidor = DateTimeFormatter.ofPattern("DD/MM/YYYY"); 
	
	public Reserva(String fecha_de_ingreso, String fecha_de_salida, Cliente cliente) {
		LocalDate fecha_ingresar = LocalDate.parse(fecha_de_ingreso,convertidor);
		this.fecha_de_ingreso= fecha_ingresar;
		LocalDate fecha_salir = LocalDate.parse(fecha_de_salida,convertidor);
		this.fecha_de_salida= fecha_salir;
		this.cliente = cliente;
	}
	
	/// Setters y getters.
	
	public LocalDate getFecha_de_ingreso() {
		return fecha_de_ingreso;
	}

	public void setFecha_de_ingreso(String fecha_de_ingreso) {
		LocalDate fecha_ingresar = LocalDate.parse(fecha_de_ingreso,convertidor);
		this.fecha_de_ingreso= fecha_ingresar;
	}

	public LocalDate getFecha_de_salida() {
		return fecha_de_salida;
	}

	public void setFecha_de_salida(String fecha_de_salida) {
		LocalDate fecha_salir = LocalDate.parse(fecha_de_salida,convertidor);
		this.fecha_de_ingreso= fecha_salir;
	}
	
	
	/// Métodos.
	public void reasignar_reserva(String nueva_fecha_ing, String nueva_fecha_sal) {
		cliente.setFecha_entrada(nueva_fecha_ing);
		cliente.setFecha_salida(nueva_fecha_sal);
	}

	public void cancelar_reserva(Cliente cliente) {
		cliente.habitacion.setDisponibilidadHab(true);
		Habitacion.getHabitaciones().add(cliente.habitacion);
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
