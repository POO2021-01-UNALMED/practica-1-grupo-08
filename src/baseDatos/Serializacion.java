package baseDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import gestorAplicacion.Funcionamiento.*;
import uiMain.Recepcion;

/*Esta clase permite guardar la información de cada objeto creado durante la ejecución del programa en un 
 * archivo txt según su tipo.*/
public class Serializacion {
	private static File rutaTemp = new File("src\\baseDatos\\temp");

	//Este método debe ir en el momento que se requiera guardar la infromación agregada y modificada de cada instancia.
	public static void serializacion(Hotel hotel) {
		//Permitirá la serialización.
		FileOutputStream fos;
		ObjectOutputStream oos; 
		
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;

		for (File archivo : docs) {
			// Borrará todo lo que está en el archivo para guardar la información actualizada.
			try {
				pw = new PrintWriter(archivo);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		for (File archivo : docs) {
			// getAbsolutePath() trae la dirección del archivo para mirar si corresponde al archivo habitaciones.	
			if (archivo.getAbsolutePath().contains("habitaciones")) {
				try {
					fos = new FileOutputStream(archivo);
					oos = new ObjectOutputStream(fos);
					//Escribirá en el archivo la información del objeto que hay en cada posiicón del arreglo.
					oos.writeObject(Recepcion.getHotel().getHabitaciones());
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
					oos.writeObject(Recepcion.getHotel().getReservas());
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
					oos.writeObject(Recepcion.getHotel().getServicios());
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
					oos.writeObject(Recepcion.getHotel().getEmpleados());
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
					oos.writeObject(Recepcion.getHotel().getClientes());
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
