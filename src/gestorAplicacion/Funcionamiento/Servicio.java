package gestorAplicacion.Funcionamiento;
import java.io.Serializable;
import gestorAplicacion.Cliente;
import uiMain.Recepcion;

/*Autores: Ximena Casta�eda.
 *Componentes: Atributos,constructor,m�todos get y set,m�todos tipoMenu y tipoAtraccion.
 *Finalidad: Esta clase simula los servicios que ofrece el hotel; restaurante y �rea de atracciones.
 *Su finalidad es identificar el total gastado por cada cliente y sus acompa�antes en estas dos zonas,por esto, cada instancia
 *de tipo cliente tendr� relacionado por medio de un atributo una instancia servicio y viceversa.
 *Esta clase contiene el atributo constante,serialVersionUID, necesario para la serizalizaci�n de los objetos, un  atributo entero
 *que sirve de acumulador y un atributo de referencia de tipo cliente.*/
 


public class Servicio implements Serializable {
	
	//ATRIBUTOS.
	private static final long serialVersionUID = 1L;
	private int gastosServicios;
	private Cliente cliente;

	//CONSTRUCTOR.
	public Servicio(Cliente cliente) {
		this.cliente = cliente;
		cliente.setServicio(this);
		Recepcion.getHotel().getServicios().add(this);
	}

	//M�TODOS SET Y GET: permiten acceder y modificar el valor de los atributos. 
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setGastosServicios(int valorGasto) {
		this.gastosServicios = valorGasto;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public int getGastosServicios() {
		return this.gastosServicios;
	}
	
	//M�TODOS.
	
	/*Este m�todo permite modificar el atributo gastosServicios,el cual guarda el total del gasto en el restaurante 
	 *y �rea de atracciones del cliente,por tal motivo no tiene par�metro de retorno. Recibe dos variables enteras 
	 *y una instancia cliente; "opcionCarta" que indica si se escogi� men� vegetariano o tradicional, "eleccion" que representa 
	 *el platillo que desea y "cliente" que permite saber a que servicio se le suma lo consumido,por medio del atributo 
	 *"cliente" de servicio.*/
	public void tipoMenu(int opcionCarta, int eleccion, Cliente cliente) {
		int valorTotalServicio = gastosServicios;

		if (opcionCarta == 1) {
			switch (eleccion) {
			case 1:
				valorTotalServicio = valorTotalServicio + 20000;
				cliente.getServicio().setGastosServicios(valorTotalServicio);
				break;

			case 2:
				valorTotalServicio = valorTotalServicio + 18000;
				cliente.getServicio().setGastosServicios(valorTotalServicio);
				break;

			case 3:
				valorTotalServicio = valorTotalServicio + 15000;
				cliente.getServicio().setGastosServicios(valorTotalServicio);
				break;

			case 4:
				valorTotalServicio = valorTotalServicio + 22000;
				cliente.getServicio().setGastosServicios(valorTotalServicio);
				break;

			case 5:
				valorTotalServicio = valorTotalServicio + 15000;
				cliente.getServicio().setGastosServicios(valorTotalServicio);
				break;
			}
		} else if (opcionCarta == 2) {
			switch (eleccion) {
			case 1:
				valorTotalServicio = valorTotalServicio + 15000;
				cliente.getServicio().setGastosServicios(valorTotalServicio);
				break;

			case 2:
				valorTotalServicio = valorTotalServicio + 18000;
				cliente.getServicio().setGastosServicios(valorTotalServicio);
				break;

			case 3:
				valorTotalServicio = valorTotalServicio + 25000;
				cliente.getServicio().setGastosServicios(valorTotalServicio);
				break;
			case 4:
				valorTotalServicio = valorTotalServicio + 15000;
				cliente.getServicio().setGastosServicios(valorTotalServicio);
				break;
			case 5:
				valorTotalServicio = valorTotalServicio + 20000;
				cliente.getServicio().setGastosServicios(valorTotalServicio);
				break;
			}
		}
	}

	/*Este m�todo permite modificar el atributo gastosServicios,el cual guarda el total del gasto en el restaurante 
	 *y �rea de atracciones del cliente,por tal motivo no tiene par�metro de retorno. Recibe una variable entera 
	 *y una instancia cliente; "eleccion" que representa la atracci�n que escogi� y "cliente" que permite saber a que 
	 *servicio se le suma lo consumido, por medio del atributo "cliente" de servicio.*/
	public void tipoAtraccion(int eleccion, Cliente cliente) {
		int valorTotalServicio = gastosServicios;

		switch (eleccion) {
		case 1:
			valorTotalServicio = valorTotalServicio + 15000;
			cliente.getServicio().setGastosServicios(valorTotalServicio);
			break;

		case 2:
			valorTotalServicio = valorTotalServicio + 15000;
			cliente.getServicio().setGastosServicios(valorTotalServicio);
			break;

		case 3:
			valorTotalServicio = valorTotalServicio + 10000;
			cliente.getServicio().setGastosServicios(valorTotalServicio);
			break;

		case 4:
			valorTotalServicio = valorTotalServicio + 20000;
			cliente.getServicio().setGastosServicios(valorTotalServicio);
			break;

		case 5:
			valorTotalServicio = valorTotalServicio + 8000;
			cliente.getServicio().setGastosServicios(valorTotalServicio);
			break;

		case 6:
			valorTotalServicio = valorTotalServicio + 8000;
			cliente.getServicio().setGastosServicios(valorTotalServicio);
			break;

		case 7:
			valorTotalServicio = valorTotalServicio + 10000;
			cliente.getServicio().setGastosServicios(valorTotalServicio);
			break;

		case 8:
			valorTotalServicio = valorTotalServicio + 15000;
			cliente.getServicio().setGastosServicios(valorTotalServicio);
			break;
		}

	}

}
