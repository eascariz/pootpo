package Puntaje;

public class SistemaPuntaje {
	
	private int puntaje;

	public SistemaPuntaje(int puntaje) {
		super();
		this.puntaje = puntaje;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public boolean verificarPuntaje(int puntaje) {
		if(puntaje >= 1000) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void sumarPuntos(int punt) {
		puntaje = puntaje + punt;
	}
}

/*
SistemaPuntaje — maneja el puntaje del jugador.

SistemaPuntaje(int puntaje) — inicializa el puntaje.
getPuntaje() — retorna el puntaje actual.
verificarPuntaje(int puntaje) — retorna true si el puntaje llegó a 1000.
sumarPuntos(int punt) — agrega puntos al puntaje actual.
*/
