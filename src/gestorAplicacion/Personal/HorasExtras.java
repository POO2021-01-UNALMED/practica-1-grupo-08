package gestorAplicacion.Personal;

public enum HorasExtras {
	DIURNA(4731), NOCTURNA(6624), DIURNADOMINICAL(7570), NOCTURNADOMINICAL(9463);
	
	private int horasPag;
	
	private HorasExtras(int x) {
		horasPag=x;
	}

	public int getHorasPag() {
		return horasPag;
	}

	public void setHorasPag(int horasPag) {
		this.horasPag = horasPag;
	}
	
}
