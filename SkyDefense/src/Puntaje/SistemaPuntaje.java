package Puntaje;

public class SistemaPuntaje {
	private int puntaje;
	private int umbral = 1000;
	private static int highScore = 0;

	public static int getHighScore() {
		return highScore;
	}

	public void actualizarHighScore() {
		if(puntaje > highScore) {
			highScore = puntaje;
		}
	}

	public SistemaPuntaje() {
		this.puntaje = 0;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public boolean verificarPuntaje(int puntajeActual) {
		if(puntajeActual >= umbral) {
			umbral += 1000;
			return true;
		}
		return false;
	}

	public void sumarPuntos(int puntos) {
		puntaje += puntos;
	}
}

/*
SistemaPuntaje — maneja el puntaje del jugador.

SistemaPuntaje(int puntaje) — inicializa el puntaje.
getPuntaje() — retorna el puntaje actual.
verificarPuntaje(int puntaje) — retorna true si el puntaje llegó a 1000.
sumarPuntos(int punt) — agrega puntos al puntaje actual.
*/
