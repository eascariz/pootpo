package Drones;

import java.util.ArrayList;
import java.util.List;

public class Escuadron {
	private List<Dron> drones = new ArrayList();
	private int velocidad;
	private int contador = 0;


	public Escuadron(int velocidad) {
		super();
		this.velocidad = velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void gestionarActivos() {
		if (contador < 10) {
			if (cantidadDeEscuadrones() < 4) {
				for (int i = 0; i < (4 - cantidadDeEscuadrones()); i++) {
					Dron nuevoDron = new Dron(0, 0, velocidad);
					nuevoDron.spawn();
					drones.add(nuevoDron);
					contador++;
				}
			}
		}
	}

	public void aumentarVelocidad(int porc) {
		velocidad = velocidad + (porc * velocidad / 100);
		for (int i = 0; i < drones.size(); i++) {
			drones.get(i).aumentarVelocidad(porc);
		}
	}

	public int cantidadDeEscuadrones() {
		return drones.size();
	}

	public void patronEscuadron() {
		for (int i = 0; i < drones.size(); i++) {
			drones.get(i).patronDron();
		}
	}

	public boolean verificarRecorrido() {
		for (int i = drones.size() - 1; i >= 0; i--) {
			int posInicio = drones.get(i).getPosInicioX();
			int[] pos = drones.get(i).getPosicion();
			if (posInicio == 800) {
				if (pos[0] == 0) {
					drones.remove(i);
					gestionarActivos();
				}
			} else if (posInicio == 0) {
				if (pos[0] == 800) {
					drones.remove(i);
					gestionarActivos();
				}
			}
		}
		return drones.isEmpty() && contador >= 10;
	}
}


/*
Escuadron — agrupa y gestiona los drones de una oleada.

Escuadron(int velocidad) — inicializa con la velocidad de los drones.
gestinarActivos() — crea nuevos drones si hay menos de 4 activos y el contador no llegó a 10.
aumentarVelocidad(int porc) — aumenta la velocidad de todos los drones.
cantidadDeEscuadrones() — retorna cuántos drones hay activos.
patronEscuadron() — coordina el movimiento de todos los drones.
verificarRecorrido() — elimina los drones que completaron su recorrido y llama a gestionarActivos.
 */
