package uiMain;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import baseDatos.*;
import baseDatos.Serializacion;
import gestorAplicacion.*;
import gestorAplicacion.Funcionamiento.*;
import gestorAplicacion.Personal.*;

public class Recepcion {
	private static Hotel hotel = new Hotel();
	private static Administrador ad1 = new Administrador("Julián", 134344);
		
	static Scanner sc = new Scanner(System.in);

	static long readLong() {
		return sc.nextLong();
	}

	static String readIn() {
		sc.nextLine();
		return sc.nextLine();
	}
		
	public static void main(String[] args) {
		int opcion;
		Deserializacion.deserializar(hotel);
		Habitacion.aumentarCapacidad();

		/*Cliente cliente1 = new Cliente("Ana", 38836489, "2021-01-05","2021-01-15", 0, 9000000);
		Cliente cliente2 = new Cliente("Fabio", 21356780, "2021-06-02", "2021-06-06", 3, 20000000);
		Cliente cliente3 = new Cliente("Yesenia", 21724520, "2021-06-03", "2021-06-15", 4, 25000000);
		Cliente cliente4 = new Cliente("Manuel", 15670834, "2021-05-28", "2021-06-07", 4, 35000000, 4567234);
		Cliente cliente5 = new Cliente("Sofía", 4321689, "2021-03-07", "2021-03-20", 2, 15600000, 115467300);
		Cliente cliente6 = new Cliente("Ximena", 49759459, "2021-02-10", "2021-02-20", 3, 14300000, 9890773);
		Cliente cliente7 = new Cliente("Yojan", 10493043, "2021-07-07", "2021-07-20", 1, 10000000, 48374574);
		Cliente cliente8 = new Cliente("Verónica", 1007253340, "2021-02-21", "2021-03-06", 4, 17600000);
        
		Habitacion hab1 = new Habitacion(103, 2);
		Habitacion hab2 = new Habitacion(202, 4);
        Habitacion hab3 = new Habitacion(101, 5);
		Habitacion hab4 = new Habitacion(303, 5);
		Habitacion hab5 = new Habitacion(205, 4);
		Habitacion hab6 = new Habitacion(217, 3);
		Habitacion hab7 = new Habitacion(402, 2);

		Empleado emp1 = new OficiosVarios("Luis", 2489364,"vigilante", HorasExtras.DIURNA, 10);
		Empleado emp2 = new Mucama("Karla", 3544565, HorasExtras.DIURNADOMINICAL, 9);
		Empleado emp3 = new OficiosVarios("Mario", 10595906,"Recepcionista");
        Empleado emp4 = new Mucama("Yaneth", 4375434);
		Empleado emp5 = new OficiosVarios("Raúl", 158394934, "Bartender", HorasExtras.NOCTURNA, 15);
		Empleado emp6 = new OficiosVarios("Giussepe", 16890495, "CHEF",HorasExtras.NOCTURNADOMINICAL, 5);
        Mucama muc1 = new Mucama("Camila",1023456789,HorasExtras.DIURNADOMINICAL,4);
		Mucama muc2 = new Mucama("Camila",102344333,HorasExtras.NOCTURNA,2);
		
		Servicio ser1 = new Servicio(cliente1);
		Servicio ser2 = new Servicio(cliente2);
		Servicio ser3 = new Servicio(cliente3);
		Servicio ser4 = new Servicio(cliente4);
		Servicio ser5 = new Servicio(cliente5);
		Servicio ser6 = new Servicio(cliente6);
		Servicio ser7 = new Servicio(cliente7);
		Servicio ser8 = new Servicio(cliente8);*/
		
		do {
			System.out.println("\nBienvenidos al hotel, ¿qué acción desea realizar ahora?");
			System.out.println("1. Tomar una habitación");
			System.out.println("2. Cancelar una reserva");
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
				cancelarReserva();
				break;
			case 3:
				elegirMenu();
				break;
			case 4:
				elegirAtraccion();
				break; 
			case 5:
				gananciasNetas();
				break;
			case 6:
				salidaCliente();
				break;
			case 7:
				mostrarClientes();
				break;
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
		if (clientenuevo.getHabitacion() !=null) {
			System.out.println("La habitación con el número " + clientenuevo.getHabitacion().getNumhabitacion() + " ya le ha sido asignada");
		    return;
		}
		hotel.asignarHabitacion(clientenuevo); // ¿Si no encuentra habitación?
		if (clientenuevo.getHabitacion() == null) {
			System.out.println("No hay habitaciones disponibles,¿desea hacer una reserva?");
			String res = readIn();// Debe responder si o no y sin tilde
			String cadenaNormalize = Normalizer.normalize(res.toLowerCase(), Normalizer.Form.NFD);
			String respuesta = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
			if (respuesta.equals("si")) {
				hacerReserva(clientenuevo);
				return;
			} else if (respuesta.equals("no")) {
				System.out.println("¡Gracias por elegirnos, esperamos tener disponibilidad la próxima ocasión!");
			}
		}
		if (clientenuevo.getHabitacion() != null) {
			System.out.println("Su habitación asignada es: " + clientenuevo.getHabitacion().getNumhabitacion());
		}
	}

	static void hacerReserva(Cliente clientenuevo) {
		if (clientenuevo.isReserva()==true) {
			System.out.println("Usted ya tiene una reserva asignada a la habitación " + clientenuevo.getHabitacion().getNumhabitacion());
		    return;
		}
		
		System.out.println("Ingrese la fecha de entrada de su proxima reserva: ");
		String fecha_nuevares = sc.nextLine();
		LocalDate fechanuevares = LocalDate.parse(fecha_nuevares);
		
		while (clientenuevo.getFecha_salida().compareTo(fechanuevares) >= 0 ) {
			System.out.println("Fecha inválida, ingrese una fecha superior a la actual");
			String fecha_nuevareser = sc.nextLine();
			LocalDate fechanuevareser = LocalDate.parse(fecha_nuevareser);
			fechanuevares = fechanuevareser;
		}

		System.out.println("Ingrese la fecha de salida en formato dd/mm/yyyy: ");
		String fecha_nuevasal = sc.nextLine();
		System.out.println("Ingrese el número de acompañantes");
		long nuevo_numacom = readLong();
		clientenuevo.setNumAcompanantes((int)nuevo_numacom);
		clientenuevo.setFecha_entrada(fechanuevares.toString());
		clientenuevo.setFecha_salida(fecha_nuevasal);
		
		
		Reserva reserva1 = new Reserva(clientenuevo.getFecha_entrada().toString(), clientenuevo.getFecha_salida().toString(), clientenuevo);
		
		if (clientenuevo.getHabitacion() == null) {
			    clientenuevo.setReserva(false);
              	reserva1.cancelar_reserva();///// Solo cancela si al intentar asignarle una habitación no hay disponibles.
              	System.out.println("Lo sentimos, no hay habitaciones disponibles");	
		}
		
		if (clientenuevo.isReserva() == true) {
			reserva1.setCliente(clientenuevo);
			System.out.println("Reserva asignada con éxito para la habitación " + clientenuevo.getHabitacion().getNumhabitacion());
		}
		
	}

	static void elegirMenu() {
		System.out.println("BIENVENIDO AL RESTAURANTE.");
		System.out.println("Ingrese C.C. del cliente: ");
		long cedula = readLong();
		Cliente cliente = buscarCliente(cedula);
		if(cliente.getHabitacion() == null || cliente.isReserva() == true) {
			System.out.println("Debes estar hospedado en el hotel para acceder a estos servicios.");
			return;
		}

		String respFinal;
		do {
			System.out.println(
					"¿Desea ver la carta vegetariana o tradicional? Por favor, digite el número correspondiente."
							+ "\n" + "1. Carta vegetariana." + "\n" + "2. Carta tradicional.");
			
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
			System.out.println(cliente.getServicio());
			cliente.getServicio().tipoMenu(opcionCarta, eleccion, cliente);
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
		if(cliente.getHabitacion() == null || cliente.isReserva() == true) {
			System.out.println("Debes estar hospedado en el hotel para acceder a estos servicios.");
			return;
		}

		String respFinal;
		do {
			System.out.println("Por favor, digite el número correspondiente a la atracción que desea."
					+ "\n1. Montaña rusa - $15000. \n" + "2. Paseo oscuro - $15000. \n"
					+ "3. Carritos chocones - $10000. \n" + "4. Piscina - $20000. \n"
					+ "5. Piscina de pelotas - $8000. \n" + "6. Carrusel - $8000. \n" + "7. Bungy - $10000. \n"
					+ "8. Barco pirata - $15000.");

			int eleccion = (int) readLong();
			if (eleccion <= 0 || eleccion > 8) {
				System.out.println("Dígito ingresado inválido");
				return;
			}
			cliente.getServicio().tipoAtraccion(eleccion, cliente);
			System.out.println("¿Desea elegir otra atracción?");
			String respSalir = readIn();
			String cadenaNormalize = Normalizer.normalize(respSalir.toLowerCase(), Normalizer.Form.NFD);
			respFinal = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
		} while (respFinal.equals("si"));
		System.out.println("¡Disfrute del juego!");
	}

	public static void gananciasNetas() {
		System.out.println("Las ganancias netas del hotel hasta el momento son iguales a: " + hotel.gananciaNeta()+ "\n");
	}

	public static void salidaCliente() { 
		System.out.println("Ingrese C.C. del cliente para dar salida: ");
		long cedula = readLong();
		Cliente clientesalida = buscarCliente(cedula);
		if(clientesalida.getHabitacion() == null) {
			System.out.println("Usted no se encuentra en el hotel y no tiene deudas pendientes.");
			return;
		}
		
		hotel.cobrarDeudas(clientesalida);

		for(int i=0;i< Recepcion.hotel.getEmpleados().size();i++) {
			int rd = (int) (Math.random() * (hotel.getEmpleados().size() + 1));
			if(hotel.getEmpleados().get(rd) instanceof Mucama) {
				((Mucama)hotel.getEmpleados().get(rd)).limpiarHabitacion(clientesalida.getHabitacion());// Asignación
				clientesalida.getHabitacion().setCliente(null); //habitacion
				clientesalida.setHabitacion(null);
				((Mucama)hotel.getEmpleados().get(rd)).setHabitacion(null);
				break;
			}
		}

			System.out.println("¿Desea hacer una nueva reserva?");
			sc.nextLine();
			String respuesta = sc.nextLine();
			String cadenaNormalize = Normalizer.normalize(respuesta.toLowerCase(), Normalizer.Form.NFD);
			String respuestan = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
			if (respuestan.equals("si")) {
				hacerReserva(clientesalida);
			}
			System.out.println("¡Gracias por visitarnos, vuelva pronto!");
	}
	
	public static void mostrarClientes() {
	int cont =0;
	
	System.out.println("Clientes hospedados en el hotel registrado con el código " + hotel.getcodigoRNT() + ":");
	
		for (Cliente i : hotel.getClientes()) {
			if(i.getHabitacion() != null) {
				cont++;
				System.out.println(i.toString());
			}
					
		}
		if(cont == 0) {
			System.out.println("En el momento no se encuentran clientes en el hotel.");
		}
		
	}
	

	
	public static void cancelarReserva() {
		System.out.println("Ingrese C.C. del cliente: ");
		long cedula = readLong();
		Cliente clientenuevo = buscarCliente(cedula);
		if (clientenuevo.isReserva() == true) {
			for(Reserva i: hotel.getReservas()) {
				if(i.getCliente() == clientenuevo) {
					i.cancelar_reserva(clientenuevo);
					break;
				}
			}
			System.out.println("Reserva cancelada con éxito.");
		}else {
			System.out.println("Usted no tiene reservas para cancelar");	
		}
	}
	
	// Metodos de busqueda
	public static Cliente buscarCliente(long cedula) {
		Cliente uno = null;
		for (Cliente i : hotel.getClientes()) {
			if (cedula == i.getId()) {
				uno = i;
				break;
			}
		}if(uno == null) {
			System.out.println("Cliente no encontrado, ingrese una nueva cédula: ");
			long c1 = readLong();
			buscarCliente(c1);
		}

		return uno;
	}
	// Método

	private static void salirDelsistema() {
		System.out.println("¡Vuelva pronto!");
		Serializacion.serializacion(hotel);
		System.exit(0);
	}
	public static Hotel getHotel() {
		return hotel;
	}

	public static void setHotel(Hotel hotel) {
		Recepcion.hotel = hotel;
	}

	public static Administrador getAd1() {
		return ad1;
	}

	public static void setAd1(Administrador ad1) {
		Recepcion.ad1 = ad1;
	}
}
