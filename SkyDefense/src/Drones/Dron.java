package Drones;

public class Dron extends EntidadVoladora {
	private int velocidad;
	private Misil misil;
	private int posInicioX;
	private int frecuenciaDisparo;
	
	public Dron(int posicionX, int posicionY, int velocidad) {
		super(posicionX, posicionY);
		// TODO Auto-generated constructor stub
		this.velocidad = velocidad;
		this.posInicioX = posicionX;
		this.misil = new Misil(0, velocidad, posicionX, posicionY);
	}
	
	@Override
	public void actualizarPosicion(String dir) {
		// TODO Auto-generated method stub
		if("izquierda".equals(dir)) {
			posicionX = posicionX - velocidad;
		}
		else if("derecha".equals(dir)) {
			posicionX = posicionX + velocidad;
		}
	}
	
	public void aumentarFrecuencia(int porc) {
		frecuenciaDisparo = frecuenciaDisparo + (porc * frecuenciaDisparo / 100);
	}
	
	public void aumentarVelocidad(int porc) {
		velocidad = velocidad + (porc * velocidad / 100);
		misil.aumentarVelocidad(porc);
	}
	
	public int[] getPosicion() {
		return new int[] {posicionX, posicionY};
	}
	
	public void patronDron() {
		if(posInicioX == 0) {
			actualizarPosicion("derecha");
		}
		else if(posInicioX == 800) {
			actualizarPosicion("izquierda");
		}
	}

	public int getPosInicioX() {
		return posInicioX;
	}

	public void lanzarMisil() {
		misil.newMisil(posicionX, posicionY, velocidad);
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
