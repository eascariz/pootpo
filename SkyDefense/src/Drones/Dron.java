package Drones;

import Comun.Direccion;

public class Dron extends EntidadVoladora {
	private int velocidad;
	private int posInicioX;
	private int frecuenciaDisparo;
	private int contadorDisparo;

	public Dron(int posicionX, int posicionY, int velocidad) {
		super(posicionX, posicionY);
		this.velocidad = velocidad;
		this.posInicioX = posicionX;
		this.frecuenciaDisparo = 5;
		this.contadorDisparo = 0;
	}

	@Override
	public void actualizarPosicion(Direccion dir) {
		switch(dir) {
			case IZQUIERDA:
				posicionX = posicionX - velocidad;
				break;
			case DERECHA:
				posicionX = posicionX + velocidad;
				break;
		}
	}

	public void aumentarFrecuencia(int porc) {
		frecuenciaDisparo = frecuenciaDisparo + (porc * frecuenciaDisparo / 100);
	}

	public void aumentarVelocidad(int porc) {
		velocidad = velocidad + (porc * velocidad / 100);
	}

	public int[] getPosicion() {
		return new int[] {posicionX, posicionY};
	}

	public void patronDron() {
		if(posInicioX == 0) {
			actualizarPosicion(Direccion.DERECHA);
		}
		else if(posInicioX == 800) {
			actualizarPosicion(Direccion.IZQUIERDA);
		}
	}

	public int getPosInicioX() {
		return posInicioX;
	}

	public boolean debeDisparar() {
		contadorDisparo++;
		if(contadorDisparo >= frecuenciaDisparo) {
			contadorDisparo = 0;
			return true;
		}
		return false;
	}

	public Misil lanzarMisil() {
		return new Misil(velocidad, posicionX, posicionY);
	}
}