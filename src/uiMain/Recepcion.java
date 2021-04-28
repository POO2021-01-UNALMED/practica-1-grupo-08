package uiMain;

import java.util.Scanner;
import gestorAplicacion.*;
import gestorAplicacion.Funcionamiento.Habitacion;
import gestorAplicacion.Funcionamiento.Hotel;
import gestorAplicacion.Personal.Administrador;
import gestorAplicacion.Personal.Mucama;

public class Recepcion {
	public static Administrador ad1 = new Administrador("Luis", 134344);
	public static Hotel hotel = new Hotel();

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
		 
		 Cliente cliente1 = new Cliente("Nora",21345687,"27/05/2021","03/06/2021",2,15000000,1000656556);
		 Cliente cliente2 = new Cliente("Fabio",21356780,"02/06/2021","06/06/2021",3,20000000);
		 Cliente cliente3 = new Cliente("Yesenia",21724520,"03/06/2021","15/06/2021",4,25000000);
		 Cliente cliente4 = new Cliente("Wilmar",15670834,"28/05/2020","07/06/2001",4,35000000,4567234); ///// Solo se registra el cliente titular.
		 Cliente cliente5 = new Cliente("Sofía",4321689,"07/07/2020","20/07/2020",2,15600000,115467300);
		 
		 Habitacion hab1 = new Habitacion(103,2);
		 Habitacion hab2 = new Habitacion(202,4);
		 Habitacion hab3 = new Habitacion(101,3);
		 Habitacion hab4 = new Habitacion(303,5); 
		 Habitacion hab5 = new Habitacion(205,4);
		 
		 do {
			 System.out.println("Bienvenidos al hotel, ¿qué acción desea realizar ahora?");
			 System.out.println("1. Tomar una habitación");
			 System.out.println("2. Hacer una reserva");
			 System.out.println("3. Elegir menú del restaurante");
			 System.out.println("4. Elegir atracción");
			 System.out.println("5. Mostrar ganancias netas");
			 System.out.println("6. Dar salida a un cliente");
			 System.out.println("7. Terminar");
			 System.out.println("Teclee su opción: ");
			 opcion = (int)readLong();
			 
					 switch(opcion){
					 case 1: tomarHabitacion(); break;
					 case 2: método; break;
					 case 3: método; break;
					 case 4: método; break;                              ////Poner terminar///
					 case 5: método; break;
					 }
					 }while(opcion !=7);
		 }
	static void tomarHabitacion(){
		System.out.println("Ingrese C.C. del cliente: ");
		long cedula = readLong();
		Cliente clientenuevo = buscarCliente(cedula);
		hotel.asignarHabitacion(clientenuevo);                   //¿Si no encunetra habitación?
		
	}
	
	// Metodos de busqueda
	
	public static Cliente buscarCliente(long cedula) {
		Cliente uno = null; 
		for (Cliente i: hotel.clientes) {
			if (cedula == i.getId()) {
				uno = i;
				break;
			}else {
				System.out.println("Cliente no encontrado, ingrese una nueva cedula: ");
				long c1 = readLong();
				buscarCliente(c1);
			}
			break;
		}
		return uno;
			}

}


