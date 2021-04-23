package gestorAplicacion.Funcionamiento;

import uiMain.*;
import java.lang.Math.*;
import gestorAplicacion.*;
import gestorAplicacion.Personal.Empleado;
import gestorAplicacion.Personal.Mucama;

public class Hotel {
	public Cliente cliente;
	public Habitacion habitacion;
	public Reserva reserva;
	public Empleado empleado;
	
	public Hotel() {
		
	}
	
	// habitaciones con capacidad dos[[103,104,105,106,107],[103,104,105,106,107]]
	// si la habitacion es asignada cambiar disponibilidad
	public void asignarHabitacion(Cliente cliente) {
		int cap2 =Habitacion.getCapacidad2();
		int cap3 =Habitacion.getCapacidad3();
		int cap4 =Habitacion.getCapacidad4();
		int cap5 =Habitacion.getCapacidad5();
		if (Habitacion.disponibilidad(cliente.getNumAcompanantes())==true) {//va a disponibilidad con el parametro de num de clientes
			if((cliente.getNumAcompanantes()+1==1)||(cliente.getNumAcompanantes()+1==2)) {				
				Habitacion.setCapacidad2(cap2-1);
				
			}else if ((cliente.getNumAcompanantes()+1==3)) {
				Habitacion.setCapacidad3(cap3-1);
				
			}else if ((cliente.getNumAcompanantes()+1==4)) {
				Habitacion.setCapacidad4(cap4-1);
				
		    }else if ((cliente.getNumAcompanantes()+1==5)) {
				Habitacion.setCapacidad5(cap5-1);
			}  
		for(int i=0; i< Habitacion.getHabitaciones().size();i++) {
			if(Habitacion.getHabitaciones().get(i).getTipoCapacidad()==cliente.getNumAcompanantes()+1) {
				cliente.setHabitacion(Habitacion.getHabitaciones().get(i));
				Habitacion.getHabitaciones().get(i).setCliente(cliente);
				Habitacion.getHabitaciones().get(i).disponibilidadHab=false;	
				break;
			}	
		}
		return;	
		}
		
		//¿desea hacer reserva? !!!!!
		
       Reserva reserva = new Reserva(cliente.getFecha_entrada(),cliente.getFecha_salida(), cliente);
	
	}

	
	public void descuentoFamiliar(Cliente cliente) {
		if(cliente.isParentescoEmpleado()==true) {
			for(int i =0; i<Empleado.getEmpleados().size(); i++) {
				if(Empleado.getEmpleados().get(i).getId() == cliente.getIdFamiliar()) {
					int descuento =cliente.getServicio().getGastosServicios() - 40000;
					cliente.getServicio().setGastosServicios(descuento);
					break;
				}
				
			}
			
		}
		return;
	}
	
	public void descuentoPorConsumo(Cliente cliente) {
		if(cliente.getServicio().getGastosServicios() > 150000) {
			int gasto = cliente.getServicio().getGastosServicios();
			int porcentaje = (gasto - (int)((gasto*0.12)));
			cliente.getServicio().setGastosServicios(porcentaje);
		
		}
	}
	//Probar
	public void cobrarDeudas(Cliente cliente) {
		Recepcion.hotel.descuentoPorConsumo(cliente);
		Recepcion.hotel.descuentoFamiliar(cliente);
		int preciofin = cliente.getHabitacion().getPrecio();
		int gastoser = cliente.getServicio().getGastosServicios();
		cliente.setCuentaFinal(gastoser+preciofin);
		int nuevosaldo = cliente.getSaldo()-cliente.getCuentaFinal();
		cliente.setSaldo(nuevosaldo);
		int rd=(int)(Math.random()*(Mucama.getMucamas().size()+1));
		Mucama.getMucamas().get(rd).limpiarHabitacion(cliente.getHabitacion().getNumhabitacion());//Asignación de mucama
		cliente.getHabitacion().setCliente(null);
		cliente.setHabitacion(null);		
	}
	
	public int gananciaNeta() {
		int total=0;
		for(Cliente i: Cliente.clientes) {
			total += i.getCuentaFinal();
		}
		int salario = Recepcion.ad1.pagarSalario();
		return total-salario;
	}
}