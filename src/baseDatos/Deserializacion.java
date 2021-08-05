package baseDatos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcionamiento.*;
import gestorAplicacion.Personal.Empleado;

/*Esta clase permite crear las instancias de las clases de acuerdo a la última información guarda en los archivos.*/

public class Deserializacion {
	
	/*Atributo de tipo archivo que define la ruta del directorio donde están los archivos txt que contienen la
	 *información de cada instancia.*/
	private static File rutaTemp = new File("src\\baseDatos\\temp");

	
	//Primer método que se debe llamar al ejecutar el programa.
	public static void deserializar() {
		//Es un arreglo que listará todos los archivos que están en esa ruta.
		File[] docs = rutaTemp.listFiles(); 
		
		FileInputStream fis;  
		ObjectInputStream ois;

		for (File archivo : docs) {
			//getAbsolutePath() trae la dirección del archivo para mirar si corresponde al archivo habitaciones.
			if (archivo.getAbsolutePath().contains("habitaciones")) {
				try {
					//Leerá el archivo de texto.
					fis = new FileInputStream(archivo);
					//Deserializará los datos primitivos y los objetos.
					ois = new ObjectInputStream(fis);

					/*Hotel tiene como atributo un arreglo de habitaciones,en la siguiente línea se está 
					 * modificando ese arreglo ya que ois.readObject lee todos los objetos que deserializó
					 * y se castea a un arreglo. */
					Hotel.setHabitaciones((ArrayList<Habitacion>) ois.readObject()); 
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

					Hotel.setReservas((ArrayList<Reserva>) ois.readObject()); 
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

					Hotel.setServicios((ArrayList<Servicio>) ois.readObject()); 
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

					Hotel.setEmpleados((ArrayList<Empleado>) ois.readObject()); 
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

					Hotel.setCliente((ArrayList<Cliente>) ois.readObject()); 
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
