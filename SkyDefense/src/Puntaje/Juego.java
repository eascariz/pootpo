package Puntaje;

import java.util.ArrayList;
import java.util.List;

import Avion.Avion;
import Drones.Escuadron;
import Drones.Explosion;

public class Juego {
	
	private int nivel;
	private int vidas;
	private Avion avion;
	private Escuadron escuadron;
	private Explosion explosion;
	private SistemaPuntaje sistemaPuntaje;
	
	public Juego(int nivel, int vidas, Avion avion, Escuadron escuadron, Explosion explosion, SistemaPuntaje sistemaPuntaje) {
		super();
		this.nivel = nivel;
		this.vidas = vidas;
		this.avion = avion;
		this.escuadron = escuadron;
		this.explosion = explosion;
		this.sistemaPuntaje = sistemaPuntaje;
	}

	public void iniciarNivel() {
		escuadron.gestionarActivos();
		escuadron.patronEscuadron();
	}
	
	public void aumentarVelocidad(int porcentaje) {
		escuadron.aumentarVelocidad(porcentaje);
	}
	
	public void desplazar(String direccion) {
		avion.desplazar(direccion);
	}
	
	public List<String> generarPatron() {
		return new ArrayList<>();
	}


	public void calcularDanio() {
	    int distancia = explosion.calcularDistancia(avion);
		if(distancia > 150) {
			sistemaPuntaje.sumarPuntos(40);
		}
		else if(80 < distancia && distancia <= 150) {
			sistemaPuntaje.sumarPuntos(20);
			avion.restarEnergia(20);
		}
		else if(20 < distancia && distancia <= 80) {
			avion.restarEnergia(40);
		}
		else if(20 > distancia) {
			restarVida();
		}
	}

	public void pasarNivel() {
		if(escuadron.verificarRecorrido()) {
			sistemaPuntaje.sumarPuntos(300);
			nivel = incrementarNivel();
			aumentarVelocidad(15);
			verificarPuntaje();
		}
	}
	public int incrementarNivel() {
		return nivel + 1;
	}
	
	public void restarVida() {
		vidas = vidas - 1; gameOver();
	}
	
	public void aumentarVidas() {
		vidas = vidas + 1;
	}
	
	public void verificarEnergia() {
		if(avion.verificarEnergia()) {
			restarVida();
		}
	}

	public void verificarPuntaje() {
		if(sistemaPuntaje.verificarPuntaje(sistemaPuntaje.getPuntaje())) {
			otorgarVidaExtra();
		}
	}
	public void otorgarVidaExtra() {
		aumentarVidas();
	}
	public void gameOver() {
		if(vidas == 0) {
			escuadron.gestionarActivos(); // detiene nuevos spawns
			System.out.println("Game Over");
		}
	}

}

/*
Juego — controlador central del juego.

Juego(...) — inicializa todos los objetos del juego.
iniciarNivel() — inicia un nuevo nivel.
aumentarVelocidad(int porcentaje) — aumenta la velocidad del escuadrón.
desplazar(String direccion) — delega el movimiento al avión.
generarPatron() — retorna la lista de patrones de movimiento.
calcularDanio() — aplica daño según la distancia de la explosión al avión.
pasarNivel() — suma 300 puntos, incrementa el nivel y aumenta velocidades.
incrementarNivel() — retorna el nivel actual más 1.
restarVida() — resta una vida al jugador.
aumentarVidas() — suma una vida al jugador.
verificarEnergia() — resta una vida si el avión quedó sin energía.
verificarPuntaje() — otorga una vida extra si el puntaje llegó a 1000.
*/
