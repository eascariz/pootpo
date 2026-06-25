package Puntaje;

import java.util.ArrayList;
import java.util.List;

import Avion.Avion;
import Comun.Direccion;
import Drones.Escuadron;
import Drones.Explosion;

public class Juego {
	
	private int nivel;
	private int vidas;
	private Avion avion;
	private Escuadron escuadron;
	private SistemaPuntaje sistemaPuntaje;
	
	public Juego(int nivel, int vidas, Avion avion, Escuadron escuadron, SistemaPuntaje sistemaPuntaje) {
		super();
		this.nivel = nivel;
		this.vidas = vidas;
		this.avion = avion;
		this.escuadron = escuadron;
		this.sistemaPuntaje = sistemaPuntaje;
	}
	
	public int getNivel() {
		return nivel;
	}

	public int getVidas() {
		return vidas;
	}

	public Avion getAvion() {
		return avion;
	}

	public Escuadron getEscuadron() {
		return escuadron;
	}

	public SistemaPuntaje getSistemaPuntaje() {
		return sistemaPuntaje;
	}

	public void iniciarNivel() {
		escuadron.gestionarActivos();
	}
	
	public void aumentarVelocidad(int porcentaje) {
		escuadron.aumentarVelocidad(porcentaje);
	}
	
	public void desplazar(Direccion direccion) {
		avion.desplazar(direccion);
	}
	
	public List<String> generarPatron() {
		return new ArrayList<>();
	}

	public void calcularDanio(Explosion explosion) {
		int distancia = explosion.calcularDistancia(avion);
		//debug distancia
		//System.out.println("Distancia: " + distancia);

		if(distancia > 150) {
			sistemaPuntaje.sumarPuntos(40);
		}
		else if(distancia > 80 && distancia <= 150) {
			sistemaPuntaje.sumarPuntos(20);
			avion.restarEnergia(20);
			verificarEnergia();
		}
		else if(distancia > 20 && distancia <= 80) {
			avion.restarEnergia(40);
			verificarEnergia();
		}
		else if(distancia <= 20) {
			restarVida();
		}
	}

	public void pasarNivel() {
		boolean recorrido = escuadron.verificarRecorrido();
		//vista de drone y verificacion de nivel
		//System.out.println("verificarRecorrido: " + recorrido + " - drones: " + escuadron.cantidadDeEscuadrones() + " - contador: " + escuadron.getContador());

		if(recorrido) {
			sistemaPuntaje.sumarPuntos(300);
			nivel = incrementarNivel();
			aumentarVelocidad(15);
			verificarPuntaje();
			escuadron.reiniciar();
			iniciarNivel();
		}
	}
	public int incrementarNivel() {
		return nivel + 1;
	}

	public void restarVida() {
		vidas = vidas - 1;
		avion.resetearEnergia();
		gameOver();
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

	private boolean juegoTerminado = false;

	public boolean isJuegoTerminado() {
		return juegoTerminado;
	}

	public void gameOver() {
		if(vidas <= 0) {
			vidas = 0;
			juegoTerminado = true;
			//System.out.println("Game Over");
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
