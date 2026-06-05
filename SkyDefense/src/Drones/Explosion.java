package Drones;

import Avion.Avion;

public class Explosion {
	
	private int posicionX;
	private int posicionY;
	private int radio;
	
	
	public Explosion(int posicionX, int posicionY, int radio) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.radio = radio;
	}

	public int calcularDistancia(Avion avion) {
		int[] posicion = avion.obtenerPosicion();
		int posAvionX = posicion[0];
		int posAvionY = posicion[1];
		return (int) Math.sqrt(Math.pow((posAvionX - posicionX), 2) + Math.pow((posAvionY - posicionY), 2));
	}
	
	public void mostrar() {
		
	}
}

/*
Explosion — creada cuando detona un misil.

Explosion(int posicionX, int posicionY, int radio) — inicializa posición y radio.
calcularDistancia(Avion avion) — calcula la distancia al avión usando la fórmula euclidiana.
mostrar() — muestra la explosión en pantalla.
*/
