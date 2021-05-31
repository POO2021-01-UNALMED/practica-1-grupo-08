package gestorAplicacion.Personal;

/* Autores: Ver�nica Seguro Varela
 * Componentes: Un atributo y tres m�todos.
 * Finalidad : Clase num�rica que tiene como objetivo identificar el tipo de
 * hora extra realizada por el empleado y de acuerdo a esto aumentar su salario 
 * teniendo en cuenta los diferentes valores cada tipo de hora extra, estos
 * componentes son usados para el m�todo pagarHorasExtras() de la clase Empleado 
 * encargado de aumentar el salario de acuerdo del tipo de hora extra y de la 
 * cantidad de horas trabajadas. 
 * */
public enum HorasExtras {
	//Constantes que definen el valor por hora de cada tipo de hora extra.
	DIURNA(4731), NOCTURNA(6624), DIURNADOMINICAL(7570), NOCTURNADOMINICAL(9463);

	private int precioHora;
    
	//M�TODOS 
	
	/* M�todo para asignar el valor de cada tipo de hora extra.
	 * */
	private HorasExtras(int x) {
		precioHora = x;
	}
    // Get y set
	public int getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(int precioHora) {
		this.precioHora = precioHora;
	}

}
