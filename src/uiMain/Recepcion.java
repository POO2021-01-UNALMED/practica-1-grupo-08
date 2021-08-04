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

/* Autores: Verónica Seguro Varela, Ximena Castañeda Ochoa, Yojan Andrés Alcaraz Pérez.
 * La clase Recepción, que es el programa main, permitirá implementar la interacción del usuario con el sistema.
 ** Componentes: Atributos,los respectivos métodos que permiten la lectura y procesamiento de la información 
 * brindada por el usuario, el menú y desarrollo de cada una de las funcionalidades del sistema, los métodos de 
 * búsqueda necesarios para el procesamiento de los datos, el método que nos permite abandonar el programa y 
 * los métodos get y set para el acceso y modificación de los atributos.
 */
public class Recepcion {
	private static Administrador ad1 = new Administrador("Julián", 134344);

	// MÉTODOS DE ENTRADA Y LECTURA POR CONSOLA:

	static Scanner sc = new Scanner(System.in);

	/*
	 * Permite la lectura de datos tipo long ingresados por consola
	 */
	static long readLong() {
		return sc.nextLong();
	}

	/*
	 * Permite la lectura de datos tipo String ingresados por consola
	 */
	static String readIn() {
		sc.nextLine();
		return sc.nextLine();
	}

	// PROGRAMA MAIN:
	public static void main(String[] args) {
		int opcion;
		Deserializacion.deserializar();
		Habitacion.aumentarCapacidad();

		/*
		 * Cliente cliente1 = new Cliente("Ana", 38836489, "2021-01-05","2021-01-15",
		 * 0); Cliente cliente2 = new Cliente("Fabio", 21356780, "2021-06-02",
		 * "2021-06-06", 3); Cliente cliente3 = new Cliente("Yesenia", 21724520,
		 * "2021-06-03", "2021-06-15", 4); Cliente cliente4 = new Cliente("Manuel",
		 * 15670834, "2021-05-28", "2021-06-07", 4, 4567234); Cliente cliente5 = new
		 * Cliente("Sofía", 4321689, "2021-03-07", "2021-03-20", 2, 115467300); Cliente
		 * cliente6 = new Cliente("Ximena", 49759459, "2021-02-10", "2021-02-20", 3,
		 * 9890773); Cliente cliente7 = new Cliente("Yojan", 10493043, "2021-07-07",
		 * "2021-07-20", 1, 48374574); Cliente cliente8 = new Cliente("Verónica",
		 * 1007253340, "2021-02-21", "2021-03-06", 4);
		 * 
		 * Habitacion hab1 = new Habitacion(103, 2); Habitacion hab2 = new
		 * Habitacion(202, 4); Habitacion hab3 = new Habitacion(101, 5); Habitacion hab4
		 * = new Habitacion(303, 5); Habitacion hab5 = new Habitacion(205, 4);
		 * Habitacion hab6 = new Habitacion(217, 3); Habitacion hab7 = new
		 * Habitacion(402, 2);
		 * 
		 * Empleado emp1 = new OficiosVarios("Luis", 2489364,"vigilante",
		 * HorasExtras.DIURNA, 10); Empleado emp2 = new Mucama("Karla", 3544565,
		 * HorasExtras.DIURNADOMINICAL, 9); Empleado emp3 = new OficiosVarios("Mario",
		 * 10595906,"Recepcionista"); Empleado emp4 = new Mucama("Yaneth", 4375434);
		 * Empleado emp5 = new OficiosVarios("Raúl", 158394934, "Bartender",
		 * HorasExtras.NOCTURNA, 15); Empleado emp6 = new OficiosVarios("Giussepe",
		 * 16890495, "CHEF",HorasExtras.NOCTURNADOMINICAL, 5); Mucama muc1 = new
		 * Mucama("Camila",1023456789,HorasExtras.DIURNADOMINICAL,4); Mucama muc2 = new
		 * Mucama("Julia",102344333,HorasExtras.NOCTURNA,2);
		 * 
		 * Servicio ser1 = new Servicio(cliente1); Servicio ser2 = new
		 * Servicio(cliente2); Servicio ser3 = new Servicio(cliente3); Servicio ser4 =
		 * new Servicio(cliente4); Servicio ser5 = new Servicio(cliente5); Servicio ser6
		 * = new Servicio(cliente6); Servicio ser7 = new Servicio(cliente7); Servicio
		 * ser8 = new Servicio(cliente8);
		 */

		/*
		 * MENÚ GENÉRICO DE CONSOLA: Abarcará todas las funcionalidades disponibles y
		 * que permite mostrar al usuario el menú con cada una de las funcionalidades de
		 * las que podrá hacer uso, así, el usuario digitará en su momento la opción
		 * correspondiente a la acción que desee realizar.
		 */

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

	/*
	 * FUNCIONALIDAD 1: Tomar habitación: Este método pide al usuario(Recepcionista
	 * o Administrador) ingresar el número de identificación del cliente para
	 * posteriormente hacer uso del método de búsqueda del cliente y verificar que
	 * este aún no tenga asignada una habitación, llamará entonces al método
	 * "asignarHabitacion()" de la clase "Hotel", si en el momento no hay
	 * habitaciones disponibles se dará al cliente la opción de realizar una
	 * reserva, el cliente debe responder si desea o no hacer la reserva y así
	 * proceder según su respuesta. En el caso que se encuentre habitaciones
	 * disponibles se mostrará al usuario la habitación asignada al cliente.
	 */
	private static void tomarHabitacion() {
		System.out.println("Ingrese C.C. del cliente: ");
		long cedula = readLong();
		Cliente clientenuevo = buscarCliente(cedula);
		if (clientenuevo.getHabitacion() != null) {
			System.out.println("La habitación con el número " + clientenuevo.getHabitacion().getNumhabitacion()
					+ " ya le ha sido asignada");
			return;
		}
		Hotel.asignarHabitacion(clientenuevo);

		if (clientenuevo.getHabitacion() != null) {
			System.out.println("Su habitación asignada es: " + clientenuevo.getHabitacion().getNumhabitacion());
		}

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

	}

	/*
	 * FUNCIONALIDAD 2 (Control de Reservas): Permite al usuario realizar una
	 * reserva después de verificar que el cliente no tenga ya una asignada,
	 * posteriormente, se pedirá al usuario ingresar por consola los parámetros
	 * requeridos para hacer una reserva;se busca una habitación del tipo de capacidad requerida y que tengan
	 * menor cantidad de reservas en cola,para que sea asignada esta habitación al  cliente, siempre y cuando la fecha de 
	 * entrada de este sea después de la fecha de salida del último cliente en espera por la habitación. De no darse esta 
	 * condición, no se realizará la reserva porque se cruzan los tiempos de los  clientes. El método tiene como parámetro
	 * de entrada el respectivo cliente y no tiene ningún valor de salida.
	 */

	private static void hacerReserva(Cliente clientenuevo) {
		if (clientenuevo.isReserva() == true) {
			System.out.println("Usted ya tiene una reserva asignada a la habitación "
					+ clientenuevo.getHabitacion().getNumhabitacion());
			return;
		}

		System.out.println("Ingrese la fecha de entrada de su proxima reserva: ");
		String fecha_nuevares = sc.nextLine();
		LocalDate fechanuevares = LocalDate.parse(fecha_nuevares);

		while (clientenuevo.getFecha_salida().isAfter(fechanuevares)) {
			System.out.println("Fecha inválida, ingrese una fecha superior a la actual");
			String fecha_nuevareser = sc.nextLine();
			LocalDate fechanuevareser = LocalDate.parse(fecha_nuevareser);
			fechanuevares = fechanuevareser;
		}

		System.out.println("Ingrese la fecha de salida en formato dd/mm/yyyy: ");
		String fecha_nuevasal = sc.nextLine();
		LocalDate fechanuevasalida = LocalDate.parse(fecha_nuevasal);

		while (fechanuevares.isAfter(fechanuevasalida)) {
			System.out.println("Fecha inválida, ingrese una fecha de salida superior a la fecha de entrada");
			String fecha_nuevasali = sc.nextLine();
			LocalDate fechanuevasalidas = LocalDate.parse(fecha_nuevasali);
			fechanuevasalida = fechanuevasalidas;
		}

		System.out.println("Ingrese el número de acompañantes");
		long nuevo_numacom = readLong();
		clientenuevo.setNumAcompanantes((int) nuevo_numacom);
		clientenuevo.setFecha_entrada(fechanuevares.toString());
		clientenuevo.setFecha_salida(fechanuevasalida.toString());

		Habitacion habauxiliar = new Habitacion();
		for (Habitacion i : Hotel.getHabitaciones()) {
			int conta = 0;
			if (i.getTipoCapacidad() == clientenuevo.getNumAcompanantes() + 1) {
				if (conta > 0) {
					if (habauxiliar.getClientes().size() > i.getClientes().size()) {
						habauxiliar = i;
					}

				} else {
					habauxiliar = i;
					conta += 1;
				}
			}
		}

		if (clientenuevo.getFecha_entrada()
				.isAfter(habauxiliar.getClientes().get(habauxiliar.getClientes().size() - 1).getFecha_salida())) {
			Reserva reserva1 = new Reserva(clientenuevo.getFecha_entrada().toString(),
					clientenuevo.getFecha_salida().toString(), clientenuevo);
			habauxiliar.setClientes(clientenuevo);
			clientenuevo.setHabitacion(habauxiliar);
			System.out.println(
					"Reserva asignada con éxito para la habitación " + clientenuevo.getHabitacion().getNumhabitacion());
		} else {
			System.out.println("Lo sentimos, no hay habitaciones disponibles para reservar.");
		}
	}

	/*
	 * Permite al usuario cancelar una reserva realizada previamente, primero pide
	 * ingresar la cédula del cliente que tiene la reserva, para luego verificar si
	 * dicho cliente tiene reservas, recorrer la lista de instancias de esta clase y
	 * cancelar la reserva de interés.
	 * 
	 */
	private static void cancelarReserva() {
		System.out.println("Ingrese C.C. del cliente: ");
		long cedula = readLong();
		Cliente clientenuevo = buscarCliente(cedula);
		if (clientenuevo.isReserva() == true) {
			for (Reserva i : Hotel.getReservas()) {
				if (i.getCliente() == clientenuevo) {
					i.cancelar_reserva(clientenuevo);
					break;
				}
			}
			System.out.println("Reserva cancelada con éxito.");
		} else {
			System.out.println("Usted no tiene reservas para cancelar");
		}
	}

	/*
	 * FUNCIONALIDAD 3: Permite al usuario mostrar el menú del restaurante y las
	 * atracciones con las que cuenta el hotel para que el cliente haga su elección
	 * y esta sea ingresada por consola. El usuario ingresa la cédula del cliente y
	 * se verifica si este tiene asignada una habitación o si la reserva ya fue
	 * efectuada, si es así se procede a mostrar el menú y a ingresar cada una de
	 * las elecciones del cliente y finalmente, se procede a relacionar estas
	 * elecciones con el servicio del cliente a través de los métodos "tipoMenu()" y
	 * "tipoAtraccion()" de la clase Servicio.
	 */
	private static void elegirMenu() {
		System.out.println("BIENVENIDO AL RESTAURANTE.");
		System.out.println("Ingrese C.C. del cliente: ");
		long cedula = readLong();
		Cliente cliente = buscarCliente(cedula);
		if (cliente.getHabitacion() == null || cliente.isReserva() == true) {
			System.out.println("Debes estar hospedado en el hotel para acceder a estos servicios.");
			return;
		}

		String respFinal;
		do {
			System.out.println(
					"¿Desea ver la carta vegetariana o tradicional? Por favor, digite el número correspondiente." + "\n"
							+ "1. Carta vegetariana." + "\n" + "2. Carta tradicional.");

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
			cliente.getServicio().tipoMenu(opcionCarta, eleccion, cliente);
			System.out.println("¿Desea elegir otro platillo?");
			String respSalir = readIn();
			String cadenaNormalize = Normalizer.normalize(respSalir.toLowerCase(), Normalizer.Form.NFD);
			respFinal = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
		} while (respFinal.equals("si"));
		System.out.println("¡Buen provecho!");
	}

	private static void elegirAtraccion() {
		System.out.println("BIENVENIDO AL PARQUE DE DIVERSIONES.");
		System.out.println("Ingrese C.C. del cliente: ");
		long cedula = readLong();
		Cliente cliente = buscarCliente(cedula);
		if (cliente.getHabitacion() == null || cliente.isReserva() == true) {
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

	/*
	 * FUNCIONALIDAD 4: Esta funcionalidad permite mostrar las ganancias totales del
	 * hotel a través del método "gananciaNeta()" de la clase "Hotel".
	 */
	private static void gananciasNetas() {
		System.out.println(
				"Las ganancias netas del hotel hasta el momento son iguales a: " + Hotel.gananciaNeta() + "\n");
	}

	/*
	 * FUNCIONALIDAD 5: La funcionalidad que permite dar salida al cliente del hotel
	 * se encarga de pedir por consola la cédula del cliente para hacer uso del
	 * método de búsqueda, luego se hace un llamado al método "cobrarDeudas()" de la
	 * clase "Hotel". Posteriormente, se asigna de manera aleatoria una mucama a la
	 * habitación que el cliente en cuestión deja vacía para darle disponibilidad a
	 * través de método "limpiarHabitacion()" de la clase "Mucama" y así proceder a
	 * deshacer la relación cliente-habitación. Finalmente se da al cliente la
	 * opción de realizar inmediatamente una próxima reserva.
	 */

	private static void salidaCliente() {
		System.out.println("Ingrese C.C. del cliente para dar salida: ");
		long cedula = readLong();
		Cliente clientesalida = buscarCliente(cedula);
		if (clientesalida.getHabitacion() == null) {
			System.out.println("Usted no se encuentra en el hotel y no tiene deudas pendientes.");
			return;
		}

		Hotel.cobrarDeudas(clientesalida);

		int rd = (int) (Math.random() * (Hotel.getEmpleados().size()));
		Mucama mucamaAux = new Mucama();
		clientesalida.getHabitacion().getClientes().remove(0);
		
		while (true) {
			int rd2 = (int) (Math.random() * (Hotel.getEmpleados().size()));
			if(Hotel.getEmpleados().get(rd) instanceof Mucama) {
				mucamaAux = (Mucama) Hotel.getEmpleados().get(rd);
				break;
			}	
			rd = rd2;
		}
		
		if(clientesalida.getHabitacion().getClientes().size() == 0) {
			mucamaAux.limpiarHabitacion(clientesalida.getHabitacion());
		}else {
			mucamaAux.limpiarHabitacion(clientesalida);
		}
		
		clientesalida.setHabitacion(null);
		mucamaAux.setHabitacion(null);
		

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

	/*
	 * MÉTODO: El siguiente método permite mostrar la lista de clientes que
	 * actualmente se encuentran hospedados en el hotel.
	 */
	private static void mostrarClientes() {
		int cont = 0;

		System.out.println("Clientes hospedados en el hotel registrado con el código " + Hotel.getcodigoRNT() + ":\n");

		for (Cliente i : Hotel.getClientes()) {
			if (i.getHabitacion() != null) {
				cont++;
				System.out.println(i.toString());
			}

		}
		if (cont == 0) {
			System.out.println("En el momento no se encuentran clientes en el hotel.");
		}

	}

	/*
	 * MÉTODO DE BÚSQUEDA: Permite buscar entre la lista de clientes aquel que está
	 * interesado en cualquiera de las funcionalidades anteriores, el método recibe
	 * como parámetro la cédula del cliente y retorna el objeto de tipo cliente
	 * asociado.
	 */

	private static Cliente buscarCliente(long cedula) {
		Cliente uno = null;
		for (Cliente i : Hotel.getClientes()) {
			if (cedula == i.getId()) {
				uno = i;
				break;
			}
		}
		if (uno == null) {
			System.out.println("Cliente no encontrado, ingrese una nueva cédula: ");
			long c1 = readLong();
			buscarCliente(c1);
		}

		return uno;
	}
	// MÉTODO: El siguiente método permite llevar a cabo el proceso de
	// serialización, para luego salir del programa.

	private static void salirDelsistema() {
		System.out.println("¡Vuelva pronto!");
		Serializacion.serializacion();
		System.exit(0);
	}

	// MÉTODOS GET Y SET: para el acceso y modificación de los atributos.

	public static Administrador getAd1() {
		return ad1;
	}

}
