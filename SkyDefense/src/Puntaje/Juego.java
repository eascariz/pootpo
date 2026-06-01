package Puntaje;

import java.util.List;

import Avion.Avion;
import Drones.Dron;
import Drones.Escuadron;
import Drones.Explosion;

public class Juego {
	
	private int nivel;
	private int vidas;
	private Avion avion;
	private Escuadron escuadron;
	private Dron dron;
	private Explosion explosion;
	private SistemaPuntaje sistemaPuntaje;
	
	public Juego(int nivel, int vidas, Avion avion, Escuadron escuadron, Dron dron, Explosion explosion, SistemaPuntaje sistemaPuntaje) {
		super();
		this.nivel = nivel;
		this.vidas = vidas;
		this.avion = avion;
		this.escuadron = escuadron;
		this.dron = dron;
		this.explosion = explosion;
		this.sistemaPuntaje = sistemaPuntaje;
	}
	
	public void iniciarNivel() {
		
	}
	
	public void aumentarVelocidad(int porcentaje) {
		
	}
	
	public void verificarPuntaje() {
		
	}
	
	public void desplazar(String direccion) {
		avion.desplazar(direccion);
	}
	
	public List<String> generarPatron() {
		
	}
	
	
	public void calcularDanio() {
		int[] posicion = avion.obtenerPosicion();
	    int distancia = explosion.calcularDistancia(avion);
		if(distancia > 150) {
			sistemaPuntaje.sumarPuntos(40);
		}
		else if(80 < distancia && distancia <= 150) {
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
		
	}
	
	public int incrementarNivel() {
		
	}
	
	public void otorgarVidaExtra() {
		
	}
	
	public void restarVida() {
		
	}
	
	public void aumentarVidas() {
		
	}
}
