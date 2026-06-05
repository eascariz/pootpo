package Avion;

import Drones.EntidadVoladora;

public class Avion extends EntidadVoladora{
	
	private int altitud;
	private int energia;
	private int movimiento = 2;
	
	
	public Avion(int posicionX, int posicionY) {
		super(posicionX, posicionY);
		// TODO Auto-generated constructor stub
		this.altitud = 1000;
		this.energia = 100;
	}

	@Override
	public void actualizarPosicion(String dir) {
		// TODO Auto-generated method stub
		if("arriba".equals(dir)) {
			if(altitud <= 4998) {
				altitud = altitud + movimiento;
			}
		}
		else if("abajo".equals(dir)) {
			if(altitud > 1002) {
				altitud = altitud - movimiento;
			}
		}
		else if("izquierda".equals(dir)) {
			posicionX = posicionX - movimiento;
		}
		else if("derecha".equals(dir)) {
			posicionX = posicionX + movimiento;
		}
	}

	public String desplazar(String dir) {
		if(1000 <= altitud && altitud <= 5000) {
			actualizarPosicion(dir);
			return "Confirmado";
		}
		else {
			return "Denegado";
		}
	}
	
	public int[] obtenerPosicion() {
		return new int[] {posicionX, posicionY};
	}
	
	public boolean verificarEnergia() {
		if(energia <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void restarEnergia(int porcentaje) {
		energia = (energia - (energia * porcentaje / 100));
	}
	
	public void verificarAltitud(int alt) {
		if(alt >= 1000 && alt <= 5000) {
			this.altitud = alt;
		}
	}
}

// hola
/*  
Avion — el avión del jugador que el usuario controla.

Avion(int posicionX, int posicionY) — constructor que inicializa la posición y arranca con altitud 1000 y energía 100.
actualizarPosicion(String dir) — mueve el avión según la dirección. "izquierda" y "derecha" modifican posicionX, "arriba" y "abajo" modifican la altitud respetando el rango 1000-5000.
desplazar(String dir) — verifica que la altitud esté entre 1000 y 5000 antes de mover el avión. Retorna "Confirmado" o "Denegado".
obtenerPosicion() — retorna la posición actual como array [posicionX, posicionY].
verificarEnergia() — retorna true si la energía llegó a 0.
restarEnergia(int porcentaje) — descuenta energía según el porcentaje recibido.
verificarAltitud(int alt) — actualiza la altitud si el valor está dentro del rango válido.
*/
