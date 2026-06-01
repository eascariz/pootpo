package Drones;

import java.util.ArrayList;
import java.util.List;

public class Escuadron {
	private List<Dron> drones = new ArrayList();
	
	public void gestinarActivos() {
		for(int i = 0; i < drones.size(); i++) {
			drones.get(i).Spawn();
		}
	}
	
	public void aumentarVelocidad(int porc) {
		
	}
	
	public int cantidadDeEscuadrones() {
		
	}
	
	public void patronEscuadron() {
		for(int i = 0; i < drones.size(); i++) {
			drones.get(i).patronDron();
		}
	}
	
	public void verificarRecorrido() {
		
	}
	
}
