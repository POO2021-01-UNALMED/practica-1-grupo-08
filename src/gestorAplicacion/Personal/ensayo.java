package gestorAplicacion.Personal;

import java.util.Date;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Habitacion;
import gestorAplicacion.Funcionamiento.Hotel;
import gestorAplicacion.Funcionamiento.Servicio;

public class ensayo {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		Habitacion h1 = new Habitacion(103, 2);
		Mucama m1 = new Mucama("Maria", 243554);
		// System.out.println(m1.getSalario());
		Habitacion.setCapacidad2(9);
		m1.limpiarHabitacion(103);
		System.out.println(Habitacion.getCapacidad2());

	}

}
