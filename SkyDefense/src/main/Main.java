package main;

import Avion.Avion;
import Comun.Direccion;
import Drones.Escuadron;
import Drones.Misil;
import Drones.Explosion;
import Puntaje.Juego;
import Puntaje.SistemaPuntaje;

public class Main {

	public static void main(String[] args) {
		Avion avion = new Avion(300, 1500, 2);
		Escuadron escuadron = new Escuadron(800);
		SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
		Juego juego = new Juego(1, 3, avion, escuadron, sistemaPuntaje);

		System.out.println("=== INICIO DEL JUEGO ===");
		System.out.println("Nivel: " + juego.getNivel());
		System.out.println("Vidas: " + juego.getVidas());

		System.out.println("\n=== INICIAR NIVEL ===");
		juego.iniciarNivel();
		System.out.println("Drones activos: " + escuadron.cantidadDeEscuadrones());

		System.out.println("\n=== MOVIMIENTO DE AVION ===");
		System.out.println("Posicion inicial: " + avion.toString());
		juego.desplazar(Direccion.DERECHA);
		System.out.println("Después de mover derecha: " + avion.toString());
		juego.desplazar(Direccion.ARRIBA);
		System.out.println("Después de subir: " + avion.toString());

		System.out.println("\n=== LANZAMIENTO DE MISIL ===");
		Misil misil = escuadron.getDron(0).lanzarMisil();
		System.out.println("Misil creado: " + misil.toString());

		System.out.println("\n=== CAIDA DEL MISIL ===");
		for(int i = 0; i < 5; i++) {
			misil.actualizarPosicion(null);
			System.out.println("Posicion misil: " + misil.toString());
		}

		System.out.println("\n=== DETONACION ===");
		Explosion explosion = misil.detonar(50);
		System.out.println("Explosion creada en posicion del misil");
		juego.calcularDanio(explosion);
		System.out.println("Energia avion: " + avion.getEnergia());
		System.out.println("Vidas: " + juego.getVidas());
		System.out.println("Puntaje: " + sistemaPuntaje.getPuntaje());

		System.out.println("\n=== PASAR NIVEL ===");
		for(int i = 0; i < 10; i++) {
			escuadron.gestionarActivos();
		}
		escuadron.getDrones().clear();
		juego.pasarNivel();
		System.out.println("Nivel actual: " + juego.getNivel());
		System.out.println("Puntaje: " + sistemaPuntaje.getPuntaje());
		System.out.println("Vidas: " + juego.getVidas());
	}
}