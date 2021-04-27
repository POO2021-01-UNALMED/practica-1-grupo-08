package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import gestorAplicacion.Funcionamiento.*;

public class Serializacion {
	private static File rutaTemp = new File ("src\\baseDatos\\temp");
	
	public static void serializacion(Hotel hotel) {
		FileOutputStream fos;
		ObjectOutputStream oos; /*Serializará*/
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;/*escribirá en el archivo lo que se serializó*/
		
		for(File archivo: docs) {
		/*Borrará todo lo que está en el archivo*/	
				try {
					pw = new PrintWriter(archivo);
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}	
		}
		
		
		for(File archivo: docs) {
			if(archivo.getAbsolutePath().contains("habitaciones")) {
				/*getAbsolutePath() trae la dirección del archivo para mirar si correpsonde al archivo asignaturas*/
				try {
					fos = new FileOutputStream(archivo);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(Habitacion.getHabitaciones()); 
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}catch(IOException e){
					e.printStackTrace();
				}
			}else if(archivo.getAbsolutePath().contains("alumnos")) {
				/*es el mismo proceso*/
			}
				
		}
		
		
		

	}
	
}
