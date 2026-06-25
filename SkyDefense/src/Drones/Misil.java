package Drones;

import java.util.Random;
import java.util.random.RandomGenerator;

import Comun.Direccion;

public class Misil extends EntidadVoladora {

	private int altitudDeDetonacion;
	private int velocidadDeCaida;

	public Misil(int velocidadDeCaida, int posicionX, int posicionY) {
		super(posicionX, posicionY);
		Random random = new Random();
		// TODO Auto-generated constructor stub
		this.altitudDeDetonacion = random.nextInt(1200,posicionY);
		this.velocidadDeCaida = velocidadDeCaida;
	}


	public int[] getPosicion() {
		return new int[] {posicionX, posicionY};
	}

	@Override
	public void actualizarPosicion(Direccion dir) {
		posicionY = posicionY - velocidadDeCaida;
	}

	public boolean verificarAltitud() {
		if (altitudDeDetonacion >= posicionY) {
			return true;
		} else {
			return false;
		}
	}

	public void aumentarVelocidad(int porcentaje) {
		velocidadDeCaida = velocidadDeCaida + (porcentaje * velocidadDeCaida / 100);
	}

	public int limiteAltMisil() {
		Random random = new Random();
		return random.nextInt(1200, 4500);
	}

	public void newMisil(int posX, int posY, int vel) {
		this.posicionX = posX;
		this.posicionY = posY;
		this.altitudDeDetonacion = limiteAltMisil();
		this.velocidadDeCaida = vel;
	}

	public Explosion detonar(int radio) {
		return new Explosion(posicionX, posicionY, radio);
	}
}
/*
Misil — proyectil lanzado por el dron.

Misil(int altitudDeDetonacion, float velocidadDeCaida, int posicionX, int posicionY) — inicializa todos sus atributos.
verificarAltitud() — retorna true si llegó a la altitud de detonación.
limiteAltMisil() — genera una altitud aleatoria entre 1200 y 4500.
newMisil(int posX, int posY, float vel) — reinicia el misil con nuevos valores y genera altitud aleatoria.
detonar(int radio) — crea una Explosion en la posición actual.
aumentarVelocidad(int porcentaje) — incrementa la velocidad de caída.
*/
