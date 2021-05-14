package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.*;
import gestorAplicacion.Personal.Empleado;

public class Deserializacion {
	private static File rutaTemp = new File("src\\basedatos\\temp");
	/*
	 * Atributo de tipo archivo. que define la ruta del directorio que contiene las
	 * clases. Me dice donde est�n los archivos que guard� por ultima vez
	 */

	/*
	 * Se ejecuta al inicio. Como lo primero que hace el programa es crear el objeto
	 * hotel, su constructor llama a este m�todo)
	 */
	public static void deserializar(Hotel hotel) {
		File[] docs = rutaTemp.listFiles(); /*
								 * Es un arreglo que me traer� todos los archivos que est�n en ese directorio.
								 */
		FileInputStream fis; /* me permitir� leer el archivo en texto */
		ObjectInputStream ois; /* deserializar� los datos primitivos y los objetos */

		for (File archivo : docs) {
			if (archivo.getAbsolutePath().contains("habitaciones")) {
				/*
				 * getAbsolutePath() trae la direcci�n del archivo para mirar si correpsonde al
				 * archivo asignaturas
				 */
				try {
					fis = new FileInputStream(archivo);
					ois = new ObjectInputStream(fis);

					hotel.setHabitaciones((ArrayList<Habitacion>) ois.readObject()); /*
											 * Departamento tiene como atributo un arreglo de asignaturas, aqui le estoy
											 * enviando ese arreglo. ois.readObject est� leyendo todos los objetos de
											 * deserializ�
											 */
					ois.close();
					fis.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			} else if (archivo.getAbsolutePath().contains("reservas")) {
				try {
					fis = new FileInputStream(archivo);
					ois = new ObjectInputStream(fis);

					hotel.setReservas((ArrayList<Reserva>) ois.readObject()); 
					ois.close();
					fis.close();						
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} else if (archivo.getAbsolutePath().contains("servicios")) {
				try {
					fis = new FileInputStream(archivo);
					ois = new ObjectInputStream(fis);

					hotel.setServicios((ArrayList<Servicio>) ois.readObject()); 
					ois.close();
					fis.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} else if (archivo.getAbsolutePath().contains("empleados")) {
				try {
					fis = new FileInputStream(archivo);
					ois = new ObjectInputStream(fis);

					hotel.setEmpleados((ArrayList<Empleado>) ois.readObject()); 
				    ois.close();
					fis.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} else if (archivo.getAbsolutePath().contains("clientes")) {
				try {
					fis = new FileInputStream(archivo);
					ois = new ObjectInputStream(fis);

					hotel.setCliente((ArrayList<Cliente>) ois.readObject()); 
					ois.close();
					fis.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
