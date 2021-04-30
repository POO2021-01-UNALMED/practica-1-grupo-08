package uiMain;

import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import baseDatos.Serializacion;
import gestorAplicacion.*;
import gestorAplicacion.Funcionamiento.*;
import gestorAplicacion.Personal.*;

public class Recepcion {
	public static Administrador ad1 = new Administrador("Luis", 134344);
	public static Hotel hotel = new Hotel();

	static Scanner sc = new Scanner(System.in);

	static long readLong() {
		return sc.nextLong();
	}

	static String readIn() {
		// sc.nextLine();
		return sc.nextLine();

	}

	public static DateTimeFormatter convertidor = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		int opcion;

		Cliente cliente1 = new Cliente("Nora", 21345687, "27/05/2021", "03/06/2021", 2, 15000000, 1000656556);
		Cliente cliente2 = new Cliente("Fabio", 21356780, "02/06/2021", "06/06/2021", 3, 20000000);
		Cliente cliente3 = new Cliente("Yesenia", 21724520, "03/06/2021", "15/06/2021", 4, 25000000);
		Cliente cliente4 = new Cliente("Wilmar", 15670834, "28/05/2020", "07/06/2001", 4, 35000000, 4567234); ///// Solo
																												///// se
																												///// registra
																												///// el
																												///// cliente
																												///// titular.
		Cliente cliente5 = new Cliente("Sofía", 4321689, "07/07/2020", "20/07/2020", 2, 15600000, 115467300);

		Habitacion hab1 = new Habitacion(103, 2);
		Habitacion hab2 = new Habitacion(202, 4);
		Habitacion hab3 = new Habitacion(101, 3);
		Habitacion hab4 = new Habitacion(303, 5);
		Habitacion hab5 = new Habitacion(205, 4);

