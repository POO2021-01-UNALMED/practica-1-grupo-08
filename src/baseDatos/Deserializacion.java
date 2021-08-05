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

/*Esta clase permite crear las instancias de las clases de acuerdo a la �ltima informaci�n guarda en los archivos.*/

public class Deserializacion {
	
	/*Atributo de tipo archivo que define la ruta del directorio donde est�n los archivos txt que contienen la
	 *informaci�n de cada instancia.*/
	private static File rutaTemp = new File("src\\baseDatos\\temp");

	
	//Primer m�todo que se debe llamar al ejecutar el programa.
	public static void deserializar() {
		//Es un arreglo que listar� todos los archivos que est�n en esa ruta.
		File[] docs = rutaTemp.listFiles(); 
		
		FileInputStream fis;  
		ObjectInputStream ois;

		for (File archivo : docs) {
			//getAbsolutePath() trae la direcci�n del archivo para mirar si corresponde al archivo habitaciones.
			if (archivo.getAbsolutePath().contains("habitaciones")) {
				try {
					//Leer� el archivo de texto.
					fis = new FileInputStream(archivo);
					//Deserializar� los datos primitivos y los objetos.
					ois = new ObjectInputStream(fis);

					/*Hotel tiene como atributo un arreglo de habitaciones,en la siguiente l�nea se est� 
					 * modificando ese arreglo ya que ois.readObject lee todos los objetos que deserializ�
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
