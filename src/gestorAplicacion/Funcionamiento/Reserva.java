package gestorAplicacion.Funcionamiento;

import gestorAplicacion.*;

import java.util.Date;

public class Reserva {
	private static Date fecha_de_ingreso;
	private static Date fecha_de_salida;
	public boolean estado;
	public Cliente cliente;
	
	public Reserva(Date ingreso, Date salida, Cliente cliente) {
		this.fecha_de_ingreso = ingreso;
		this.fecha_de_salida = salida;
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
	
	public void reasignar_reserva(Date nueva_fecha_ing, Date nueva_fecha_sal) {
		
	}

	

}
