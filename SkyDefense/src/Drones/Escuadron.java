package Drones;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Escuadron {
	private List<Dron> drones = new ArrayList();
	private List<Misil> misiles = new ArrayList<>();
	private int velocidad;
	private int contador = 0;

	public List<Dron> getDrones() {
		return drones;
	}

	public List<Misil> getMisiles() {
		return misiles;
	}

	public Dron getDron(int indice) {
		return drones.get(indice);
	}

	public Escuadron(int velocidad) {
		super();
		this.velocidad = velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void gestionarActivos() {
		if (contador < 10) {
			int espacioDisponible = 4 - cantidadDeEscuadrones();
			int restantes = 10 - contador;
			int maximoPosible = Math.min(espacioDisponible, restantes);

			if(maximoPosible > 0) {
				Random random = new Random();
				int cantidad = random.nextInt(maximoPosible) + 1;

				for (int i = 0; i < cantidad; i++) {
					Dron nuevoDron = new Dron(spawn(), random.nextInt(1000,5000), velocidad);
					drones.add(nuevoDron);
					contador++;
				}
			}
		}
	}

	public int spawn() {
		Random random = new Random();
		int numero = random.nextInt(2); // genera 0 o 1
		if (numero == 0) {
			return 0;
		} else {
			return 800;
		}
	}
	public int getContador() {
		return contador;
	}

	public void aumentarVelocidad(int porc) {
		velocidad = velocidad + (porc * velocidad / 100);
		for (int i = 0; i < drones.size(); i++) {
			drones.get(i).aumentarVelocidad(porc);
		}
		for (int i = 0; i < misiles.size(); i++) {
			misiles.get(i).aumentarVelocidad(porc);
		}
	}

	public int cantidadDeEscuadrones() {
		return drones.size();
	}

	public void patronEscuadron() {
		for (int i = 0; i < drones.size(); i++) {
			drones.get(i).patronDron();
			if(drones.get(i).debeDisparar()) {
				misiles.add(drones.get(i).lanzarMisil());
			}
		}
	}

	public boolean verificarRecorrido() {
		for (int i = drones.size() - 1; i >= 0; i--) {
			int posInicio = drones.get(i).getPosInicioX();
			int[] pos = drones.get(i).getPosicion();
			if (posInicio == 800) {
				if (pos[0] == 0) {
					drones.remove(i);
				}
			} else if (posInicio == 0) {
				if (pos[0] == 800) {
					drones.remove(i);
				}
			}
		}
		if(contador < 10) {
			gestionarActivos();
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