		do {
			System.out.println("Bienvenidos al hotel, ¿qué acción desea realizar ahora?");
			System.out.println("1. Tomar una habitación");
			System.out.println("2. Hacer una reserva");
			// cancelar reserva
			System.out.println("3. Elegir menú del restaurante");
			System.out.println("4. Elegir atracción");
			System.out.println("5. Mostrar ganancias netas");
			System.out.println("6. Dar salida a un cliente");
			System.out.println("7. Mostrar lista de clientes que se encuentren en el hotel");
			System.out.println("8. Terminar");
			System.out.println("Teclee su opción: ");
			opcion = (int) readLong();

			switch (opcion) {
			case 1:
				tomarHabitacion();
				break;
			case 2:
				hacerReserva();
				break;
			case 3:
				elegirMenu();
				break;
			case 4:
				elegirAtraccion();
				break; //// Poner terminar///
			case 5:
				gananciasNetas();
				break;
			case 6:
				salidaCliente();
				break;
			case 7:
				mostrarClientes();
				break;
			// AQUÍ//
			case 8:
				salirDelsistema();
				break;
			}
		} while (opcion != 8);
	}

	static void tomarHabitacion() {
		System.out.println("Ingrese C.C. del cliente: ");
		long cedula = readLong();
		Cliente clientenuevo = buscarCliente(cedula);
		hotel.asignarHabitacion(clientenuevo); // ¿Si no encuentra habitación?
		if (clientenuevo.getHabitacion().equals(null)) {
			System.out.println("¿Desea hacer una reserva?");
			String res = readIn();// Debe responder si o no y sin tilde
			String cadenaNormalize = Normalizer.normalize(res.toLowerCase(), Normalizer.Form.NFD);
			String respuesta = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
			if (respuesta.equals("si")) {
				String nueva_fecha_in = clientenuevo.getFecha_entrada();
				LocalDate nueva = LocalDate.parse(nueva_fecha_in, convertidor);
				nueva.plusDays(10);
				clientenuevo.setFecha_entrada(nueva.toString());
				String nueva_fecha_s = clientenuevo.getFecha_salida();
				LocalDate nueva_s = LocalDate.parse(nueva_fecha_s, convertidor);
				nueva_s.plusDays(10);
				clientenuevo.setFecha_salida(nueva_s.toString());
				// AQUÍ//
				System.out.println("Se buscará una habitación para reservar del " + clientenuevo.getFecha_entrada()
						+ " al " + clientenuevo.getFecha_salida());
				hacerReserva();
			} else if (respuesta.equals("no")) {
				hotel.clientes.remove(clientenuevo);
			}
		}

	}

	static void hacerReserva() {
		System.out.println("Ingrese C.C. del cliente: ");
		long cedula = readLong();// Desde el momento que se hace una reserva la habitacion queda ocupada
		Cliente clientenuevo = buscarCliente(cedula);
		Reserva reserva1 = new Reserva(clientenuevo.getFecha_entrada(), clientenuevo.getFecha_salida(), clientenuevo);
		if (clientenuevo.getHabitacion().equals(null)) {
			System.out.println("¿Desea reasignar o cancelar la reserva?");
			String res = readIn();// Debe reasignar o cancelar
			String cadenaNormalize = Normalizer.normalize(res.toLowerCase(), Normalizer.Form.NFD);
			String respuesta = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

			if (respuesta.equals("reasignar")) {
				System.out.println("Ingrese su nueva fecha de ingreso en formato dd/mm/yyyy: ");
				String fecha = readIn();
				LocalDate fecha_nueva = LocalDate.parse(fecha, convertidor);
				System.out.println("Ingrese su nueva fecha de salida en formato dd/mm/yyyy: ");
				String fecha_s = readIn();
				LocalDate fecha_nueva_salida = LocalDate.parse(fecha_s, convertidor);
				reserva1.reasignar_reserva(fecha_nueva.toString(), fecha_nueva_salida.toString());
			} else if (respuesta.equals("cancelar")) {
				System.out.println("¡Gracias por elegirnos, esperamos tener disponibilidad para ti la próxima vez!");
				hotel.clientes.remove(clientenuevo);
			}
		}
		clientenuevo.setReserva(true);
		reserva1.setCliente(clientenuevo);
	}

	static void elegirMenu() {
		System.out.println("BIENVENIDO AL RESTAURANTE.");
		System.out.println("Ingrese C.C. del cliente: ");
		long cedula = readLong();
		Cliente cliente = buscarCliente(cedula);

		String respFinal;
		do {
			System.out.println(
					"¿Desea ver la carta vegetariana o tradicional? Por favor, digite el número correspondiente."
							+ "1. Carta vegetariana. \n" + "2. Carta tradicional.");

			int opcionCarta = (int) readLong();
			if (opcionCarta == 1) {
				System.out.println("Carta vegetariana: \n" + "1. Espirales con setas y verduras. - $20000. \n"
						+ "2. Ensala de espárragos y requesón - $18000. \n" + "3. Lasaña vegetal - $15000. \n"
						+ "4. Alcachofas rellenas de quinoa - $22000. \n" + "5. Hamburguesa vegetariana - $15000. \n");
			} else if (opcionCarta == 2) {
				System.out.println("Carta tradicional: \n" + "1. Alitas orientales - $15000. \n"
						+ "2. Arroz atollado - $18000. \n" + "3. Bandeja paisa - $25000. \n"
						+ "4. Crema de champiñones - $15000. \n" + "5. Hígado encebollado - $20000.");
			} else {
				System.out.println("Dígito ingresado incorrecto.");
				return;
			}

			System.out.println("Digite el número que le corrresponde al platillo que desea.");
			int eleccion = (int) readLong();
			if (eleccion <= 0 || eleccion > 5) {
				System.out.println("Dígito ingresado inválido");
				return;
			}
			Servicio.tipoMenu(opcionCarta, eleccion, cliente);
			System.out.println("¿Desea elegir otro platillo?");
			String respSalir = readIn();
			String cadenaNormalize = Normalizer.normalize(respSalir.toLowerCase(), Normalizer.Form.NFD);
			respFinal = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
		} while (respFinal.equals("si"));
		System.out.println("¡Buen provecho!");
	}

	static void elegirAtraccion() {
		System.out.println("BIENVENIDO AL PARQUE DE DIVERSIONES.");
		System.out.println("Ingrese C.C. del cliente: ");
		long cedula = readLong();
		Cliente cliente = buscarCliente(cedula);

		String respFinal;
		do {
			System.out.println("Por favor, digite el número correspondiente a la atracción que desea."
					+ "1. Montaña rusa - $15000. \n" + "2. Paseo oscuro - $15000. \n"
					+ "3. Carritos chocones - $10000. \n" + "4. Piscina - $20000. \n"
					+ "5. Piscina de pelotas - $8000. \n" + "6. Carrusel - $8000. \n" + "7. Bungy - $10000. \n"
					+ "8. Barco pirata - $15000.");

			int eleccion = (int) readLong();
			if (eleccion <= 0 || eleccion > 8) {
				System.out.println("Dígito ingresado inválido");
				return;
			}
			Servicio.tipoAtraccion(eleccion, cliente);
			System.out.println("¿Desea elegir otra atracción?");
			String respSalir = readIn();
			String cadenaNormalize = Normalizer.normalize(respSalir.toLowerCase(), Normalizer.Form.NFD);
			respFinal = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
		} while (respFinal.equals("si"));
		System.out.println("¡Disfrute del juego!");
	}

	public static void gananciasNetas() {
		System.out.println("Las ganancias netas del hotel hasta el momento son iguales a: " + hotel.gananciaNeta());
	}

	public static void salidaCliente() {
		System.out.println("Ingrese C.C. del cliente para dar salida: ");
		long cedula = readLong();
		Cliente clientesalida = buscarCliente(cedula);
		clientesalida.getHabitacion().setDisponibilidadHab(true);
		System.out.println("¡Gracias por visitarnos, vuelva pronto!");
		hotel.clientes.remove(clientesalida);
	}

	public static void mostrarClientes() {
		for (Cliente i : hotel.getClientes()) {
			if (i.isReserva() == true) {
			} else {
				System.out.println(i);
			}
		}
	}

	// Metodos de busqueda
	public static Cliente buscarCliente(long cedula) {
		Cliente uno = null;
		for (Cliente i : hotel.clientes) {
			if (cedula == i.getId()) {
				uno = i;
				break;
			} else {
				System.out.println("Cliente no encontrado, ingrese una nueva cédula: ");
				long c1 = readLong();
				buscarCliente(c1);
			}
			break;
		}
		return uno;
	}
	// Método

	private static void salirDelsistema() {
		System.out.println("¡Vuelva pronto!");
		Serializacion.serializacion(hotel);
		System.exit(0);
	}

}
