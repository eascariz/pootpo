package main;

import Avion.Avion;
import Drones.EntidadVoladora;
import Drones.Escuadron;
import Puntaje.Juego;

public class Main {

	public static void main(String[] args) {
/*
		// probar avion
		Avion avion = new Avion(3,2000,2);
		System.out.println("AVION");
		System.out.println(avion.toString());
		System.out.println("giro a la izquierda");
		avion.actualizarPosicion("izquierda");
		System.out.println(avion.toString());
		System.out.println("giro a la derecha");
		avion.actualizarPosicion("derecha");
		System.out.println(avion.toString());
		System.out.println("subio");
		avion.actualizarPosicion("arriba");
		System.out.println(avion.toString());
		System.out.println("bajo");
		avion.actualizarPosicion("abajo");
		System.out.println(avion.toString());
		System.out.println("ESCUADRO");
		
		// probar escuadron y drones
		Escuadron escuadron = new Escuadron(800);
		escuadron.gestionarActivos();
		System.out.println(escuadron.getDrones());
		for(int i = 0; i < escuadron.getDrones().size(); i++) {
			System.out.println(i);
		}
		if(escuadron.getDron(1).getPosInicioX() == 0) {
			escuadron.getDron(1).actualizarPosicion("derecha");
		}
		else {
			escuadron.getDron(1).actualizarPosicion("izquierda");
		}
		System.out.println("El dron 2 termino su recorrido");
		System.out.println("se elimino uno");
		escuadron.verificarRecorrido();
		System.out.println(escuadron.getDrones());
		escuadron.getDron(1).lanzarMisil();
*/
		Avion avion = new Avion(300,400,2);
		Juego juego = new Juego(1,3,avion,);
		

	}

}
