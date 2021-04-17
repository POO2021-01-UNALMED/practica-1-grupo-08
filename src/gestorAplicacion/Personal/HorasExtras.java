package gestorAplicacion.Personal;

public enum HorasExtras {
	DIURNA(4731), NOCTURNA(6624), DIURNADOMINICAL(7570), NOCTURNADOMINICAL(9463);
	
	private int precioHora;

	private HorasExtras(int x) {
		precioHora=x;
	}

	public int getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(int precioHora) {
		this.precioHora = precioHora;
	}
	
	

}
