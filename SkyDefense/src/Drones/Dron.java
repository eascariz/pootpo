package Drones;

import Comun.Direccion;

public class Dron extends EntidadVoladora {
	private int velocidad;
	private int posInicioX;
	private int frecuenciaDisparo;
	
	public Dron(int posicionX, int posicionY, int velocidad) {
		super(posicionX, posicionY);
		// TODO Auto-generated constructor stub
		this.velocidad = velocidad;
		this.posInicioX = posicionX;
	}
	
	@Override
	public void actualizarPosicion(Direccion dir) {
		// TODO Auto-generated method stub
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

	public Misil lanzarMisil() {
		return new Misil(0,velocidad,posicionX, posicionY);
	}

}

/*
Dron — enemigo volador que atraviesa la pantalla y lanza misiles.

Dron(int posicionX, int posicionY, float velocidad) — inicializa posición y velocidad.
Spawn() — aparece aleatoriamente en extremo izquierdo o derecho, guarda posInicioX y activa recorrido.
actualizarPosicion(String dir) — mueve el dron sumando o restando velocidad a posicionX.
aumentarVelocidad(int porc) — aumenta velocidad del dron y de su misil.
getPosicion() — retorna [posicionX, posicionY].
getPosInicioX() — retorna la posición inicial para verificar recorrido.
patronDron() — mueve el dron hacia la dirección correcta según posInicioX.
lanzarMisil() — configura y lanza el misil con la posición actual.
aumentarFrecuencia(int porc) — aumenta la frecuencia de disparo según el porcentaje.
 */
