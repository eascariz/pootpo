package Drones;

public abstract class EntidadVoladora {
	protected int posicionX;
	protected int posicionY;
	
	public EntidadVoladora(int posicionX, int posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	public void actualizarPosicion(String dir) {
		
	}
	
}
