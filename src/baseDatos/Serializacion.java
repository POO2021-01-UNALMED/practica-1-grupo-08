package baseDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import gestorAplicacion.Funcionamiento.*;
import uiMain.Recepcion;

/*Esta clase permite guardar la informaci�n de cada objeto creado durante la ejecuci�n del programa en un 
 * archivo txt seg�n su tipo.*/
public class Serializacion {
	private static File rutaTemp = new File("src\\baseDatos\\temp");

	//Este m�todo debe ir en el momento que se requiera guardar la infromaci�n agregada y modificada de cada instancia.
	public static void serializacion() {
		//Permitir� la serializaci�n.
		FileOutputStream fos;
		ObjectOutputStream oos; 
		
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;

		for (File archivo : docs) {
			// Borrar� todo lo que est� en el archivo para guardar la informaci�n actualizada.
			try {
				pw = new PrintWriter(archivo);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		for (File archivo : docs) {
			// getAbsolutePath() trae la direcci�n del archivo para mirar si corresponde al archivo habitaciones.	
			if (archivo.getAbsolutePath().contains("habitaciones")) {
				try {
					fos = new FileOutputStream(archivo);
					oos = new ObjectOutputStream(fos);
					//Escribir� en el archivo la informaci�n del objeto que hay en cada posiic�n del arreglo.
					oos.writeObject(Hotel.getHabitaciones());
					oos.close();
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (archivo.getAbsolutePath().contains("reservas")) {
				try {
					fos = new FileOutputStream(archivo);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(Hotel.getReservas());
					oos.close();
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (archivo.getAbsolutePath().contains("servicios")) {
				try {
					fos = new FileOutputStream(archivo);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(Hotel.getServicios());
					oos.close();
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (archivo.getAbsolutePath().contains("empleados")) {
				try {
					fos = new FileOutputStream(archivo);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(Hotel.getEmpleados());
					oos.close();
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (archivo.getAbsolutePath().contains("clientes")) {
				try {
					fos = new FileOutputStream(archivo);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(Hotel.getClientes());
					oos.close();
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

	}

}
