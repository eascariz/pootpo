package Drones;

public abstract class EntidadVoladora {
	protected int posicionX;
	protected int posicionY;

	public EntidadVoladora(int posicionX, int posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	public abstract void actualizarPosicion(String dir); {

	}

}

/*
EntidadVoladora — clase abstracta base de todos los objetos que vuelan. No se puede instanciar directamente.

EntidadVoladora(int posicionX, int posicionY) — inicializa la posición X e Y.
actualizarPosicion(String dir) — método vacío que cada subclase sobreescribe con su propia lógica de movimiento.
*/
