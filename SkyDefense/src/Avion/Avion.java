package Avion;

import Drones.EntidadVoladora;

public class Avion extends EntidadVoladora{
	
	private int altitud;
	private double energia;
	
	
	public Avion(int posicionX, int posicionY) {
		super(posicionX, posicionY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actualizarPosicion(String dir) {
		// TODO Auto-generated method stub
		
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


/* 
Avion — el avión del jugador. 
desplazar(dir) mueve el avión si la altitud está entre 1000 y 5000 metros. 
obtenerPosicion() retorna su posición. 
verificarEnergia() retorna true si la energía llegó a 0. 
restarEnergia(porcentaje) descuenta energía según el porcentaje. 
verificarAltitud(alt) actualiza la altitud si está en rango válido.
*/
