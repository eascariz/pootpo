package Avion;

import Drones.EntidadVoladora;

public class Avion extends EntidadVoladora{
	
	private int altitud;
	private int energia;
	
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
	
	public int obtenerPosicion() {
		
	}
	
	public boolean verificarEnergia() {
		
	}
	
	public void restarEnergia(int porcentaje) {
		
	}
	
	public void verificarAltitud(int alt) {
		if(alt >= 1000 && alt <= 5000) {
			this.altitud = alt;
		}
	}
}
