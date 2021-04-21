package gestorAplicacion.Personal;

import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.Hotel;
import gestorAplicacion.Funcionamiento.Servicio;

public class Prueba {

	public static void main(String[] args) {
		Cliente c1 = new Cliente("luis", 4874, "21/04/2021", "25/04/2021", 300000, 87574);
		Empleado e1 = new Empleado("Veronica",87574,"ayudante");
		c1.setParentescoEmpleado(true);

		Servicio s1 = new Servicio(c1);
		c1.setServicio(s1);

		Hotel hotel = new Hotel();
		System.out.println(c1.getFecha_entrada());
		c1.getServicio().setGastosServicios(200000);
		hotel.descuentoPorConsumo(c1);
		System.out.println(c1.getServicio().getGastosServicios());
		hotel.descuentoFamiliar(c1);
		System.out.println(c1.getServicio().getGastosServicios());
		
		
		

		

	}

}
