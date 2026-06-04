package Drones;

import java.util.Random;

public class Dron extends EntidadVoladora {
	private float velocidad;
	private Misil misil;
	
	public Dron(int posicionX, int posicionY, float velocidad, Misil misil) {
		super(posicionX, posicionY);
		// TODO Auto-generated constructor stub
		this.velocidad = velocidad;
		this.misil = misil;
	}

	@Override
	public void actualizarPosicion(String dir) {
		// TODO Auto-generated method stub
	}

	public void aumentarVelocidad(int porc) {
		velocidad = velocidad + (porc * velocidad / 100);
		misil.aumentarVelocidad(porc);
	}
	
	public int[] getPosicion() {
		return new int[] {posicionX, posicionY};
	}
	
	public void patronDron() {
		
	}
	
	public void Spawn() {
		Random random = new Random();
		int numero = random.nextInt(2); // genera 0 o 1
		if(numero == 0) {
			posicionX = 0;
		}
		else {
			posicionX = 800;
		}
	}
	
	public void lanzarMisil() {
		misil.newMisil(posicionX, posicionY, velocidad);
	}
}

/*
Dron — enemigo volador. 
Spawn() lo hace aparecer aleatoriamente a izquierda o derecha. 
aumentarVelocidad(porc) aumenta su velocidad y la del misil. 
lanzarMisil() configura el misil con la posición actual. 
patronDron() define su movimiento.
*/
